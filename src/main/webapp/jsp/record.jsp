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
                <option disabled><fmt:message key="record_user"/></option>
                <option> </option>
                <c:forEach var="masters" items="${masters}">
                    <option>${masters.name}</option>
                </c:forEach>
            </select>
        <p> <b><fmt:message key="record_admin_list_date"/></b></p>
        <p><input type="text" name="data"  size="10" placeholder="yy-mm-dd" required/></p>
        <b><fmt:message key="record_admin_list_start"/></b>
        <p><input type="text" name="start_time"  size="10" placeholder="hh:mm:ss" required/></p>

        <p><input type="submit" value="<fmt:message key="record_user_button_record"/>" /></p>
    </form>


</div>

</body>
</html>
