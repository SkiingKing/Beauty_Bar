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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
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
        width: max-content;
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
        width: 600px;
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
        <a href="../register.jsp">Register</a>
        <a href="../login.jsp">Login</a>
        <a href="controller?action=logout">Logout</a>
    </div>

    <div id="sidebar">
        <div id="menu">
            <a class="nav-link active" href="main.jsp">Main</a>
            <a class="nav-link" onclick="location.href='master?action=master'">Masters</a>
            <a class="nav-link" onclick="location.href='services?action=service'">Services</a>
            <a class="nav-link" href="xx.jsp">Response</a>
            <c:choose>
                <%--===========================================================================
                               This way we define the USER MENU.
                 ===========================================================================--%>

                <c:when test="${userRole.name == 'user' }">
                    <a class="nav-link" href="select.jsp">Record</a>
                </c:when>

                <%--===========================================================================
                This way we define the Master MENU.
                ===========================================================================--%>
                <c:when test="${userRole.name == 'master' }">
                    <a class="nav-link" onclick="location.href='master_timetable?action=master_timetable'">Time table</a>
                </c:when>

                <%--===========================================================================
                This way we define the Admin MENU.
                ===========================================================================--%>
                <c:when test="${userRole.name == 'admin'}">
                    <a class="nav-link" onclick="location.href='record_list?action=admin_list&currentPage=${1}&recordsPerPage=10'">Admin list</a>
                </c:when>
            </c:choose>
        </div>
    </div>


    <div id="content">
        <main class="m-3">
            <div class="row col-md-6">
                <table class="table table-striped table-bordered table-sm">
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
            <td><button onclick="location.href='master_timetable?action=update_master_status&recordId=${records.id}&master=${records.master_name}'">Ready</button></td>
        </tr>
    </c:forEach>

<%--    pattern="yy-MM-dd"--%>
</table>
    </div>
        </main>
    <div id="footer">instagram:@BeutyBar</div>
</div>

</body>
</html>
