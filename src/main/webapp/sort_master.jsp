<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 17.02.2021
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<table border="1">
    <tr>
        <th>Name and Surname</th>
        <th>Rate</th>
        <th>Service</th>
    </tr>
    <c:forEach var="masters_2" items="${masters_2}">
    <tr>
        <td>${masters_2.name}</td>
        <td>${masters_2.rate}</td>
        <td>${masters_2.services}</td>
    </tr>
    </c:forEach>


</body>
</html>
