<%@include file="/html/init.jsp"%>
<%
	List<Student> students = (List<Student>) request.getAttribute("students");
	String searchName = (String) request.getAttribute("search_name");
%>
<liferay-ui:success key="success" message="Update student success"/>
<portlet:actionURL name="searchStudent" var="searchAction"/>
<aui:form action="<%= searchAction %>">
	<div class="search-form">
		<span class="aui-search-bar"> 
			<aui:input
				inlineField="<%= true %>" label="" name="search_name" size="30"
				title="search-entries" type="text" value="<%= searchName %>" />
			<aui:button type="submit" value="search" />
		</span>
	</div>
</aui:form>

<liferay-ui:search-container>
	<liferay-ui:search-container-results results="<%= students %>"/>
	<liferay-ui:search-container-row
		className="com.codeengine.studentmanagement.model.Student" modelVar="student">
		<liferay-ui:search-container-column-text property="name" />
		<liferay-ui:search-container-column-text property="email" />
		<liferay-ui:search-container-column-jsp
			path="/html/student/student_actions.jsp" align="right"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<c:if
	test='<%= StudentPermission.contains(permissionChecker,
						scopeGroupId, "ADD_STUDENT") %>'>
	<aui:button-row cssClass="student-buttons">
		<portlet:renderURL var="addStudentURL">
			<portlet:param name="mvcPath" value="/html/student/edit.jsp"></portlet:param>
		</portlet:renderURL>
		<aui:button onClick="<%= addStudentURL.toString() %>" value="add.student"/>
	</aui:button-row>
</c:if>