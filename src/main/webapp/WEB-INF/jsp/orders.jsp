<%-- 
    Document   : orders
    Created on : 08.03.2016, 22:59:56
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="fragments/header.jsp" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><spring:message code="orders.title" /></title>
    </head>
    <body>
        <div class="container">
            <h2><spring:message code="orders.title" /></h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th><spring:message code="orders.id" /></th>
                        <th><spring:message code="orders.status" /></th>
                        <th><spring:message code="price" /></th>
                        <th colspan="2"><spring:message code="actions" /></th>
                    </tr>
                </thead>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.orderStatus}</td>
                        <td>${order.orderPrice}</td>
                        <td>
                            <form method="post" action="orderEdit" >
                                <input type="hidden" name="orderId" value="${order.id}" />
                                <input class="btn btn-info" type="submit" value="<spring:message code="edit" />" />
                                <sec:csrfInput />
                            </form>
                        </td>
                        <td>
                            <form method="get" action="orderDelete" >
                                <input type="hidden" name="orderId" value="${order.id}" />
                                <input class="btn btn-danger" type="submit" value="<spring:message code="delete" />" />
                                <sec:csrfInput />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
