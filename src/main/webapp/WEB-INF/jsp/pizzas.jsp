<%-- 
    Document   : pizzas
    Created on : Aug 7, 2015, 6:09:29 PM
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:include page="fragments/header.jsp" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="pizzas.title" /></title>
    </head>
    <body>        
        <div class="container">            
            <h2><spring:message code="pizzas.title" /></h2>
            <h2>Order: ${order.toString()}</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><spring:message code="pizzas.name" /></th>
                        <th><spring:message code="pizzas.type" /></th>
                        <th><spring:message code="price" /></th>
                        <th colspan="2"><spring:message code="actions" /></th>
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
                                    <input class="btn btn-danger" type="submit" value="<spring:message code="pizzas.order" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td>
                                <form method="post" action="edit" >
                                    <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                    <input class="btn btn-info" type="submit" value="<spring:message code="edit" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                            <td>
                                <form method="get" action="delete" >
                                    <input type="hidden" name="pizzaId" value="${pizza.id}" />
                                    <input class="btn btn-danger" type="submit" value="<spring:message code="delete" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>
                    </tr>            
                </c:forEach>
            </table>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <form method="post" action="create" >            
                    <input class="btn btn-primary pull-right" type="submit" value="<spring:message code="pizzas.create.pizza" />" />
                    <sec:csrfInput />
                </form>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_USER')">
                <form method="post" action="placeOrder" >
                    <input class="btn btn-primary pull-right" type="submit" value="<spring:message code="pizzas.place.order" />" />
                    <sec:csrfInput />
                </form>
            </sec:authorize>
        </div>
    </body>    
</html>
