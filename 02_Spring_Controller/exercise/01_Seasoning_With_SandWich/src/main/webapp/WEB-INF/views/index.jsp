
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%--
  Created by IntelliJ IDEA.
  User: Acer
  Date: 16/07/2021
  Time: 3:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="get">
    <input onclick="check()" type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input onclick="check()" type="checkbox" name="condiment" value="Tomato">Tomato
    <input onclick="check()" type="checkbox" name="condiment" value="Mustard">Mustard
    <input onclick="check()" type="checkbox" name="condiment" value="Sprouts">Sprouts
    <input onclick="check()" id="nothing" type="checkbox" name="condiment" value="nothing" checked hidden>
    <hr>
    <input type="submit" value="Save">
  </form>
  <p> You have choose : </p>
  <c:forEach items="${result}" var="spice">
    <p>${spice}</p>
  </c:forEach>
  <script>
    function check() {
      document.getElementById("nothing").checked = false;
    }
  </script>
  </body>
</html>
