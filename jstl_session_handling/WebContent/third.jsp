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


Your Current Location is <c:out value="${city}"/>

Rating := <c:out value="${rating}"/>

</body>
</html>