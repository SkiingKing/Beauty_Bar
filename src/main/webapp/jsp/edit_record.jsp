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

    <form method="post" action="controller?action=sort">
<c:forEach var="records" items="${one_record}">
        <p><input type="text" value="one_record" /></p>
        <p><input type="text" value="one_record" /></p>
        <p><input type="text" value="one_record" /></p>
        <p><input type="text" value="one_record" /></p>

</c:forEach>
        <p><input type="submit" value="Send" /></p>
    </form>

</body>
</html>
