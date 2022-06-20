<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:out value="${pageContext.session.id}" />

<c:if test="${!empty sessionScope.name}">

Welcome:<c:out value="${name}"/>

</c:if>

<c:if test="${empty sessionScope.name}">

Welcome:<c:out value="Guest"/>

</c:if>

<ol>
<c:forEach items="${paramValues.bookName}" var="eachBook">
<li>	<c:out value="${eachBook}"/></li>
</c:forEach>
</ol>

<a href="second.jsp">Second</a>

</body>
</html>