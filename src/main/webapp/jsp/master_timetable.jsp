<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 16.02.2021
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<%@ page session="true" %>
<html lang="${sessionScope.lang}">
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
        <ul class="nav justify-content-end">
            <li class="nav-item">
                <a class="nav-link active" href="register.jsp"><fmt:message key="header.register"/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login.jsp"><fmt:message key="header.login"/></a>
            </li>
            <li class="nav-item">
                <c:if test="${userRole.name == 'master' }">
                    <a class="nav-link" href="controller?action=logout"><fmt:message key="header.logout"/></a>
                </c:if>
            </li>
            <input type="image" src="https://img.icons8.com/color/25/000000/ukraine-circular.png" alt="<fmt:message key="ukrainian" />" onclick="location.href='master_timetable?action=master_timetable&sessionLocale=ua'">
            <input type="image" src="images/english.png" alt="<fmt:message key="english" />" onclick="location.href='master_timetable?action=master_timetable&sessionLocale=en'">
        </ul>
    </div>

    <div id="sidebar">
        <div id="menu">
            <a class="nav-link active" href="index.jsp"><fmt:message key="menu.main"/></a>
            <a class="nav-link" onclick="location.href='master?action=master'"><fmt:message key="menu.masters"/></a>
            <a class="nav-link" onclick="location.href='services?action=service'"><fmt:message key="menu.services"/></a>
            <a class="nav-link" href="response?action=response"><fmt:message key="menu.response"/></a>
            <c:choose>
                <%--===========================================================================
                               This way we define the USER MENU.
                 ===========================================================================--%>

                <c:when test="${userRole.name == 'user' }">
                    <a class="nav-link" href="select.jsp"><fmt:message key="menu.record"/></a>
                </c:when>

                <%--===========================================================================
                This way we define the Master MENU.
                ===========================================================================--%>
                <c:when test="${userRole.name == 'master' }">
                    <a class="nav-link" onclick="location.href='master_timetable?action=master_timetable'"><fmt:message key="menu.timetable"/></a>
                </c:when>

                <%--===========================================================================
                This way we define the Admin MENU.
                ===========================================================================--%>
                <c:when test="${userRole.name == 'admin'}">
                    <a class="nav-link" onclick="location.href='record_list?action=admin_list&currentPage=${1}&recordsPerPage=10'"><fmt:message key="menu.admin_list"/></a>
                </c:when>
            </c:choose>
        </div>
    </div>

    <div id="content">
        <main class="m-3">
            <div class="row col-md-6">
                <table class="table table-striped table-bordered table-sm">
    <tr>
        <th><fmt:message key="record_admin_list_id"/></th>
        <th><fmt:message key="record_admin_list_date"/></th>
        <th><fmt:message key="record_admin_list_stage"/></th>
        <th><fmt:message key="record_admin_list_start"/></th>
        <th><fmt:message key="record_admin_list_end"/></th>
        <th><fmt:message key="record_admin_list_service"/></th>
    </tr>

    <c:forEach var="records" items="${records}">
        <tr>
            <td>${records.id}</td>
            <td>${records.date}</td>
            <td>${records.stage}</td>
            <td>${records.starting_time}</td>
            <td>${records.ending_time}</td>
            <td>${records.service}</td>
            <td><button onclick="location.href='master_timetable?action=update_master_status&recordId=${records.id}&master=${records.master_name}'"><fmt:message key="record_master_button"/></button></td>
        </tr>
    </c:forEach>

</table>
    </div>
        </main>
    <div id="footer"><fmt:message key="footer.info"/></div>
</div>
</div>
</body>
</html>
