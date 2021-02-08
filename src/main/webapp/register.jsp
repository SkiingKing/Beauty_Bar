<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <style type="text/css">
       #center{
            text-align: center;

        }
   </style>
   <div id = "center">
   <form method="post" action="controller?action=register">
       <p><b>Email:</b>
       <p><input type="text" name="email" size="10"/></p>
       <p><b>Name and surname:</b>
       <p><input type="text" name="name_and_surname" size="10"/></p>
       <p><b>Password:</b>
       <p><input type="password" name="password" size="10" /></p>

       <p><input type="submit" value="Register" /></p>
   </form>
   </div>

</body>
</html>
