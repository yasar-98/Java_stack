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

<form method="POST" action="/login">
    <label>Your name <input type="text" name="name"></label><br>
    <label>Dojo Location 
		<select name="location">
		  <option value="jenin">jenin</option>
		  <option value="nablus">nablus</option>
		  <option value="ramallah">ramallah</option>
		  <option value="khalil">khalil</option>
		</select>
	</label><br>
    <label>Fav Language
		<select name="laguage">
		  <option value="c++">c++</option>
		  <option value="java">java</option>
		  <option value="js">js</option>
		  <option value="python">python</option>
		</select>   
    </label><br>
    <label>Comment(optional) <textarea name="comment" rows="10" cols="30"></textarea><br>
    <button>Button</button>
</form>
</body>
</html>