<%-- 
    Document   : login
    Created on : 02.03.2016, 17:12:18
    Author     : Irbis
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="fragments/header.jsp" />

<html>
    <head>
        <title><spring:message code="login.title" /></title>
    </head>
    <sec:authorize access="isAnonymous()">
        <body>
            <div class="container">
                <h2><spring:message code="login.title" /></h2>
                <form class="form-horizontal" action="login" method="post">                    
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><spring:message code="registration.login" /></label>                    
                        <div class="col-sm-10">
                            <input id="username_or_email" name="username" type="text" class="form-control" placeholder="test"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label"><spring:message code="registration.pass" /></label>                    
                        <div class="col-sm-10">                        
                            <input id="password" name="password" type="password" class="form-control" placeholder="password"/>
                        </div>
                    </div>                    
                    <input class="btn-lg btn-primary pull-right" name="commit" type="submit" value="<spring:message code="login.button" />" />
                    <sec:csrfInput />
                </form>
                <c:if test='${error}'>                    
                    <label class="col-sm-2 control-label pull-right text-danger">
                        <spring:message code="login.fail" />
                    </label>                    
                </c:if>
            </div>
        </body>
    </sec:authorize>
</html>
