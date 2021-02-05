<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
        <style type="text/css">
            #center{
                text-align: center;
            }
        </style>

    <div id ="center">
 <form method="post" action="controller?action=login">
       <p><b>Email:</b>
    <p><input type="text" name="email"  size="10"/></p>
       <p><b>Password:</b>
    <p><input type="password" name="password"  size="10" /></p>
    <p><input type="submit" value="Login" /></p>
    </div>
  </form>

</body>
</html>
