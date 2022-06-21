<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
<%@ include file="header.html" %>
<div>

<p style="color: green"><c:out value="${message}"/></p>
</div>

<form action="books" method="post">

<div><label for="bookNumber">Book Number</label><input type="text" name="bookNumber" /></div>
<div><label for="bookName">Book Name</label><input type="text" name="bookName" /></div>
<div><label for="author">Author Name</label><input type="text" name="authorName" /></div>
<div><label for="price">Price</label><input type="text" name="price"/></div>


<input type="submit" value="Add">
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>