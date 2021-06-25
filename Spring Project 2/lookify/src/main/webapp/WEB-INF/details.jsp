<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page isErrorPage="false" %>       
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${song.name}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
        </tr>
    </tbody>
</table>
<a href="/delete/${song.id}">delete</a>

</body>
</html>