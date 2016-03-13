<%-- 
    Document   : registration
    Created on : 02.03.2016, 17:12:18
    Author     : Irbis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="fragments/header.jsp" />

<html>
    <head>        
        <title><spring:message code="profile.title" /></title>
    </head>
    <body>
        <div class="container">
            <h2><spring:message code="profile.title" /></h2>
            <form:form class="form-horizontal" action="profile" method="post" modelAttribute="account" commandName="account">
                <spring:bind path="login">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2"><spring:message code="profile.login" /></label>
                        <div class="col-sm-10">
                            <form:input path="login" class="form-control"/>
                            <form:errors path="login" class="control-label" />
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="mail">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2"><spring:message code="registration.mail" /></label>
                        <div class="col-sm-10">
                            <form:input path="mail" class="form-control"/>
                            <form:errors path="mail" class="control-label" />
                        </div>
                    </div>
                </spring:bind>
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">                        
                        <label class="col-sm-2"><spring:message code="registration.pass" /></label>
                        <div class="col-sm-10">
                            <form:input path="password" class="form-control"/>
                            <form:errors path="password" class="control-label" />
                        </div>
                    </div>                            
                </spring:bind>
                <div class="form-group">
                    <label class="col-sm-2"><spring:message code="profile.address" /></label>
                    <div class="col-sm-10">
                        <form:input path="address.street" class="form-control"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2"><spring:message code="profile.card" /></label>
                    <div class="col-sm-10">${bonus}</div>
                </div>                                
                <form:button class="btn-lg btn-primary pull-left" type="submit"><spring:message code="edit" /></form:button>
            </form:form>
        </div>
    </body>
</html>
