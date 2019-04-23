<%@include file="/html/init.jsp"%>

<%
	String mvcPath = ParamUtil.getString(request, "mvcPath");

	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	
	Student student = (Student) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getUserId())%>" />
		<portlet:param name="mvcPath" value="/html/student/edit.jsp" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" message="Edit"
		url="<%=editURL.toString()%>" />

	<portlet:actionURL name="deleteStudent" var="deleteURL">
		<portlet:param name="studentId"
			value="<%=String.valueOf(student.getUserId())%>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%=deleteURL.toString()%>" />
</liferay-ui:icon-menu>