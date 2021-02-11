<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Record</title>
</head>
<body>
<style type="text/css">
    #center{
        text-align: center;

    }
</style>
<div id = "center">
    <form method="post" action="controller?action=record">
        <p><b>Master:</b>
            <select name="masters" required>

                <jsp:useBean id="item" class="beautybar.vn.Test" scope="request"/>
                    <option disabled>Select master</option>
                             <option> </option>
                        <c:forEach var="item" items="${item.list}">
                            <option>${item}</option>
                        </c:forEach>
            </select>
        <p> <b>Data:</b></p>
        <p><input type="text" name="data"  size="10" placeholder="yy-mm-dd" required/></p>
        <b>Start:</b>
        <p><input type="text" name="start_time"  size="10" placeholder="hh:mm:ss" required/></p>

        <p><input type="submit" value="Sign up" /></p>
    </form>
</div>

</body>
</html>
