<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 14/07/2021
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
</head>
<body>
<form action="/result" method="get">
<table class="table">
    <thead>
    <tr>
        <th>USD:</th>
        <td><input type="number" name="usd" placeholder="number"></td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td colspan="2"><input type="submit" value="Convert"></td>
    </tr>
    </tbody>
</table>
</form>
</body>
</html>
