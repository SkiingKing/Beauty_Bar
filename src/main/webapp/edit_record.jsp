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
    <c:when test="${userRole.name == 'admin'}">
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
                        <li><a href="select.jsp"><fmt:message key="menu.record"/></a></li>
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

    <form method="post" action="controller?action=edit">
        <p><fmt:message key="record_admin_list_id" /></p>
        <input type="text" value="<%=request.getParameter("recordId")%>" name="recordId"/>
        <p><fmt:message key="record_admin_list_start" /></p>
        <input type="text" value="<%=request.getParameter("start")%>" name="start"/>
        <p><fmt:message key="record_admin_list_end"/></p>
        <input type="text" value="<%=request.getParameter("end")%>"  name="end"/>

<%--        <input type="text" value="<%=request.getParameter("recordId")%>"/>--%>
<%--        <p><input type="text" value="<%=request.getParameter("start")%>" /></p>--%>
<%--        <p><input type="text" value="<%=request.getParameter("end")%>" /></p>--%>
        <p><input type="submit" value="Edit" /></p>
    </form>

</body>
</html>
</c:when>
<c:otherwise>
<meta http-equiv="refresh" content="1;URL=jsp\error.jsp"/>
</c:otherwise>
</c:choose>
