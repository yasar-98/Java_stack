<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome</title>
</head>
<body>
	<a href="/logout">Logout</a>
	<h1>Welcome, <c:out value="${user.firstname}" /></h1>
	<h3>Her are some of the events in your state</h3>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ eventState }" var="event">
			<tr>
				<td><a href="/events/${ event.id }">${ event.name }</a></td>
				<td>${ event.date }</td>
				<td>${ event.location }</td>
				<td>${ event.planner.firstname }</td>
				<td>
				<c:choose>
					<c:when test="${ event.planner.id == user.id }">
						<a href="/events/${ event.id }/edit">Edit</a> |
						<form action="/events/${ event.id }/delete" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button>Delete</button>
						</form>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${ event.attenders.contains(user) }">
								<span>Joining <a href="/events/${ event.id }/a/cancel">Cancel</a></span>
							</c:when>
							<c:otherwise>
								<a href="/events/${ event.id }/a/join">Join</a>								
							</c:otherwise>
						
						</c:choose>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<h3>Here are some events in other states:</h3>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Date</th>
				<th>Location</th>
				<th>State</th>
				<th>Host</th>
				<th>Action/Status</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${ eventOther }" var="event">
			<tr>
				<td><a href="/events/${ event.id }">${ event.name }</a></td>
				<td>${ event.date }</td>
				<td>${ event.location }</td>
				<td>${ event.state }</td>
				<td>${ event.planner.firstname }</td>
				<td>
				<c:choose>
					<c:when test="${ event.planner.id == user.id }">
						<a href="/events/${ event.id }/edit">Edit</a> |
						<form action="/events/${ event.id }/delete" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button>Delete</button>
						</form>
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${ event.attenders.contains(user) }">
								<span>Joining <a href="/events/${ event.id }/a/cancel">Cancel</a></span>
							</c:when>
							<c:otherwise>
								<a href="/events/${ event.id }/a/join">Join</a>								
							</c:otherwise>
						
						</c:choose>
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h2>Create an Event</h2>
    
    <form:form method="POST" action="/event" modelAttribute="event">
		<form:hidden value="${ user.id }" path="planner"/>
        <p>
            <form:label path="name">Name:</form:label>
            <form:input path="name"/>
                        <form:errors path="name"/>
            
        </p>
        <p>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"/>
                        <form:errors path="date"/>
            
        </p>
        <p>
            <form:label path="location">Location:</form:label>
            <form:input path="location"/>
                        <form:errors path="location"/>
           
        </p>
        
        <p>
			<form:select path="state">
				<c:forEach items="${ states }" var="state">
					<option value="${ state }">${ state }</option>
				</c:forEach>
			</form:select>
        </p>
        <input type="submit" value="Create"/>
    </form:form>
	
</body>
</html>
