<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>List Student</h2>
    <a href="/student/create">Create new student</a>
    <p style="color: green">${msg}</p>
    <table border="1">
        <tr>
            <th>No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Date of birth</th>
            <th colspan="2">Action</th>
        </tr>
        <c:forEach var="studentObj" items="${listStudent}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${studentObj.id}</td>
                <td>${studentObj.name}</td>
                <td>${studentObj.dateOfBirth}</td>
                <td>
                    <a href="/student/detail?idStudent=${studentObj.id}">Detail RP</a>
                </td>
                <td>
                    <a href="/student/detail/${studentObj.id}">Detail PV</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
