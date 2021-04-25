<%--
  Created by IntelliJ IDEA.
  User: Trainee
  Date: 3/20/2021
  Time: 4:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getBookById</title>
</head>
<body>
<a href="homePage">Homepage</a>

<center><h1>Product Detail page: (PDP)</h1></center>
<center>
    <table border="2" width="70%" cellpadding="2"
           style="background-image: url('https://images.unsplash.com/photo-1589447388175-ac47d31be950?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=750&q=80')">
        <tr>
            <th>BOOKID</th>
            <th>BOOK_NAME</th>
            <th>BOOK_AUTHOR</th>
            <th>BOOK_PRICE</th>
            <th>BUY_BOOK</th>
        </tr>
            <tr>
                <td>
                        <%--heare i am passing bookid by using queryString and accessing in controller by using @RequestParam--%>
                    <a href="getBookById?bookId=${bookObject1.bookId}">${bookObject1.bookId}</a>
                </td>
                <td>
                        <%--hear i am passing bookid by using queryString and accessing in controller by using @RequestParam--%>
                    <a href="getBookById?bookId=${bookObject1.bookId}">${bookObject1.bookName}</a>
                </td>
                <td>${bookObject1.bookAuthor}</td>
                <td>${bookObject1.bookPrice}</td>
                <td>
                        <%--hear iam passing book id by buy uri directly and accessing in controller by using @PathVareable--%>
                    <c:url value="/buyBook" var="Buy"/>
                    <a href="http://localhost:8080/spiderBookStall_war_exploded/buyBook/${bookObject1.bookId}">BUY</a>
                </td>
            </tr>

    </table>
</center>
<br/>

</body>
</html>
