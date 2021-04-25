<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/22/2021
  Time: 5:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <!--Custom CSS-->
    <link rel="stylesheet" href="space.css">
    <title>profile</title>

</head>
<style type="text/css">
    .navbar-brand{
        font-weight: bolder;
    }

    .nav-item{
        padding-left: 1rem;
    }

    .navbar{
        background-color: rgb(224, 169, 169) ;
    }

    .footer{
        background-color: rgb(221, 187, 187) ;
    }

    .form-control{
        background-color: rgb(224, 186, 186) ;
        border: 1px solid rgba(255, 255, 255, .5);;
        border-radius: 0;
        opacity: 1;
    }

    .form-control .form-inline{
        width: 220px;
    }


    .form-control:focus{
        color:black;
        background-color: #fff;
        border-color:#a75470;
        box-shadow:none;
    }

    .form-control::placeholder{
        color: rgba(255, 255, 255, .5);
    }

    .btn {
        color: #fff;
        background-color: #a56177;
        border-color:rgb(224, 186, 186);
        border-radius: 0;
        height: 38px;
    }

    .btn:hover,.btn:focus  {
        color: #fff;
        box-shadow: 0 0 0 0.2rem #a56177;
    }

    .dropdown-menu{
        padding: 0;
        border-radius: 0;
        background-color: rgb(223, 197, 197);

    }

    .dropdown-item{
        color: rgba(255, 255, 255, .5);
    }

    .dropdown-item:hover{
        background-color: rgb(224, 186, 186);
        color:white;
    }

    .carousel-caption,h3{
        font-weight: lighter;
    }

    .footer{
        font-size: x-small;
    }
</style>
<body>
<nav class="navbar navbar-expand-sm navbar-dark" data-id="web_navigation_bar">

    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXDvZebG77drmo7xDjnzR_azB8q79vNTbD5Q&usqp=CAU" alt="Girl in a jacket" width="70" height="70">
    <a class="navbar-brand brand-name" href>SpiderBookStall</a>
    <div class="collapse navbar-collapse" id="web_navigation_bar_collapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <c:url value="/homePage" var="homepage"/>
                <a href="${homepage}" style="color:white; padding:auto">HomePage</a>
            </li>
        </ul>
    </div>
    <%--this logic is used to hide the register and login link from home page After success full loged in by customer--%>

    <c:if test="${pageContext.request.userPrincipal.name!= null}">
        <div class="px-1">
            <div align="center" style="color: cyan">
                <h1 >hi:${cutomerDetail.firstName}</h1>
            </div>
        </div>
    </c:if>
</nav>
<center><h1>Profile Page:</h1></center>

<center>
<div align="center" class="container"
     style="background-image: url('https://wallpapercave.com/wp/g0c4dxk.jpg');width: 300px; height: 400px">
    <label>FirstName:</label>
    ${cutomerDetail.firstName}<br>

    <label>LastName:</label>
    ${cutomerDetail.lastName}<br>

    <label>Email:</label>
    ${cutomerDetail.email}<br>

    <label>Password:</label>
    ${cutomerDetail.password}<br>

    <label>re-Password:</label>
    ${cutomerDetail.rePassword}<br>

    <label>AddressLine1:</label>
    ${cutomerDetail.addressLine1}<br>

    <label>AddressLine2:</label>
    ${cutomerDetail.addressLine2}<br>

    <label>Contct:</label>
    ${cutomerDetail.contact}<br>

    <label>DOB:</label>
    ${cutomerDetail.dob}<br>

    <label>STATE:</label>
    ${cutomerDetail.state}<br>

    <label>pincode</label>
    ${cutomerDetail.pinCode}<br>

    <label>CITY:</label>
    ${cutomerDetail.city}<br>

</div></center>

<center><c:url value="/editCustomer/${cutomerDetail.email}" var="update"></c:url>

  <center>  <a href="${update}">Update Profile</a></center>
</body>
</html>
