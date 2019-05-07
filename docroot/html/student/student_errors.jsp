<%@include file="/html/init.jsp"%>
<%
	List<String> errors = (List<String>) request.getAttribute("errors");
%>

<c:forEach var="err" items="<%= errors %>">
	<liferay-ui:error key="error" message="${ err }"/>
</c:forEach>