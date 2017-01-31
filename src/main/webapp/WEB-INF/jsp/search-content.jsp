<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="p" items="${pList}">
	<tr>
		<td>${p.productId}</td>
		<td>${p.productName}</td>
		<td>${p.category}</td>
		<td>${p.description}</td>
		<td>${p.price}</td>
		<td>${p.quantity}</td>
		<td><a class="btn btn-primary" role="button"
			href="update-product/<c:out value="${p.productId}"/>">Update</a></td>
		<td><a class="btn btn-primary" id="delete-product/${p.productId}"
			role="button" href="delete-product/<c:out value="${p.productId}"/>">Delete</a></td>
		<td><a class="btn btn-primary" id="add-to-cart/${p.productId}"
			role="button" href="add-to-cart/<c:out value="${p.productId}"/>">Add
				to Cart</a></td>
	</tr>
</c:forEach>
