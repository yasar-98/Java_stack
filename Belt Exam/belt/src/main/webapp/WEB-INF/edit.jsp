<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit <strong>${ event.name }</strong></h2>
	<form:form action="/events/${ event.id }/edit" method="post" modelAttribute="event">
		<input type="hidden" name="_method" value="put">
		<form:hidden value="${ user.id }" path="planner"/>
		<form:label path="name">Name</form:label>
		<form:errors path="name"></form:errors>
		<form:input  path="name"></form:input>
		
		<form:label path="date">Date</form:label>
		<form:errors path="date"></form:errors>
		<form:input  type="date" path="date"></form:input>
        <form:label path="location">Location</form:label>
        <form:errors path="location"/>
        <form:input path="location" />
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
		<form:select path="state">
			<c:forEach items="${ states }" var="state">
				<c:choose>
					<c:when  test="${ state.equals(event.state) }">
						<option selected value="${ state }">${ state }</option>
					</c:when>
					<c:otherwise>
						<option value="${ state }">${ state }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</form:select>
	    <button>Update Event</button>
	</form:form>
</body>
</html>