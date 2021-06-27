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
Product ${product.name}
Categories:
<form method="POST" action="/products/${product.id}">
    <label>Add Category: 
    	<select name="product">
    		<c:forEach items="${allNotCat}" var="cat">
        		<option value="${cat.id}">${cat.name}</option>
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
        <c:forEach items="${allProductCat}" var="cat">
        <tr>
            <td><c:out value="${cat.name}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>