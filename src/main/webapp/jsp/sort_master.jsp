<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 17.02.2021
  Time: 11:23
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
                <li class="active"><a href="master?action=master"><fmt:message key="menu.masters"/></a></li>
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
            <div class="col-md-5">
                <div class="about-des0c">
                    <p>hbdfjbhsdjfbvkjdfbhvjdbfjvhbkjdfbhvjhsdbfvj
                        dfljgbdslkfjbgvlkjsjdfbglkjsdbfjgbhadlk
                        wef;kjenaflkgjvbalekrjghn
                        ewgojhaekpdkjgnpaoejnva
                        sdfgoaweedjhnvkawjendevpoiqneafv
                        wadwkaeo;dfnvg;iwef
                        awdgvjapweoioedfgnk;awnfvgw
                        efjaebfvkjaenrvonqeeorvnaowwrnvg;oaenv;olqekjinrg
                        qwerognqeojnrgpoiqqaehrfngpoaqenrv;lknqeorgv
                        qwergojadnblkbjbnqaekfgkvn;oakeefbgniko;aejbrg</p>
        <form method="post" action="controller?action=sort">
            <select size="5" name="sort" required>
                <option disabled><fmt:message key="master.select_sort"/></option>
                <option><fmt:message key="master.sort_by_master"/></option>
                <option><fmt:message key="master.sort_by_rate"/></option>
                <option><fmt:message key="master.sort_by_service"/></option>
            </select>

            <p><input type="submit" value="<fmt:message key="master.sort_button"/>" /></p>
        </form>
                </div>
            </div>
         <div class="col-md-7">
            <main class="m-3">
                <div class="row col-md-6">
                    <table class="table table-striped table-bordered table-sm">
            <tr>
                <th><fmt:message key="master.name_and_surname"/></th>
                <th><fmt:message key="master.rate"/></th>
                <th><fmt:message key="master.service_"/></th>
            </tr>
            <c:forEach var="masters_2" items="${masters_2}">
            <tr>
                <td>${masters_2.name}</td>
                <td>${masters_2.rate}</td>
                <td>${masters_2.services}</td>
            </tr>
            </c:forEach>
        </table>
                </div>
            </main>

        </div>
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
