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
<p>You have visited <a href="/">http://your_server</a> <c:out value="${count}"/> times</p>
<a href="/">Test another visit</a>
<a href="/reset">reset the num of visits</a>
</body>
</html>