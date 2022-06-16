<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center">${heading}</h1>
<h4>Student List</h4>

<table>
<tr>
<td>Roll Number</td>
<td>Student Name</td>
<td>Mark Scored</td>
</tr>
<tr>
<td>${added.rollNumber}</td>
<td>${added.studentName}</td>
<td>${added.mark}</td>
</tr>

</table>
</body>
</html>