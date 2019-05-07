
package com.codeengine.studentmanagement.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.portlet.PortletURL;

import com.codeengine.service.service.persistence.StudentActionableDynamicQuery;
import com.codeengine.studentmanagement.model.Student;
import com.codeengine.studentmanagement.service.StudentLocalServiceUtil;
import com.codeengine.studentmanagement.service.permission.StudentPermission;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;

public class StudentIndexer extends BaseIndexer {

	public StudentIndexer() {

		setPermissionAware(true);
	}

	@Override
	public String[] getClassNames() {

		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {

		return PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj)
		throws Exception {

		Student student = (Student) obj;

		deleteDocument(student.getCompanyId(), student.getUserId()); // need
																		// recheck;
	}

	@Override
	protected Document doGetDocument(Object obj)
		throws Exception {

		Student student = (Student) obj;
		Document document = getBaseModelDocument(PORTLET_ID, student);

		document.addText("name", student.getName());
		document.addText("email", student.getEmail());

		document.addNumber(Field.COMPANY_ID, student.getCompanyId());
		return document;
	}

	@Override
	protected Summary doGetSummary(
			Document document, Locale locale, String snippet, PortletURL portletURL)
		throws Exception {

		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void doReindex(Object obj)
		throws Exception {

		Student student = (Student) obj;
		Document document = getDocument(student);
		SearchEngineUtil.updateDocument(
			getSearchEngineId(), student.getCompanyId(), document);
	}
	
	@Override
	protected void doReindex(String[] ids)
		throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexStudent(companyId);
	}

	@Override
	protected void doReindex(String className, long studentId)
		throws Exception {

		Student student = StudentLocalServiceUtil.getStudent(studentId);
		doReindex(student);
	}

	@Override
	protected String getPortletId(SearchContext arg0) {

		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

		return StudentPermission.contains(
			permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	protected void reindexStudent(long companyId)
		throws SystemException, PortalException {

		final Collection<Document> documents = new ArrayList<>();
		ActionableDynamicQuery actionableDynamicQuery =
			new StudentActionableDynamicQuery() {

				@Override
				protected void performAction(Object obj)
					throws PortalException, SystemException {

					Student student = (Student) obj;
					Document document = getDocument(student);
					documents.add(document);
				}
			};
		actionableDynamicQuery.setCompanyId(companyId);
		actionableDynamicQuery.performActions();
		SearchEngineUtil.updateDocuments(
			getSearchEngineId(), companyId, documents);
	}
	
	@Override
	public void postProcessSearchQuery(
		BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {
	
		addSearchTerm(searchQuery, searchContext, "name", false);
		LinkedHashMap<String, Object> params =
						(LinkedHashMap<String, Object>)searchContext.getAttribute("params");

					if (params != null) {
						String expandoAttributes = (String)params.get("expandoAttributes");

						if (Validator.isNotNull(expandoAttributes)) {
							addSearchExpando(searchQuery, searchContext, expandoAttributes);
						}
					}
	}

	public static final String[] CLASS_NAMES = {
		Student.class.getName()
	};
	public static final String PORTLET_ID = "student-portlet";

}
