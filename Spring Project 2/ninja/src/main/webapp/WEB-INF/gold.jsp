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
Your Gold : <p><c:out value="${ninja}"/></p>
    <h2>Farm</h2>
    <p>(earns 10_20 golds)</p>
    <form action="/process_money" method="POST">
        <input type="hidden" name="which_form" value="register1">
        <input type="submit" value="Find Gold!">
    </form>
    <h2>Cave</h2>
    <p>(earns 5_10 golds)</p>
    <form action="/process_money" method="POST">
        <input type="hidden" name="which_form" value="register2">
        <input type="submit" value="Find Gold!">
    </form>
    <h2>House</h2>
    <p>(earns 2_5 golds)</p>
    <form action="/process_money" method="POST">
        <input type="hidden" name="which_form" value="register3">
        <input type="submit" value="Find Gold!">
    </form>
    <h2>Casino</h2>
    <p>(earns/takes 0_50 golds)</p>
    <form action="/process_money" method="POST">
        <input type="hidden" name="which_form" value="register4">
        <input type="submit" value="Find Gold!">
    </form>
    <br>
    <form>
        Activities: <br>
        <textarea name="area" cols="100" rows="10"><c:out value="${area}"/></textarea>
    </form>
</body>
</html>