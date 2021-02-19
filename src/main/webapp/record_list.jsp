
<%--
  Created by IntelliJ IDEA.
  User: shvep
  Date: 17.02.2021
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous">
</head>
</head>
<body>
<main class="m-3">
    <div class="row col-md-6">
        <table class="table table-striped table-bordered table-sm">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Stage</th>
        <th>Status for admin</th>
        <th>Start time</th>
        <th>Ending time</th>
        <th>Service</th>
        <th>Master name</th>
    </tr>
    <c:forEach var="records" items="${records}">
        <tr>
            <td>${records.id}</td>
            <td>${records.date}</td>
            <td>${records.stage}</td>
            <td>${records.status_for_admin}</td>
            <td>${records.starting_time}</td>
            <td>${records.ending_time}</td>
            <td>${records.service}</td>
            <td>${records.master_name}</td>
            <td><button onclick="location.href='record_list?action=deleteRecord&recordId=${records.id}'">Delete</button></td>
            <td><button onclick="location.href='edit_record.jsp'"/>Edit</td>
            <td><button onclick="location.href='record_list?action=update_admin_status&recordId=${records.id}'">Сalculate</button></td>
        </tr>
    </c:forEach>

</table>
    </div>
    <nav aria-label="Navigation for records">
        <ul class="pagination">
            <c:if test="${currentPage != 1}">
                <li class="page-item"><a class="page-link"
                                         href="record_list?action=admin_list&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active"><a class="page-link">
                                ${i} <span class="sr-only">(current)</span></a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item"><a class="page-link"
                                                 href="record_list?action=admin_list&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt noOfPages}">
                <li class="page-item"><a class="page-link"
                                         href="record_list?action=admin_list&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</main>

</body>
</html>
