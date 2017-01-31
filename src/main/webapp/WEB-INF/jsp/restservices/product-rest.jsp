<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body>


	<script>
		var app = angular.module('myApp', []);
		app.controller('productsCtrl', function($scope, $http) {
			$http.get("/restservices/view-all-product-serives").then(
					function(response) {
						$scope.products = response.data;
						console.log(response);
					});
		});
	</script>
	<div ng-controller="productsCtrl">
		Search <input type="text" ng-model="search" />
		<table>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Category</th>
			<th>Quantity</th>
			<th>Price</th>
			<tr ng-repeat="x in products | filter:search">
				<td>{{ x.productId }}</td>
				<td>{{ x.productName | uppercase }}</td>
				<td>{{ x.category }}</td>
				<td>{{ x.quantity }}</td>
				<td>{{ x.price }}</td>
			</tr>
		</table>

	</div>

</body>
</html>
