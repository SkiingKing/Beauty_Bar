<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <p><b>Service_id:</b>
        <p><input type="text" name="service_id" size="10" /></p>
        <p><b>Master_id:</b>
        <p><input type="text" name="services_master_id" size="10" /></p>
        <p><b>Data:</b>
        <p><input type="text" name="data" size="10"/></p>
        <p><b>Start time:</b>
        <p><input type="text" name="start_time" size="10"/></p>
        <p><b>Ending time:</b>
        <p><input type="text" name="ending_time" size="10" /></p>



        <p><input type="submit" value="Send" /></p>
    </form>
</div>

</body>
</html>
