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
<c:choose>
    <c:when test="${userRole.name == 'master'}">
<html lang="${sessionScope.lang}">
<html>
<head>
    <title>Test</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="style/index.css">
</head>

<body>
<div id = "header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp"> BeautyBar</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp"><fmt:message key="menu.main"/></a></li>
                <li><a href="master?action=master"><fmt:message key="menu.masters"/></a></li>
                <li><a href="services?action=service"><fmt:message key="menu.services"/></a></li>
                <li ><a href="response?action=response"><fmt:message key="menu.response"/></a></li>
                <c:choose>
                    <%--===========================================================================
                                   This way we define the USER MENU.
                     ===========================================================================--%>

                    <c:when test="${userRole.name == 'user' }">
                        <li><a href="../select.jsp"><fmt:message key="menu.record"/></a></li>
                    </c:when>

                    <%--===========================================================================
                    This way we define the Master MENU.
                    ===========================================================================--%>
                    <c:when test="${userRole.name == 'master' }">
                        <li  class="active"><a href="master_timetable?action=master_timetable"><fmt:message key="menu.timetable"/></a></li>
                    </c:when>

                    <%--===========================================================================
                    This way we define the Admin MENU.
                    ===========================================================================--%>
                    <c:when test="${userRole.name == 'admin'}">
                        <li><a href="record_list?action=admin_list&currentPage=${1}&recordsPerPage=10"><fmt:message key="menu.admin_list"/></a></li>
                    </c:when>
                </c:choose>


            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span><fmt:message key="header.register"/></a></li>

                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span><fmt:message key="header.login"/></a></li>

                <c:if test="${userRole.name == 'user' || userRole.name == 'master' || userRole.name == 'admin'}">

                    <li><a href="controller?action=logout"><span class="glyphicon glyphicon-log-in"></span><fmt:message key="header.logout"/></a></li>
                </c:if>
                <li><input type="image" src="https://img.icons8.com/color/25/000000/ukraine-circular.png" alt="<fmt:message key="ukrainian" />" onclick="location.href='main.jsp?sessionLocale=ua'"></li>

                <li><input type="image" src="images/english.png" alt="<fmt:message key="english" />" onclick="location.href='main.jsp?sessionLocale=en'"></li>
            </ul>
        </div>
    </nav>
</div>

<section class="aboutus" id="about">
    <div class="container">
        <div class="row">
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
            <td><button onclick="location.href='master_timetable?action=update_master_status&currentPage=${1}&recordsPerPage=5&recordId=${records.id}&master=${records.master_name}'"><fmt:message key="record_master_button"/></button></td>
        </tr>
    </c:forEach>

</table>
                    <nav aria-label="Navigation for records">
                        <ul class="pagination">
                            <c:if test="${currentPage != 1}">
                                <li class="page-item"><a class="page-link"
                                                         href="master_timetable?action=master_timetable&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}"><fmt:message key="record_admin_list_previous" /></a>
                                </li>
                            </c:if>

                            <c:forEach begin="1" end="${noOfPages}" var="i">
                                <c:choose>
                                    <c:when test="${currentPage eq i}">
                                        <li class="page-item active"><a class="page-link">
                                                ${i} <span class="sr-only">(current)</span></a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link"
                                                                 href="master_timetable?action=master_timetable&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${currentPage lt noOfPages}">
                                <li class="page-item"><a class="page-link"
                                                         href="master_timetable?action=master_timetable&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}"><fmt:message key="record_admin_list_next" /></a>
                                </li>
                            </c:if>
                        </ul>
                    </nav>
        </div>

        </main>
        </div>
    </div>
</section>
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="footer-logo">
                    <a href="#">
                        <i class="flaticon-lotus"></i>
                    </a>
                </div>

                <div class="footer-social">
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-google-plus"></i></a>
                    <a href="#"><i class="fa fa-linkedin"></i></a>
                    <a href="#"><i class="fa fa-pinterest-p"></i></a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6">
                <div class="footer-info">
                    <p>Copyright &copy; Untitled. All rights reserved. Design By <a href="https://awaikenthemes.com/" target="_blank">Awaiken Theme</a> Images <a href="https://unsplash.com/" target="_blank">Unsplash</a>, <a href="https://pixabay.com/" target="_blank">Pixabay</a>, <a href="http://www.freepik.com" target="_blank">Freepik</a>, Icon <a href="https://www.flaticon.com/" target="_blank">Flaticon</a></p>
                </div>
            </div>

            <div class="col-md-6">
                <div class="footer-menu">
                    <ul>
                        <li class="active"><a href="index.jsp"><fmt:message key="menu.main"/></a></li>
                        <li><a href="master?action=master"><fmt:message key="menu.masters"/></a></li>
                        <li><a href="services?action=service"><fmt:message key="menu.services"/></a></li>
                        <li><a href="response?action=response"><fmt:message key="menu.response"/></a></li>
                        <c:choose>
                            <%--===========================================================================
                                           This way we define the USER MENU.
                             ===========================================================================--%>

                            <c:when test="${userRole.name == 'user' }">
                                <li><a href="../select.jsp"><fmt:message key="menu.record"/></a></li>
                            </c:when>

                            <%--===========================================================================
                            This way we define the Master MENU.
                            ===========================================================================--%>
                            <c:when test="${userRole.name == 'master' }">
                                <li><a href="master_timetable?action=master_timetable"><fmt:message key="menu.timetable"/></a></li>
                            </c:when>

                            <%--===========================================================================
                            This way we define the Admin MENU.
                            ===========================================================================--%>
                            <c:when test="${userRole.name == 'admin'}">
                                <li><a href="record_list?action=admin_list&currentPage=${1}&recordsPerPage=10"><fmt:message key="menu.admin_list"/></a></li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- Footer section ends -->

<!-- Jquery Library File -->

</body>
</html>
    </c:when>
    <c:otherwise>
        <meta http-equiv="refresh" content="1;URL=jsp\error.jsp"/>
    </c:otherwise>
</c:choose>