<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Submitted Info
<table>
<tr>
	<td>Name</td>
	<td><c:out value="${name}"/></td>
</tr>
<tr>
	<td>Dojo Location</td>
	<td><c:out value="${location}"/></td>
</tr>
<tr>
	<td>Fav Language</td>
	<td><c:out value="${laguage}"/></td>
</tr>
<tr>
	<td>Comment</td>
	<td><c:out value="${comment}"/></td>
</tr>
</table>
<button><a href="/">Go Back</a></button>
</body>
</html>