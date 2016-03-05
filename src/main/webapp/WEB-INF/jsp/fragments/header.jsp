
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
    <head>
        <spring:url value="/resources/css/hello.css" var="coreCss" />
        <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${coreCss}" rel="stylesheet" />
    </head>

    <spring:url value="?language=en" var="enLang" />
    <spring:url value="?language=ru" var="ruLang" />

    <nav class="navbar navbar-inverse ">
        <div class="container">
            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">                    
                    <li class="active"><a href="${enLang}"><spring:message code="en" /></a></li>
                    <li class="active"><a href="${ruLang}"><spring:message code="ru" /></a></li>                    
                </ul>
            </div>
        </div>
    </nav>

</html>