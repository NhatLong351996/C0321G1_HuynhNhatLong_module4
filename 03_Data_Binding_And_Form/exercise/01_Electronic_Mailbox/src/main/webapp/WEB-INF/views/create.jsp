<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 16/07/2021
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<h1>Settings</h1>

<form:form modelAttribute="email" action="/infor" method="post" >
    <table class="table">
        <tr>
            <th>Languages: </th>
            <td><form:select path="languages" items="${languagesArray}"/></td>
        </tr>
        <tr>
            <th>Page Size: </th>
            <td>Show <form:select path="pageSize" items="${pageSizeArray}"/> emails per page</td>
        </tr>
        <tr>
            <th>Spams filter: </th>
            <td><form:checkbox path="spamsFilter"/> Enable spams filter</td>
        </tr>
        <tr>
            <th>Signature: </th>
            <td>Show <form:textarea path="signature"/></td>
        </tr>
        <tr>
           <td><input type="submit" value="update" style="background-color: blue"></td>
           <td><input type="submit" value="Cancel" style="background-color: wheat"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
