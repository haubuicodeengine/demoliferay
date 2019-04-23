<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry"%>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow"%>

<%@ page import="com.codeengine.util.WebKeys"%>

<%@ page import="com.codeengine.service.model.Student"%>
<%@ page
	import="com.codeengine.service.service.permission.StudentModelPermission"%>
<%@page import="com.codeengine.service.service.StudentLocalServiceUtil"%>

<portlet:defineObjects />
<theme:defineObjects />

<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js" ></script>
