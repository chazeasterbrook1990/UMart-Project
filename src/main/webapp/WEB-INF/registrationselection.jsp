<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
<meta charset="UTF-8">
<title>Selling or Buying</title>
</head>
<body>
	<div class="container mt-4">
		<div class="row justify-content-center mt-3">
			<div class="col-8 text-center">
				<p class="fw-bold fs-5 mt-4">How would you like to register?</p>
			</div>
			<div class="row justify-content-center mt-4">
				<div class="col-8 text-center">
					<a href="/seller/registration" class="btn btn-primary">I want
						to Sell</a>
				</div>
			</div>
			<div class="row justify-content-center mt-4">
				<div class="col-8 text-center">
					<a href="/registration" class="btn btn-primary">I want to Buy</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>