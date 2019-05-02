package com.codeengine.StudentManagement.Portlet;

import java.io.IOException;
import java.util.*;

import javax.portlet.*;

import com.codeengine.StudentManagement.model.Student;
import com.codeengine.StudentManagement.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
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
			if (studentId > 0) {
				StudentLocalServiceUtil.updateStudent(studentId, name, email);
				SessionMessages.add(request, "StudentUpdateded");
			} else {
				StudentLocalServiceUtil.addStudentManual(name, email);
				SessionMessages.add(request, "StudentAdded");
			}
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
			String search_name = prefs.getValue(_SEARCH_NAME, null);
			List<Student> listStudents = new ArrayList<>();
			if (search_name != null) {
				prefs.reset(_SEARCH_NAME);
				prefs.store();
				renderRequest.setAttribute(_SEARCH_NAME, search_name);
			} else {
				search_name = "";
			}
			listStudents = StudentLocalServiceUtil.findByName(search_name);
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
		String keyword = ParamUtil.getString(request, _SEARCH_NAME);
		PortletPreferences prefs = request.getPreferences();
		prefs.setValue(_SEARCH_NAME, keyword);
		prefs.store();
	}

	private static final String _SEARCH_NAME = "search_name";
}
