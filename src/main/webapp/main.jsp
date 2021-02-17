<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beautybar.vn.entity.Role" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>BeautyBar</title>
    <style type="text/css">

        body {
            font: 10pt Arial, Helvetica, sans-serif;
            background: #e1dfb9;
        }
        h2 {
            font-size: 1.1em;
            color: #800040;
            margin-top: 0;
        }
        #container {
            width: 500px;
            margin: 0 auto;
            background: #f0f0f0;
        }
        #header {
            font-size: 1.2em;
            text-align: center;
            padding: 5px;
            background: #8fa09b;
            color: #ffe; /
        }
        #head_right{
            text-align: right;
            padding: 5px;
        }

        #sidebar {
            margin-top: 10px;
            width: 110px;
            padding: 0 10px;
            float: left;
        }
        #content {
            margin-left: 130px;
            padding: 10px;
            background: #fff;
        }
        #footer {
            background: #8fa09b;
            color: #fff;
            padding: 5px;
            clear: left;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">BeautyBar</div>
    <div id ="head_right">
        <a href="register.jsp">Register</a>
        <a href="login.jsp">Login</a>
        <a href="controller?action=logout">Logout</a>
    </div>

    <div id="sidebar">
        <p><a href="main.jsp">Main</a></p>

        <a onclick="location.href='master?action=master'">Masters</a>

<%--        <form method="post" action="controller?action=master">--%>
<%--            <p><input type="submit" value="Masters" /></p>--%>
<%--        </form>--%>
        <form method="post" action="controller?action=service">
            <p><input type="submit" value="Services" /></p>
        </form>
        <p><a href="select.jsp">Record</a></p>
        <p><a href="xx.jsp">Response</a></p>
        <form method="post" action="controller?action=master_timetable">
            <p><input type="submit" value="Time table" /></p>
        </form>
        <form method="post" action="controller?action=admin_list">
            <p><input type="submit" value="Admin list" /></p>
        </form>
    </div>


    <div id="content">
        <h2>Text</h2>
        <p>  Text types in literature form the basic styles of writing. Factual texts merely seek to inform,
            whereas literary texts seek to entertain or otherwise engage the reader by using creative language
            and imagery. There are many aspects to literary writing, and many ways to analyse it,
            but four basic categories are descriptive, narrative, expository, and argumentative.</p>
        <p>  Text types in literature form the basic styles of writing. Factual texts merely seek to inform,
            whereas literary texts seek to entertain or otherwise engage the reader by using creative language
            and imagery. There are many aspects to literary writing, and many ways to analyse it,
            but four basic categories are descriptive, narrative, expository, and argumentative.</p>
        <p>  Text types in literature form the basic styles of writing. Factual texts merely seek to inform,
            whereas literary texts seek to entertain or otherwise engage the reader by using creative language
            and imagery. There are many aspects to literary writing, and many ways to analyse it,
            but four basic categories are descriptive, narrative, expository, and argumentative.</p>
        <p>  Text types in literature form the basic styles of writing. Factual texts merely seek to inform,
            whereas literary texts seek to entertain or otherwise engage the reader by using creative language
            and imagery. There are many aspects to literary writing, and many ways to analyse it,
            but four basic categories are descriptive, narrative, expository, and argumentative.</p>

    </div>
    <div id="footer">instagram:@BeutyBar</div>
</div>
</body>
</html>