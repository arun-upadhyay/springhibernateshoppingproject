<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>View All products</title>

</head>
<body>
	<script src="../js/effects.js"></script>
	<%@ include file="header.jsp"%>
	<div class="container">

		<h1>View all Product Information</h1>

		<a class="btn btn-primary" href="/checkout-products" role="button">Checkout</a>
		<a class="btn btn-primary" href="/add-product" role="button">Add
			Product </a>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">View Checkout</button>
		<!--view checkoutList -->
		<%@ include file="check-out-list.jsp"%>


		<br> <br>

		<div>
			<table>
				<tr>
					<td>Search by product name</td>
					<td><input type="text" name="pname" id="pname" /></td>

				</tr>
			</table>


		</div>
		<br>
		<table class="table table-striped">
			<tr>
				<th>ID</th>
				<th>Product Name</th>
				<th>Category</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<tbody id="tbody">

				<%@ include file="search-content.jsp"%>
			</tbody>

		</table>
		<div>
			<ul class="pagination">

				<c:if test="${pageno > '1'}">
					<li><a href="/view-all-products/${pageno-1}">Previous</a></li>
				</c:if>
			
				<c:forEach var="i" begin="1" end="${pageno+1}">
					
					<c:if test="${pageIndexSize >=  i}">


						<c:choose>
							<c:when test="${pageno == i}">
								<li class="active"><a href="/view-all-products/${i}">${i}</a></li>

							</c:when>
							<c:otherwise>
								<li><a href="/view-all-products/${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:if>
				</c:forEach>
				<c:if test="${pageIndexSize-1 >=  pageno}">
				<li><a href="/view-all-products/${pageno+1}">Next</a></li>
				</c:if>
			</ul>

		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>