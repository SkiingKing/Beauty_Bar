<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 16.02.2021
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">

    body {
        font: 10pt Arial, Helvetica, sans-serif;
        background: #e1dfb9;
    }
    h2 {
        font-size: 1.1em;
        color: #800040;
        margin-top: 0;
    }
    #container {
        width: 500px;
        margin: 0 auto;
        background: #f0f0f0;
    }
    #header {
        font-size: 1.2em;
        text-align: center;
        padding: 5px;
        background: #8fa09b;
        color: #ffe; /
    }
    #head_right{
        text-align: right;
        padding: 5px;
    }

    #sidebar {
        margin-top: 10px;
        width: 110px;
        padding: 0 10px;
        float: left;
    }
    #content {
        margin-left: 130px;
        padding: 10px;
        background: #fff;
    }
    #footer {
        background: #8fa09b;
        color: #fff;
        padding: 5px;
        clear: left;
    }
</style>
<div id="container">
    <div id="header">BeautyBar</div>
    <div id ="head_right">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="controller?action=logout">Logout</a>
    </div>

    <div id="sidebar">
        <p><a href="main.jsp">Main</a></p>
        <form method="post" action="controller?action=master">
            <p><input type="submit" value="Masters" /></p>
        </form>
        <form method="post" action="controller?action=service">
            <p><input type="submit" value="Services" /></p>
        </form>
        <p><a href="select.jsp">Record</a></p>
        <p><a href="xx.jsp">Response</a></p>
        <form method="post" action="controller?action=update_status_by_master">
            <%--        <p><a href="master_timetable.jsp"  type="submit">Time table</a></p>--%>
            <p><input type="submit" value="Time table" /></p>
        </form>
    </div>


    <div id="content">

<table border="1">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Stage</th>
        <th>Start time</th>
        <th>Ending time</th>
        <th>Service</th>
    </tr>
<%--    <jsp:useBean id="records" class="beautybar.vn.command.TimetableCommand" scope="request"/>--%>
<%--    <c:forEach var="record" items="${records.records}">--%>
    <c:forEach var="records" items="${records}">
        <tr>
            <td>${records.id}</td>
            <td>${records.date}</td>
            <td>${records.stage}</td>
            <td>${records.starting_time}</td>
            <td>${records.ending_time}</td>
            <td>${records.service}</td>
        </tr>
    </c:forEach>

<%--    pattern="yy-MM-dd"--%>
</table>
    </div>
    <div id="footer">instagram:@BeutyBar</div>
</div>

</body>
</html>
