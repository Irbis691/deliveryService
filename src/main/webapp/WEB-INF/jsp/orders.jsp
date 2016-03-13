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
        <title><spring:message code="orders" /></title>
    </head>
    <body>
        <div class="container">
            <h2><spring:message code="orders" /></h2>            
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th><spring:message code="orders.id" /></th>                        
                        <th><spring:message code="price" /></th>
                        <th><spring:message code="order.size" /></th>
                        <th><spring:message code="orders.curr.status" /></th>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <th colspan="2"><spring:message code="order.chng.stat" /></th>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <th colspan="2"><spring:message code="actions" /></th>
                        </sec:authorize>
                    </tr>
                </thead>
                <c:forEach var="order" items="${orders}">
                    <tr>                    
                        <td>${order.id}</td>                        
                        <td>${order.orderPrice}</td>
                        <td>${order.orderSize}</td>                        
                        <td>${order.orderStatus}</td>
                        <%--<c:if ${order.orderStatus.validTransitionStatuses} not empty></c:if>--%>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <td>
                                <form method="post" action="order/status" >
                                    <select name="status">
                                        <c:forEach var="transStatus" items="${order.orderStatus.validTransitionStatuses}">
                                            <option value="${transStatus}">${transStatus}</option>
                                        </c:forEach>
                                    </select>                                    
                                    <input type="hidden" name="orderId" value="${order.id}" />
                                    <input class="btn btn-info" type="submit" value="<spring:message code="order.chng" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')">
                            <td>
                                <form method="post" action="order/edit" >
                                    <input type="hidden" name="orderId" value="${order.id}" />
                                    <input class="btn btn-info" type="submit" value="<spring:message code="edit" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                            <td>
                                <form method="get" action="order/delete" >
                                    <input type="hidden" name="orderId" value="${order.id}" />
                                    <input class="btn btn-danger" type="submit" value="<spring:message code="delete" />" />
                                    <sec:csrfInput />
                                </form>
                            </td>
                        </sec:authorize>                                    
                    </tr>
                </c:forEach>
            </table>            
        </div>
    </body>
</html>
