<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
	<h1>Bad Request!</h1>
		<a class="btn btn-primary" href="/view-all-products" role="button">View
			Products</a>
	</div>
	<%@ include file="footer.jsp"%>
	
</body>
</html>