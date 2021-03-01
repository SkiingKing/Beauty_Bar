<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Test</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-zh_CN.min.js"></script>

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
    <form class="row g-3" method="post" action="controller?action=record">
        <p><b>Master:</b>
            <select class="selectpicker" name="masters" data-style="btn-warning"  required>
                <option disabled><fmt:message key="record_user"/></option>
                <option> </option>
                <c:forEach var="masters" items="${masters}">
                    <option>${masters.name}</option>
                </c:forEach>
            </select>
        <div class="col-md-6">
            <label for="inputEmail4" class="form-label"><fmt:message key="record_admin_list_date"/></label>
        <input type="text" name="data" class="form-control" id="inputEmail4"  size="10" placeholder="<fmt:message key="record.pattern_date"/>" required/>
        </div>
        <div class="col-md-6">
            <label for="inputPassword4" class="form-label"><fmt:message key="record_admin_list_start"/></label>
            <input type="text" class="form-control" id="inputPassword4" name="start_time" size="10" placeholder="<fmt:message key="record.pattern_time"/>" required/>
        </div>
        <div class="col-12">
            <button type="submit" class="btn btn-primary"><fmt:message key="record_user_button_record"/></button>
        </div>
    </form>
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