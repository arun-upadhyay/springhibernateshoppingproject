<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h1>Update Product Information</h1>
		<form:form action="/update-product-info" commandName="product"
			method="post">
			<table class="table table-striped">
				<tr>
					<td>Product name :</td>
					<td><form:input path="productName"
							value="${productObject.productName}" /></td>
					<td><form:errors path="productName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Category :</td>
					<td><form:input path="category"
							value="${productObject.category}" /></td>
					<td><form:errors path="category" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Description :</td>
					<td><form:input  path="description"
							value="${productObject.description}" /></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Price :</td>
					<td><form:input path="price" value="${productObject.price}" /></td>
					<td><form:errors path="price" cssClass="error" /></td>
				</tr>
				<tr>
				<tr>
					<td>Quantity :</td>
					<td><form:input path="quantity"
							value="${productObject.quantity}" /></td>
					<td><form:errors path="quantity" cssClass="error" /></td>
				</tr>
				<tr>
					<td ><a class="btn btn-primary" href="/view-all-products" role="button">BACK</a></td>
					<td ><input type="submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>