<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 09.02.2021
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="beautybar.vn.command.SelectCommand" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Select</title>
</head>
<body>
<style type="text/css">
    #center{
        text-align: center;

    }
</style>
<div id = "center">
    <form method="post" action="controller?action=select">
        <b>Service</b>
        <select size="5" name="services" required>
            <option disabled>Select service</option>
            <jsp:useBean id="item" class="beautybar.vn.command.SelectCommand" scope="request"/>
                <c:forEach var="item" items="${item.services}">
                    <option>${item}</option>
                </c:forEach>
        </select>

        <p><input type="submit" value="Send" /></p>
    </form>
</div>

</body>
</html>

