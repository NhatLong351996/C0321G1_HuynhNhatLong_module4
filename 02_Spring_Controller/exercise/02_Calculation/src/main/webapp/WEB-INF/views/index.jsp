<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 16/07/2021
  Time: 5:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="get">
<div style="margin-bottom: 10px">
    <input type="text" name="firstnumber">
    <input type="text" name="secondnumber">
</div>
    <button type="submit" name="operator" value="+">Addition(+)</button>
    <button type="submit" name="operator" value="-">Subtraction(-)</button>
    <button type="submit" name="operator" value="*">Mutiplication(*)</button>
    <button type="submit" name="operator" value="/">Division(/)</button>
</form>
<hr>
<p>Result: ${result}</p>
</body>
</html>
