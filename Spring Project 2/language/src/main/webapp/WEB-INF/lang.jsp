<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>name</th>
            <th>creator</th>
            <th>version</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${language.name}"/></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td>
            	<a href="/languages/${language.id}/edit">edit</a>
            	<a href="/languages/${language.id}/delete">delete</a>
            </td>
        </tr>
    </tbody>
</table>
<a href="/languages">DashBoard</a>

</body>
</html>