<%-- 
    Document   : pizzas
    Created on : Aug 7, 2015, 6:09:29 PM
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzas List</title>
    </head>
    <body>        
        <table border="1">
            <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Price</th>
                </tr></thead>
            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.pizzaType}</td>
                    <td>${pizza.price}</td>
                    <td>
                        <form method="post" action="edit" >
                            <input type="hidden" name="pizzaId" value="${pizza.id}" />
                            <input type="submit" value="Edit" />
                        </form>
                    </td>
                     <td>
                        <form method="get" action="delete" >
                            <input type="hidden" name="pizzaId" value="${pizza.id}" />
                            <input type="submit" value="Delete" />
                        </form>
                    </td>
                </tr>            
            </c:forEach>
        </table>
        <br/>
        <form method="post" action="create" >            
            <input type="submit" value="Create new pizza" />
        </form>
    </body>
</html>
