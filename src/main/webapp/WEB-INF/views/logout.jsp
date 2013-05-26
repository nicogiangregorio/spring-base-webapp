<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.username"/>
	<sec:authentication property="principal.name"/>
	<sec:authentication property="principal.lastName"/>
	<sec:authentication property="principal.email"/>
</sec:authorize>
</body>
</html>