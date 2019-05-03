
package com.codeengine.studentmanagement.portlet;

import java.io.IOException;
import java.util.*;

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
	 */
	public void addOrUpdateStudent(
			ActionRequest request, ActionResponse response)
		throws SystemException {

		String name = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		long studentId = ParamUtil.getLong(request, "studentId");
		try {
			StudentLocalServiceUtil.addOrUpdateStudent(studentId, name, email);
			SessionMessages.add(request, "success");
		}
		catch (PortalException e) {
			SessionErrors.add(request, "error");
			StudentException studentException = (StudentException) e;
			for (String err : studentException.getErrors()) {
				SessionErrors.add(request, err);
			}
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
			StudentLocalServiceUtil.deleteStudent(studentId);
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
			PortletPreferences prefs = renderRequest.getPreferences();
			String searchName =
				GetterUtil.getString(prefs.getValue(
					SEARCH_NAME, StringPool.BLANK));
			List<Student> students = new ArrayList<>();
			if (Validator.isNotNull(searchName)) {
				prefs.reset(SEARCH_NAME);
				prefs.store();
				renderRequest.setAttribute(SEARCH_NAME, searchName);
			}
			students = StudentLocalServiceUtil.findByName(searchName);
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
