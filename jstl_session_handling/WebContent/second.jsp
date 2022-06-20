<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!--  -->
</head>
<body>
<c:out value="${pageContext.session.id}" />

Welcome:<c:out value="${name}"/>

<c:set value="Chennai" scope="request" var="city"/>

<% session.invalidate(); %>

<jsp:forward page="third.jsp"/>

<%-- <a href="third.jsp">Third</a> --%>

</body>
</html>