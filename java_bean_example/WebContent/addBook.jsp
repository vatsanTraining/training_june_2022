<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>

<form action="books" method="post">

<div><label for="bookNumber">Book Number</label><input type="text" name="bookNumber" /></div>
<div><label for="bookName">Book Name</label><input type="text" name="bookName" /></div>
<div><label for="author">Author Name</label><input type="text" name="authorName" /></div>
<div><label for="price">Price</label><input type="text" name="price"/></div>


<input type="submit" value="Add">
</form>

</body>
</html>