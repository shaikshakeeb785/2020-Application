<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/23/2021
  Time: 11:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %><html>
<head>
    <title>orderPlaced</title>
</head>
<body>
<h1>ORDER PLACED SUCCESSFULLY!!!</h1>
<h1>ORDERID:${orderId}</h1>
<h1>BookName:${bookObject1.bookName}</h1>
<h1>BookPrice:${bookObject1.bookPrice}</h1>
</body>
</html>
