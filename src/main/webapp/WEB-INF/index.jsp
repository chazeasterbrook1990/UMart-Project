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
<title>Login & Registration</title>
</head>
<body>
    <div class="container mt-4">
        <div class="text-center">
            <img src="/images/umartlogo.png">
        </div>
        <div class="login-container">
        <div class="container custom-container text-center">
            <p class="fw-bold fs-5 mt-4">Customer Login</p>
            <form:form action="/login" method="POST" modelAttribute="newLogin">
                <div class="form-group">
                    <form:label path="email"></form:label>
                    <form:errors path="email" class="errors"></form:errors>
                    <form:input path="email" class="form-control" placeholder="Email"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="password"></form:label>
                    <form:errors path="password" class="errors"></form:errors>
                    <form:input path="password" type="password" class="form-control" placeholder="Password"></form:input>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary fw-bold fs-5 mt-4">
            </form:form>
        </div>
        <div class="container custom-container text-center">
            <p class="fw-bold fs-5 mt-4">Seller Login</p>
            <form:form action="/seller/login" method="POST" modelAttribute="newSellerLogin">
                <div class="form-group">
                    <form:label path="email"></form:label>
                    <form:errors path="email" class="errors"></form:errors>
                    <form:input path="email" class="form-control" placeholder="Email"></form:input>
                </div>
                <div class="form-group">
                    <form:label path="password"></form:label>
                    <form:errors path="password" class="errors"></form:errors>
                    <form:input path="password" type="password" class="form-control" placeholder="Password"></form:input>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary fw-bold fs-5 mt-4">
            </form:form>
        </div>
        </div>
        <div class="container">
		    <div class="row justify-content-center mt-3">
		        <div class="col-8 text-center">
		            <p class="fw-bold fs-5 mt-4">New Here?</p>
		        </div>
		    </div>
		    <div class="row justify-content-center">
		        <div class="col-8 text-center">
		            <a href="/registration/selection" class="btn btn-primary fw-bold fs-5 mt-4">Register Today</a>
		        </div>
		    </div>
</div>
    </div>
</body>
</html>