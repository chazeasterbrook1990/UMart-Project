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
<link rel="stylesheet" href="/style.css"/>
<meta charset="UTF-8">
<title>${product.title}</title>
</head>
<body>
	<div class="container mt-4 text-center">
			<div id="pdp-head">
				
				<div class="text-right">
            <a href="/umart/seller/home" class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Return Home</a>
        </div><a href="/logout" class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Log
				Out, <c:out value="${userName}" />
			</a>
			
			</div>
			
			<div class="text-center my-4">
				<img src="/images/umartlogo.png">
			</div>
		<h1 class="text-center my-4">${product.title}</h1>
		<div class="pdp-container">
		
			<div id="pdp-feature">
			<div id="pdp-image">
				<img src="data:image/png;base64,${imageBase64}"
					style="max-width: 500px;">
			</div>
			<div id="pdp-desc">
				<p class="fw-bold fs-5 mt-4">Item Number: <c:out value="${product.sku}"></c:out></p>
				
				<c:out value="${product.description}"></c:out>
			</div>
			<div id="pdp-buy">
				<p>
					$
					<c:out value="${product.price}"></c:out>
				</p>

					<form:form action="#" method="POST">
						<button type="submit"
							class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Buy Now</button>
					</form:form>
				</div>
			</div>
			
		</div>
	</div>
</body>
</html>