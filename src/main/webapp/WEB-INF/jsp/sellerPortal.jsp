<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/25/2021
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>sellerPortal</title>
</head>
<body>
<c:url value="/addbook" var="addbook"></c:url>
<h1><a href="${addbook}">AddBook</a> </h1><br>

<c:url value="/listOfBook" var="listOfBook"></c:url>
<h1><a href="${listOfBook}">ListOfBook</a> </h1><br>

<c:url value="/updateBook" var="updateBook"></c:url>
<h1><a href="${updateBook}">AddBook</a> </h1>

<c:url value="/delete?emailId=${pageContext.request.userPrincipal.name}" var="updateBook"></c:url>
<h1><a href="delete?emailId=${pageContext.request.userPrincipal.name}">deleteBook</a> </h1>
</body>
</html>
