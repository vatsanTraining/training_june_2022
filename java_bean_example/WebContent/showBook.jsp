<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
<style type="text/css">

table{
border: 1px solid blue;
}
tr,th,td{

border: 1px solid blue;
border-collapse: collapse;
}

</style>

</head>
<body>

<%@ include file="header.html"%>

<jsp:useBean id="service" class="com.training.services.BookService" scope="request"/>

<table>
	<tr>
		<th>Book Number</th>
		<th>Book Name</th>
		<th>Author Name</th>
		<th>Price</th>
	</tr>
	
	<c:set var="books" value="${service.findAll()}"/>
	
<c:forEach items="${books}" var="eachBook">

<tr>
	<td><c:out value="${eachBook.bookNumber}"/>	</td>
	<td><c:out value="${eachBook.bookName}"/>	</td>
	<td><c:out value="${eachBook.authorName}"/> </td>
	<td><c:out value="${eachBook.price}"/>	</td>
	
	
	<td><a href="edit?id=<c:out value='${eachBook.bookNumber}' />">Edit</a></td>
	<td><a href="delete?id=<c:out value='${eachBook.bookNumber}' />">Delete</a></td>
</tr>

</c:forEach>
</table>
<hr/>
<jsp:include page="footer.jsp"/>

</body>
</html>