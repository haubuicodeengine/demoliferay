<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="/html/init.jsp"%>
<%
	String errorMessage = GetterUtil.getString(ParamUtil.getString(renderRequest, "errorMessage"), "");
%>
<liferay-ui:error key="error" message="<%= errorMessage %>" />
<h4>Add/Edit Student</h4>
<%
	long studentId = ParamUtil.getLong(renderRequest, "studentId");
	Student student = null;
	if (studentId > 0) {
		student = StudentLocalServiceUtil.getStudent(studentId);
	}
%>
<portlet:renderURL var="listStudentURL">
	<portlet:param name="mvcPath" value="/html/student/view.jsp"></portlet:param>
</portlet:renderURL>
<portlet:actionURL name="addOrUpdateStudent" var="addStudentURL"></portlet:actionURL>
<aui:form action="<%= addStudentURL %>" name="<portlet:namespace />">
	<aui:model-context bean="<%= student %>" model="<%= Student.class %>" />
	<aui:fieldset>
		<aui:input name="studentId" type="hidden"
			value="<%= Validator.isNotNull(student) ? student.getUserId() : 0 %>" />
		<aui:input name="name">
			<aui:validator name="required" errorMessage="inputName" />
		</aui:input>
		<aui:input name="email">
			<aui:validator name="email" />
			<aui:validator name="required" />
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" onClick="<%=listStudentURL.toString()%>"></aui:button>
	</aui:button-row>
</aui:form>