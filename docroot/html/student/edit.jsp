<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@include file="/html/init.jsp"%>

<liferay-ui:error key="please.enter.name" message="please.enter.name"/>
<liferay-ui:error key="name.must.from.3.to.10.character" message="name.must.from.3.to.10.character"/>
<liferay-ui:error key="please.enter.email" message="please.enter.email"/>
<liferay-ui:error key="please.enter.correct.email.format" message="please.enter.correct.email.format"/>
<h4><liferay-ui:message key="add.edit.student"/></h4>
<%
	long studentId = ParamUtil.getLong(renderRequest, "studentId");
	Student student = null;
	if (studentId > 0) {
		student = StudentLocalServiceUtil.getStudent(studentId);
	}
%>
<portlet:renderURL var="listStudentURL">
	<portlet:param name="mvcPath" value="/html/student/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="addOrUpdateStudent" var="addStudentURL"/>
<aui:form action="<%= addStudentURL %>" name="<portlet:namespace />">
	<aui:model-context bean="<%= student %>" model="<%= Student.class %>" />
	<aui:fieldset>
		<aui:input name="studentId" type="hidden"
			value="<%= Validator.isNotNull(student) ? student.getUserId() : 0 %>" />
		<aui:input name="name">
			<aui:validator name="required" errorMessage="please.enter.name" />
		</aui:input>
		<aui:input name="email">
			<aui:validator name="email" errorMessage="please.enter.correct.email.format"/>
			<aui:validator name="required" errorMessage="please.enter.email"/>
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%=listStudentURL.toString()%>"/>
	</aui:button-row>
</aui:form>