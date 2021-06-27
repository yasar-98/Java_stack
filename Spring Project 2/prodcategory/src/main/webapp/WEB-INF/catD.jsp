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
Category ${category.name}
Products:
<form method="POST" action="/categories/${category.id}">
    <label>Add Product: 
    	<select name="category">
    		<c:forEach items="${allNotPro}" var="pro">
        		<option value="${pro.id}">${pro.name}</option>
    		</c:forEach>
		</select>
	</label>
    <button>Add</button>
</form>
<table>
    <thead>
        <tr>
            <th>Name</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allCategoryPro}" var="pro">
        <tr>
            <td><c:out value="${pro.name}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>