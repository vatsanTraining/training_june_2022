<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Session Handling</title>
</head>
<body>
<c:out value="${pageContext.session.id}" />



<c:set value="Ramesh" scope="session" var="name"/>

<a href="first.jsp">First</a>

<a href="welcome">Home</a>
</body>
</html>