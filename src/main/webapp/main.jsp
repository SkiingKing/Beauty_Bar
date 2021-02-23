<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page isELIgnored="false" %>
<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="resources"/>
<%@ page session="true" %>

<html lang="${sessionScope.lang}">
<html>
<head>
    <meta charset="UTF-8">
    <title>BeautyBar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
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
        #menu{
            margin: 15px;
            padding: 2px;
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
</head>
<body>
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
            <a class="nav-link" href="controller?action=logout"><fmt:message key="header.logout"/></a>
        </li>
            <li><a href="main.jsp?sessionLocale=en"><fmt:message key="english" /></a></li>
            <li><a href="main.jsp?sessionLocale=ua"><fmt:message key="ukrainian" /></a></li>
    </ul>
    </div>

    <div id="sidebar">
        <div id="menu">
                <a class="nav-link active" href="main.jsp"><fmt:message key="menu.main"/></a>
                <a class="nav-link" onclick="location.href='master?action=master'"><fmt:message key="menu.masters"/></a>
                <a class="nav-link" onclick="location.href='services?action=service'"><fmt:message key="menu.services"/></a>
                 <a class="nav-link" href="xx.jsp"><fmt:message key="menu.response"/></a>
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

    </div>
    <div id="footer"><fmt:message key="footer.info"/></div>
</div>

</body>
</html>