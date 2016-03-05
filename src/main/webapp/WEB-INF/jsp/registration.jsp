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
        <title><spring:message code="registration.title" /></title>
    </head>
    <body>
        <div class="container">

            <h2><spring:message code="registration.title" /></h2>

            <form:form class="form-horizontal" action="registration" method="post" modelAttribute="account" commandName="account">

                <spring:bind path="mail">
                    <div class="form-group ${status.error ? 'has-error' : ''}">                        
                        <label class="col-sm-2 control-label"><spring:message code="registration.mail" /></label>
                        <div class="col-sm-10">
                            <form:input path="mail" class="form-control" placeholder="test@gmail.com"/>
                            <form:errors path="mail" class="control-label" />
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">           
                        <label class="col-sm-2 control-label"><spring:message code="registration.pass" /></label>
                        <div class="col-sm-10">
                            <form:password path="password" class="form-control" placeholder="password"/>
                            <form:errors path="password" class="control-label"  />
                        </div>
                    </div>
                </spring:bind>

                <form:button class="btn-lg btn-primary pull-right" type="submit"><spring:message code="registration.button" /></form:button>                    </p>

        </form:form>
    </div>
</body>
</html>
