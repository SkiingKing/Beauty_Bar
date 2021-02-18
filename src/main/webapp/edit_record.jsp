<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 18.02.2021
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <form method="post" action="controller?action=edit">
        Record id:
        <input type="text" name="recordId"/>
        <input type="text" name="start"/>
        <input type="text" name="end"/>

<%--        <input type="text" value="<%=request.getParameter("recordId")%>"/>--%>
<%--        <p><input type="text" value="<%=request.getParameter("start")%>" /></p>--%>
<%--        <p><input type="text" value="<%=request.getParameter("end")%>" /></p>--%>
        <p><input type="submit" value="Edit" /></p>
    </form>

</body>
</html>
