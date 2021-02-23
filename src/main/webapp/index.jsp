<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<ul>
<li><a href="index.jsp?sessionLocale=en"><fmt:message key="english" /></a></li>
<li><a href="index.jsp?sessionLocale=uk"><fmt:message key="ukrainian" /></a></li>
</ul>
</body>
</html>