<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 17.02.2021
  Time: 19:58
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
        <th>ID</th>
        <th>Date</th>
        <th>Stage</th>
        <th>Status for admin</th>
        <th>Start time</th>
        <th>Ending time</th>
        <th>Service</th>
        <th>Master name</th>
    </tr>
    <c:forEach var="records" items="${records}">
        <tr>
            <td>${records.id}</td>
            <td>${records.date}</td>
            <td>${records.stage}</td>
            <td>${records.status_for_admin}</td>
            <td>${records.starting_time}</td>
            <td>${records.ending_time}</td>
            <td>${records.service}</td>
            <td>${records.master_name}</td>
            <td><button onclick="location.href='record_list?action=deleteRecord&recordId=${records.id}'">Delete</button></td>
            <td><button>Edit</button> </td>
            <td><button onclick="location.href='record_list?action=update_admin_status&recordId=${records.id}'">Сalculate</button></td>
        </tr>
    </c:forEach>
<%--    <button onclick="location.href='publicationView?command=deleteItem&publicationId=${publication.id}'">--%>
</table>
</body>
</html>
