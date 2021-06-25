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
Top ten songs:
<div>
<table>
    <thead>
        <tr>
             <th>Rating</th>
             <th>Name</th>
            <th>Artist</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.rating}"/></td>
            <td><c:out value="${song.name}"/></td>
            <td><c:out value="${song.artist}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/dashboard">Dashboard</a>

</div>
</body>
</html>