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
<a href="/songs/new">Add new</a> <br>
<a href="/songs/top">Top Songs</a>
<form action="/search">
	<input type="text" name="artist"/>
	<button>Search Artists</button>
</form>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.name}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/delete/${song.id}">delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>