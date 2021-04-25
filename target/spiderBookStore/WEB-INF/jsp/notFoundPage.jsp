<%--
        Created by IntelliJ IDEA.
        User: Trainee
        Date: 3/16/2021
        Time: 10:55 AM
        To change this template use File | Settings | File Templates.
        --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>403</title>
</head>
<body style="background-image: url('https://images.unsplash.com/photo-1579373903781-fd5c0c30c4cd?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=667&q=80')">
<div align="center" style="color: #f9faff"><h1>HTTP Status 403 - Access is denied</h1>
    <h2>${msg}</h2>
    <c:url value="/logout" var="logout" />
    <a href="${logout}">Log Out</a></div>
</body>
</html>