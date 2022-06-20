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
<jsp:useBean id="loginBean" scope="session" class="com.example.demo.model.User"/>

<jsp:setProperty name="loginBean" property="*"/> 

<c:set value="${loginBean.validate()}" var="result"/>

Result <c:out value="${result}"/>

<c:if test="${result}">
<jsp:forward page="showBook.jsp"/>
</c:if>

<c:if test="${!result}">
<jsp:forward page="index.jsp">
<jsp:param value="Invalid UserName or Password" name="errorMessage"/>
</jsp:forward>
</c:if>


</body>
</html>