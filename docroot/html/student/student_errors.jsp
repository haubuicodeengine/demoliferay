<%@include file="/html/init.jsp"%>
<%
	List<String> errors = (List<String>)GetterUtil.getObject(request.getAttribute("errors"), new ArrayList());
%>

<c:forEach var="err" items="<%= errors %>">
	<liferay-ui:error key="error" message="${ err }"/>
</c:forEach>