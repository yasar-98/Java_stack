<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h2>${ event.name }</h2>
			<div>
				<h4><strong>Host:</strong> ${ event.planner.firstname }</h4>
				<h4><strong>Date:</strong> ${ event.date }</h4>
				<h4><strong>Location:</strong> ${ event.location }, ${ event.state }</h4>
				<h4><strong>People attending:</strong> ${ event.attenders.size() }</h4>
				<table>
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${ event.attenders }" var="user">
						<tr>
							<td>${ user.firstname } ${ user.lastname }</td>
							<td>${ user.location }, ${ user.state }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div>
				<h3>Message Wall</h3>
				<div>
				<c:forEach items="${ event.messages }" var="message">
					<p>${ message.author.firstname } says: ${ message.content }</p>
				</c:forEach>
				</div>
				<form action="/events/${ event.id }/comment" method="post">
					<div>
						<label for="comment">Add Comment</label>
						<span>${ error }</span>
						<textarea name="comment" id="comment"></textarea>
						<button>Submit</button>
					</div>
				</form>
			</div>

</body>
</html>