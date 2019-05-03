package com.codeengine.studentmanagement.portlet;

import java.io.IOException;
import java.util.*;

import javax.portlet.*;

import com.codeengine.studentmanagement.model.Student;
import com.codeengine.studentmanagement.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
	 */
	public void addOrUpdateStudent(ActionRequest request,
			ActionResponse response) throws PortalException, SystemException {
		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		long studentId = ParamUtil.getLong(request, "studentId");
		try {
			validateStudent(name, email);
			StudentLocalServiceUtil.addOrUpdateStudent(studentId, name, email);
			SessionMessages.add(request, "StudentAddedOrUpdated");
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/html/student/edit.jsp");
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
			StudentLocalServiceUtil.deleteStudent(studentId);
		} catch (Exception e) {
			SessionErrors.add(request, e.getClass().getName());
		}
	}

	/**
	 * Default render
	 */
	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {
		try {
			PortletPreferences prefs = renderRequest.getPreferences();
			String searchName = GetterUtil.getString(
					prefs.getValue(SEARCH_NAME, null), null);
			List<Student> listStudents = new ArrayList<>();
			if (Validator.isNotNull(searchName)) {
				prefs.reset(SEARCH_NAME);
				prefs.store();
				renderRequest.setAttribute(SEARCH_NAME, searchName);
			}
			listStudents = StudentLocalServiceUtil.findByName(searchName);
			renderRequest.setAttribute("listStudents", listStudents);
		} catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass().getName());
		}
		super.render(renderRequest, renderResponse);
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
			throws ReadOnlyException, ValidatorException, IOException {
		String keyword = ParamUtil.getString(request, SEARCH_NAME);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(SEARCH_NAME, keyword);
		prefs.store();
	}

	/**
	 * Validate email and name
	 * 
	 * @param name
	 * @param email
	 * @throws PortalException
	 */
	private void validateStudent(String name, String email)
			throws PortalException {
		if (Validator.isNull(name)) {
			throw new PortalException("Missing name field");
		} else if (Validator.isNull(email)) {
			throw new PortalException("Missing email field");
		}
	}

	private static final String SEARCH_NAME = "search_name";
}
