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
<h1><c:out value="${person.firstName} ${person.lastName}"/></h1>
<table>
    <thead>
        <tr>
            <th>License Number</th>
            <th>State</th>
            <th>Expiration Date</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td><c:out value="${license.number}"/></td>
            <td><c:out value="${license.state}"/></td>
            <td><c:out value="${license.expirationDate}"/></td>
        </tr>
    </tbody>
</table>
</body>
</html>