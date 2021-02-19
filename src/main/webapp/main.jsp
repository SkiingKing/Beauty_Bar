<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="beautybar.vn.entity.Role" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>BeautyBar</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
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
        #menu{
            margin: 15px;
            padding: 2px;
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
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link active" href="register.jsp">Register</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">Login</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="controller?action=logout">Logout</a>
        </li>
    </ul>
    </div>

    <div id="sidebar">
        <div id="menu">
                <a class="nav-link active" href="main.jsp">Main</a>
                <a class="nav-link" onclick="location.href='master?action=master'">Masters</a>
                <a class="nav-link" onclick="location.href='services?action=service'">Services</a>
                <a class="nav-link" onclick="location.href='master_timetable?action=master_timetable'">Time table</a>
                <a class="nav-link" onclick="location.href='record_list?action=admin_list&currentPage=${1}&recordsPerPage=10'">Admin list</a>
                <a class="nav-link" href="select.jsp">Record</a>
                <a class="nav-link" href="xx.jsp">Response</a>

        </div>
    </div>


    <div id="content">
<%--        <main class="m-3">--%>

<%--            <h1>Show countries</h1>--%>

<%--            <form action="record_list">--%>

<%--                <input type="hidden" name="currentPage" value="1">--%>

<%--                <div class="form-group col-md-4">--%>

<%--                    <label for="records">Select records per page:</label>--%>

<%--                    <select class="form-control" id="records" name="recordsPerPage">--%>
<%--                        <option value="5">5</option>--%>
<%--                        <option value="10" selected>10</option>--%>
<%--                        <option value="15">15</option>--%>
<%--                    </select>--%>

<%--                </div>--%>

<%--                <button type="submit" class="btn btn-primary">Submit</button>--%>

<%--            </form>--%>
<%--        </main>--%>
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