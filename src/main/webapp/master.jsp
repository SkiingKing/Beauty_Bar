<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 17.02.2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="controller?action=sort">
    <b>Service</b>
    <select size="5" name="sort" required>
        <option disabled>Select sorting</option>
            <option>For the master</option>
            <option>For the rate</option>
            <option>For the service</option>
    </select>

    <p><input type="submit" value="Sort" /></p>
</form>



<table border="1">
    <tr>
        <th>Name and Surname</th>
        <th>Rate</th>
        <th>Service</th>
    </tr>
    <c:forEach var="masters" items="${masters}">
    <tr>
        <td>${masters.name}</td>
        <td>${masters.rate}</td>
        <td>${masters.services}</td>
    </tr>
    </c:forEach>
</body>
</html>
