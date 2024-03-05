<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<div class="container mt-4">
		<div class="text-center">
			<h1>Seller Home</h1>
			<div class="text-center my-4">
				<img src="/images/umartlogo.png">
			</div>
			
			<nav class="seller-nav">
				<a href="/umart/seller/product/create"
					class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Create a Listing</a>
				<a href="#" class="btn btn-primary fw-bold fs-5 mt-4 mx-2">View
					Your Orders</a> <a href="/logout"
					class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Log Out</a>
			</nav>
		</div>
		<div>
			<div class="seller-heading">
			<p class="fw-bold fs-5 mt-4">Your Listings</p>
			<p class="fw-bold fs-5 mt-4">
				Welcome,
				<c:out value="${sellerLoggedIn.userName}"></c:out>
			</p>
			</div>
			<table
				class="table table-bordered table-striped table-hover table-light">
				<thead>
					<tr>
						<th>SKU</th>
						<th>Image</th>
						<th>Title</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${product}">
						<tr>
							<td class="align-middle"><a href="/umart/seller/product/${product.id}/edit"><c:out value="${product.sku}"></c:out></a></td>
							<td class="align-middle"><img src="${product.imageUrl}"></td>
							<td class="align-middle"><c:out value="${product.title}"></c:out></td>
							<td class="align-middle"><c:out value="${product.quantity}"></c:out></td>
							<td class="align-middle">$<c:out value="${product.price}"></c:out></td>
							<td class="align-middle"><a href="/umart/seller/product/${product.id}/edit"
								class="btn btn-primary">Edit</a></td>
							<td class="align-middle"><form:form
									action="/umart/seller/product/${product.id}/delete"
									method="POST" modelAttribute="deleteproduct">
									<button type="submit" class="btn btn-warning">Delete</button>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
