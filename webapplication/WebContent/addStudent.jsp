<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h1 style="text-align: center">${heading}</h1>


<h4>Add Student</h4>

<form action="show" method="post">

<label>Roll Number</label>
<input type="text" name="rollNumber">

<label>Student Name</label>
<input type="text" name="studentName">

<label>Mark Scored</label>
<input type="text" name="mark">

<input type="submit" value="Add">
</form>


</body>
</html>