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
<title>Registration</title>
</head>
<body>
    <div class="container mt-4">
        <div class="text-center mb-4">
            <img src="/images/umartlogo.png">
        </div>
        <div class="text-center">
            <h1>Welcome to UMart</h1>
        </div>
        <div class="text-center">
            <h2 class="fw-bold fs-5 mt-4">Register as a Seller</h2>
        </div>
        <div class="container custom-container text-center">
            <form:form action="/seller/register" method="POST" modelAttribute="newSeller">
                <div class="form-group">
                    <form:label path="userName"></form:label>
                    <form:errors path="userName" class="errors"></form:errors>
                    <form:input path="userName" class="form-control" placeholder="User Name"></form:input>
                </div>
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
                <div class="form-group">
                    <form:label path="confirm"></form:label>
                    <form:errors path="confirm" class="errors"></form:errors>
                    <form:input path="confirm" type="password" class="form-control" placeholder="Confirm Password"></form:input>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary">
            </form:form>
        </div>
    </div>
</body>
</html>