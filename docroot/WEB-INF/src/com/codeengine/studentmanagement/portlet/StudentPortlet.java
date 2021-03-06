
package com.codeengine.studentmanagement.portlet;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.portlet.*;
import com.codeengine.studentmanagement.exception.StudentException;
import com.codeengine.studentmanagement.model.Student;
import com.codeengine.studentmanagement.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class Student
 */
public class StudentPortlet extends MVCPortlet {

	/**
	 * Add or update student
	 * 
	 * @param request
	 * @param response
	 * @throws PortalException
	 * @throws SystemException
	 * @throws InterruptedException 
	 */
	public void addOrUpdateStudent(
			ActionRequest request, ActionResponse response)
		throws PortalException, SystemException, InterruptedException {

		long companyId = PortalUtil.getCompanyId(request);
		
		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		long studentId = ParamUtil.getLong(request, "studentId");
		try {
			StudentLocalServiceUtil.addOrUpdateStudent(companyId, studentId, name, email);
			TimeUnit.SECONDS.sleep(1);
			SessionMessages.add(request, "success");
		}
		catch (PortalException e) {
			StudentException studentException = (StudentException) e;
			SessionErrors.add(request, "error");
			request.setAttribute("errors", studentException.getErrors());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", EDIT_URL);
		}
	}

	/**
	 * Delete student
	 * 
	 * @param request
	 * @param response
	 */
	public void deleteStudent(ActionRequest request, ActionResponse response) {

		long studentId = ParamUtil.getLong(request, "studentId");
		try {
			StudentLocalServiceUtil.deleteStudentIndexer(studentId);
		}
		catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	/**
	 * Default render
	 */
	@Override
	public void render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		try {
			long companyId = PortalUtil.getCompanyId(renderRequest);
			PortletPreferences prefs = renderRequest.getPreferences();
			String searchName =
				GetterUtil.getString(prefs.getValue(
					SEARCH_NAME, StringPool.BLANK));
			if (Validator.isNotNull(searchName)) {
				prefs.reset(SEARCH_NAME);
				prefs.store();
				renderRequest.setAttribute(SEARCH_NAME, searchName);
			}
			List<Student> students =
				StudentLocalServiceUtil.findByName(companyId, searchName);
			renderRequest.setAttribute("students", students);
			super.render(renderRequest, renderResponse);
		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass().getName());
		}
	};

	/**
	 * Search student by name
	 * 
	 * @param request
	 * @param response
	 * @throws ReadOnlyException
	 * @throws ValidatorException
	 * @throws IOException
	 */
	public void searchStudent(ActionRequest request, ActionResponse response)
		throws PortalException {

		try {
			String keyword = ParamUtil.getString(request, SEARCH_NAME);
			PortletPreferences prefs = request.getPreferences();
			prefs.setValue(SEARCH_NAME, keyword);
			prefs.store();
		}
		catch (Exception e) {
			throw new PortalException(e.getMessage());
		}
	}

	private static final String EDIT_URL = "/html/student/edit.jsp";
	private static final String SEARCH_NAME = "search_name";
}
