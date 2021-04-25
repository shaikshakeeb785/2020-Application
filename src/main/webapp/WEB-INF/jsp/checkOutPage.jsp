<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/20/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>checkoutPage</title>
</head>
<style>
    @import url('https://fonts.googleapis.com/css?family=Open+Sans&display=swap');

    body {
        font-family: 'Open Sans', sans-serif;
        background: #f9faff;
        color: #3a3c47;
        line-height: 1.6;
        display: flex;
        flex-direction: column;
        align-items: center;
        margin: 0;
        padding: 0;
    }

    h1 {
        margin-top: 48px;
    }

    form {
        background: #fff;
        max-width: 360px;
        width: 100%;
        padding: 58px 44px;
        border: 1px solid #e1e2f0;
        border-radius: 4px;
        box-shadow: 0 0 5px 0 rgba(42, 45, 48, 0.12);
        transition: all 0.3s ease;
    }

    .row {
        display: flex;
        flex-direction: column;
        margin-bottom: 20px;
    }

    .row label {
        font-size: 13px;
        color: #8086a9;
    }

    .row input {
        flex: 1;
        padding: 13px;
        border: 1px solid #d6d8e6;
        border-radius: 4px;
        font-size: 16px;
        transition: all 0.2s ease-out;
    }

    .row input:focus {
        outline: none;
        box-shadow: inset 2px 2px 5px 0 rgba(42, 45, 48, 0.12);
    }

    .row input::placeholder {
        color: #C8CDDF;
    }

    button {
        width: 100%;
        padding: 12px;
        font-size: 18px;
        background: #15C39A;
        color: #fff;
        border: none;
        border-radius: 100px;
        cursor: pointer;
        font-family: 'Open Sans', sans-serif;
        margin-top: 15px;
        transition: background 0.2s ease-out;
    }

    button:hover {
        background: #55D3AC;
    }

    @media(max-width: 458px) {

        body {
            margin: 0 18px;
        }

        form {
            background: #f9faff;
            border: none;
            box-shadow: none;
            padding: 20px 0;
        }

    }
</style>
<body>
<h1><label>delivary Address:</label>
    <h1>BookAuthor:${bookobject.bookPrice}</h1>
${customerDetail.addressLine1}<br></h1>
<h1>Book will be delivered on this address:${customerDetail.addressLine1}</h1>
<c:url value="/orderPlaced/${bookid}" var="order"></c:url>
<f:form action="${order}" method="post" modelAttribute="customerDetail">
    <f:label path="addressLine1">ADDRESS LINE1:</f:label>
    <f:textarea path="addressLine1"/><br>
    <f:label path="addressLine2">ADDRESS LINE2:</f:label>
    <f:textarea path="addressLine2"/>
    <f:label path="paymentMethod">PAYMENT METHOD:COD</f:label>
    <f:checkbox value="COD" path="paymentMethod"></f:checkbox>
    <f:button>PLACE ORDER</f:button>
</f:form>

</html>