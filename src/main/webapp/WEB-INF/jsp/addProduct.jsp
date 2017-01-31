<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add Product</title>
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
	
		<form:form action="save-product" commandName="product" method="post">
			<div class="form-group">
				<label for="productname">Product name</label>
				<form:input path="productName" class="form-control" />
				<form:errors path="productName" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="category">Category</label>
				<form:input path="category" class="form-control" />
				<form:errors path="category" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="description">Description</label>
				<form:textarea path="description" class="form-control" rows="5"
					cols="50" />
				<form:errors path="description" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="price">Price</label>
				<form:input path="price" class="form-control" />
				<form:errors path="price" cssClass="error" />
			</div>
			<div class="form-group">
				<label for="quantity">Quantity</label>
				<form:input path="quantity" class="form-control" />
				<form:errors path="quantity" cssClass="error" />
			</div>
			<input type="submit"  class="btn btn-default" />
			
		</form:form>


	
		
		
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
