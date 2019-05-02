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

<%@ page import="com.codeengine.StudentManagement.model.Student"%>
<%@ page
	import="com.codeengine.StudentManagement.service.permission.StudentPermission"%>
<%@page import="com.codeengine.StudentManagement.service.StudentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<portlet:defineObjects />
<theme:defineObjects />

