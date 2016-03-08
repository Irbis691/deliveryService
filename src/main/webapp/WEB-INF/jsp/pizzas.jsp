<%-- 
    Document   : pizzas
    Created on : Aug 7, 2015, 6:09:29 PM
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="fragments/header.jsp" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzas List</title>
    </head>    
    <body>
        <div class="container">
            <%--<c:if test='${order}'>--%>
            <!--                <h2>Current order</h2>
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>Name</th>
                                        <th>Type</th>
                                        <th>Price, $</th>
                                        <th colspan="2">Actions</th>
                                    </tr>
                                </thead>-->
            <%--<c:forEach var="pizza" items="${order.pizzas}">--%>
            <!--                        <tr>
                                        <td>${pizza.name}</td>
                                        <td>${pizza.pizzaType}</td>
                                        <td>${pizza.price}</td>
                                        <td>
                                            <form method="get" action="del" >
                                                <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                                <input class="btn btn-info" type="submit" value="Delete" />
                                            </form>
                                        </td>
                                    </tr>-->
            <%--</c:forEach>--%>
            <!--</table>-->
            <%--</c:if>--%>           
            <h2>Avaliable pizzas</h2>
            <h2>Order: ${order.toString()}</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Price, $</th>
                        <th colspan="2">Actions</th>
                    </tr>
                </thead>
                <c:forEach var="pizza" items="${pizzas}">
                    <tr>
                        <td>${pizza.name}</td>
                        <td>${pizza.pizzaType}</td>
                        <td>${pizza.price}</td>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td>
                                <form method="post" action="order" >                                    
                                    <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                    <input class="btn btn-danger" type="submit" value="Add" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td>
                                <form method="post" action="edit" >
                                    <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                    <input class="btn btn-info" type="submit" value="Edit" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                            <td>
                                <form method="get" action="delete" >
                                    <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                    <input class="btn btn-primary" type="submit" value="Delete" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>
                    </tr>            
                </c:forEach>
            </table>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <form method="post" action="create" >            
                    <input class="btn btn-primary pull-right" type="submit" value="Create new pizza" />
                    <sec:csrfInput />
                </form>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <form method="post" action="placeOrder" >            
                    <input type="hidden" name="order" value="${order}" />
                    <input class="btn btn-primary pull-right" type="submit" value="Place order" />
                    <sec:csrfInput />
                </form>
            </sec:authorize>
        </div>
    </body>    
</html>
