<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 14/07/2021
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
<c:choose>
    <c:when test="${result==null}">
        <h1>NotFound</h1>
    </c:when>
    <c:otherwise><h1>Result: ${result}</h1></c:otherwise>
</c:choose>
</body>
</html>
