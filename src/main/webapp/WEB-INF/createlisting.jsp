<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/style.css" />
<meta charset="UTF-8">
<title>List Your Product</title>
</head>
<body>
    <div class="container mt-4">
        <div class="text-center">
            <h1>Create a New Listing</h1>
        </div>
        <div class="text-right">
            <a href="/umart/seller/home" class="btn btn-primary fw-bold fs-5 mt-4 mx-2">Return Home</a>
        </div>
        <div>
            <form:form action="/umart/seller/product/create" method="POST" modelAttribute="product">
                <div class="form-group">
                    <form:label path="title"></form:label>
                    <form:errors path="title" class="errors"></form:errors>
                    <form:input path="title" name="title" class="form-control" placeholder="Title"/>
                </div>
                <div class="form-group">
                    <form:label path="brand"></form:label>
                    <form:errors path="brand" class="errors"></form:errors>
                    <form:input path="brand" name="brand" class="form-control" placeholder="Brand"/>
                </div>
                <div class="form-group">
                    <form:label path="sku"></form:label>
                    <form:errors path="sku" class="errors"></form:errors>
                    <form:input path="sku" name="sku" class="form-control" placeholder="SKU"/>
                </div>
                <div class="form-group">
                    <form:label path="price"></form:label>
                    <form:errors path="price" class="errors"></form:errors>
                    <form:input path="price" name="price" class="form-control" placeholder="Price"/>
                </div>
                <div class="form-group">
                    <form:label path="quantity"></form:label>
                    <form:errors path="quantity" class="errors"></form:errors>
                    <form:input path="quantity" name="quantity" class="form-control" placeholder="Quantity"/>
                </div>
                <div class="form-group">
                    <form:label path="category"></form:label>
                    <form:errors path="category" class="errors"></form:errors>
                    <form:input path="category" name="category" class="form-control" placeholder="Category"/>
                </div>
                <div class="form-group">
                    <form:label path="description"></form:label>
                    <form:errors path="description" class="errors"></form:errors>
                    <form:textarea path="description" name="description" id="" cols="30" rows="10" class="form-control" placeholder="Description"></form:textarea>
                </div>
                <div class="form-group">
                    <form:label path="image">Image:</form:label>
                    <form:input type="file" path="image" name="image" class="form-control"/>
                </div>
                <form:input type="hidden" path="creator" value="${sellerLoggedIn.id}"/>
                <div class="text-center">
                    <input type="submit" value="Submit" class="btn btn-primary fw-bold fs-5 mt-4 mx-2"/>
                </div>
            </form:form>
        </div>
    </div>
</body>
</html>