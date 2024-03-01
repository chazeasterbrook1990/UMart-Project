<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
<meta charset="UTF-8">
<title>UMart Home</title>
</head>
<body>
    <div class="container mt-4">
        <div class="text-center">
            <div class="text-center my-4">
				<img src="/images/umartlogo.png">
			</div>
			
        </div>
        <div class="text-right">
            <a href="/logout" class="btn btn-primary fw-bold fs-5 mt-4">Log Out</a>
        </div>
        <div class="fw-bold fs-5 mt-4" id="customer-head">
            <p>New Products For You</p>
            <p>Welcome, <c:out value="${userName}"></c:out>!</p>
        </div>
        <div>
            <table class="table table-bordered table-striped table-hover table-light">
                <thead class="">
                    <tr>
                        <th>Title</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Seller</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td><a href="/umart/product/${product.id}"><c:out value="${product.title}"></c:out></a></td>
                            <td><img src="<c:out value="${product.image}"></c:out>" alt="Product Image" style="max-width: 100px;"></td>
                            <td><c:out value="${product.description}"></c:out></td>
                            <td>$<c:out value="${product.price}"></c:out></td>
                            <td><c:out value="${product.creator.userName}"></c:out></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>