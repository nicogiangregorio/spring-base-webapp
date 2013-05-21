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
	<%=SecurityContextHolder.getContext().getAuthentication().getName()%>
	<sec:authentication property="principal"/>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
	Not authenticated
</sec:authorize>
</body>
</html>