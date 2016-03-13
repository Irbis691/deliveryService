<%-- 
    Document   : create
    Created on : Aug 10, 2015, 3:20:45 PM
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Update pizza</title>
    </head>
    <body>
        <form action="pizza/addnew" method="post">
            <input type="hidden" name="pizzaId" value="${pizza.id}"/>
            Name : <input type="text" name="name" value="${pizza.name}"/></br>
            <!--Type : <input type="text" name="pizzaType" value="${pizza.pizzaType}"/></br>-->
            Type : <select name="pizzaType" required>
                <c:forEach var="elem" items="${pizzaType}">
                    <option>
                        <c:out value="${elem}" />
                    </option>
                </c:forEach>
            </select>
            </br>
            Price : <input type="text" name="price" value="${pizza.price}"/></br>
            <input type="submit" value="Create"/></br>
        </form>
    </body>


</html>
