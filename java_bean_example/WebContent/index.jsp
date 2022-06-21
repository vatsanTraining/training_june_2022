<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Bank</title>
</head>
<body>

<%@ include file="header.html"%>

<div>
<p style="color: red"><c:out value="${param.errorMessage}"/></p>

<form action="handleLogin.jsp">
	<label for="">User Name</label>
	<input type="text" name="userName" />
	<label for="">Password</label>
	<input type="password" name="password" />
	<input type="submit" value="login">
</form>

</div>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>