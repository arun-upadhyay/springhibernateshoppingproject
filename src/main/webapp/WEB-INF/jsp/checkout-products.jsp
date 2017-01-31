<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products-Checkout</title>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<table class="table table-striped">
			<tr>
				<th>Product Name</th>
				<th>Category</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<tr>
			</tr>
			<c:forEach items="${pcheckoutList}" var="p">
				<tr>
					<td>${p.productName}</td>
					<td>${p.category}</td>
					<td>${p.price}</td>
					<td>${p.quantity}</td>
					<td><a class="btn btn-primary" role="button"
						href="/remove-from-cart/<c:out value="${p.productId}"/>">Remove
							from Cart</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td>Total amount</td>
				<td><b><c:out value="${total}" /> </b></td>
			</tr>

		</table>
		<a class="btn btn-primary" href="/payment" role="button">Pay</a> <a
			class="btn btn-primary" href="/cancel-checkout" role="button">Cancel
			Checkout</a>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>