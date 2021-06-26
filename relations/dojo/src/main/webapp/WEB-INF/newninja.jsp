<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>New Ninja</h1>
<form:form action="/ninja/new" method="post" modelAttribute="ninja">
    <p>
        <form:label path="dojo">Dojo</form:label>
        <form:errors path="dojo"/>
		<form:select  path="dojo">
    		<c:forEach items="${dojos}" var="dojo">
		        <form:option value="${dojo.id}">${dojo.name}</form:option>
		     </c:forEach>
    	</form:select>       
    </p>
    <p>
        <form:label path="firstName">first Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="age">Age</form:label>
        <form:errors path="age"/>
        <form:input path="age"/>
    </p>
    
    <input type="submit" value="Create"/>
</form:form>    

</body>
</html>