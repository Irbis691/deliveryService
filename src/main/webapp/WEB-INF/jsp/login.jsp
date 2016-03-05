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
        <title><spring:message code="login.title" /></title>
    </head>
    <body>
        <div align="center">
            <form:form action="registration" method="post" modelAttribute="account" commandName="account">
                <table>
                    <tr>
                        <td colspan="2" align="center"><h2><spring:message code="registration.title" /></h2></td>
                    </tr>
                    <tr>
                        <td><spring:message code="registration.mail" /></td>
                        <td><label class="col-sm-2 control-label"><form:input path="mail" /></label></td>
                    </tr>
                    <tr>
                        <td><spring:message code="registration.pass" /></td>
                        <td><label class="col-sm-2 control-label"><form:password path="password" /></label></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="<spring:message code="registration.button" />" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </body>
</html>
