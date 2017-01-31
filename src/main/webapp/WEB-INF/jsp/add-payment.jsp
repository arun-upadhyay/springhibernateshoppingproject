<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<script>
	function CopyAdd() {
		var cb1 = document.getElementById('chkbox');

		if (cb1.checked) {
			document.getElementById('billing_street').value = document
					.getElementById('ship_street').value;
			;
			document.getElementById('billing_city').value = document
					.getElementById('ship_city').value;
			;
			document.getElementById('billing_state').value = document
					.getElementById('ship_state').value;
			;
			document.getElementById('billing_zipcode').value = document
					.getElementById('ship_zipcode').value;
			;
		} else {
			document.getElementById('billing_street').value = "";
			;
			document.getElementById('billing_city').value = "";
			;
			document.getElementById('billing_state').value = "";
			;
			document.getElementById('billing_zipcode').value = "";
			;
		}

	}
</script>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">

		<form:form action="process-order" commandName="payment" method="post">
			<table class="table table-striped">
				<tr>
					<th>Payment Information</th>
				</tr>
				<tr>
					<td>Total Payment</td>
					<td><form:input path="paymentAmount" value="${total}"
							readOnly="true" /></td>
				</tr>
				<tr>
					<td>Customer Name :</td>
					<td><form:input path="customer.name" /></td>
					<td><form:errors path="customer.name" cssClass="error" /></td>

				</tr>
				<tr>
					<td>Card Number :</td>
					<td><form:input path="cardNumber" />(xxxx-xxxx-xxxx-xxxx)</td>
					<td><form:errors path="cardNumber" cssClass="error" /></td>

				</tr>
				<tr>
					<td>Expiry Date :</td>
					<td><form:input path="expiryDate" />(mm/yyyy)</td>
					<td><form:errors path="expiryDate" cssClass="error" /></td>

				</tr>
				<tr>
					<td>Security Code :</td>
					<td><form:input path="securityCode" />(xxx)</td>
					<td><form:errors path="securityCode" cssClass="error" /></td>

				</tr>
				<tr>
					<th>Shipping Address</th>
				</tr>
				<tr>
					<td>Street :</td>
					<td><form:input path="customer.shippingAddress.street"
							id="ship_street" /></td>
					<td><form:errors path="customer.shippingAddress.street"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>City :</td>
					<td><form:input path="customer.shippingAddress.city"
							id="ship_city" /></td>
					<td><form:errors path="customer.shippingAddress.city"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>State :</td>
					<td><form:input path="customer.shippingAddress.state"
							id="ship_state" /></td>
					<td><form:errors path="customer.shippingAddress.state"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>Zip Code :</td>
					<td><form:input path="customer.shippingAddress.zipCode"
							id="ship_zipcode" /></td>
					<td><form:errors path="customer.shippingAddress.zipCode"
							cssClass="error" /></td>

				</tr>
				<tr>
					<th>Billing Address</th>
					<td><input type="checkbox" id="chkbox" name="chkBox"
						onchange="CopyAdd();" />Same as Shipping address</td>
				</tr>

				<tr>
					<td>Street :</td>
					<td><form:input path="customer.billingAddress.street"
							id="billing_street" /></td>
					<td><form:errors path="customer.billingAddress.street"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>City :</td>
					<td><form:input path="customer.billingAddress.city"
							id="billing_city" /></td>
					<td><form:errors path="customer.billingAddress.city"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>State :</td>
					<td><form:input path="customer.billingAddress.state"
							id="billing_state" /></td>
					<td><form:errors path="customer.billingAddress.state"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td>Zip Code :</td>
					<td><form:input path="customer.billingAddress.zipCode"
							id="billing_zipcode" /></td>
					<td><form:errors path="customer.billingAddress.zipCode"
							cssClass="error" /></td>

				</tr>
				<tr>
					<td><a class="btn btn-primary" href="/cancel-checkout"
						role="button">Cancel Order</a></td>
					<td><input type="submit" name="submit" value="Process Order" /></td>

				</tr>
			</table>
		</form:form>

	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>
