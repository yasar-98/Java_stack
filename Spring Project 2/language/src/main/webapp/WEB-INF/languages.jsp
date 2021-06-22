<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    

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
        <c:forEach items="${language}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"> <c:out value="${language.name}"/> </a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td>
            	<a href="/languages/${language.id}/edit">edit</a>
            	<a href="/languages/${language.id}/delete">delete</a>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<h1>New language</h1>
<form:form action="/languages" method="post" modelAttribute="language2">
    <p>
        <form:label path="name">name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
  
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>