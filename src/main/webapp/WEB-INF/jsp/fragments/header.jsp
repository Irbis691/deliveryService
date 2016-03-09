
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
                <ul class="nav navbar-nav navbar-left">
                    <sec:authorize access="isAnonymous()">
                        <li class="active">
                            <form action="login" method="get" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="profile.login" />"/>
                                <sec:csrfInput />
                            </form>
                        </li>
                        <li class="active">
                            <form action="registration" method="get" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="registration.title" />"/>
                                <sec:csrfInput />
                            </form>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="active">
                            <form action="logout" method="post" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="logout" />"/>
                                <sec:csrfInput />
                            </form>
                        </li>
                        <li class="active">
                            <form action="pizzas" method="get" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="pizzas.title" />"/>
                                <sec:csrfInput />
                            </form>                           
                        </li>
                        <li class="active">
                            <form action="orders" method="get" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="orders" />"/>
                                <sec:csrfInput />
                            </form>
                        </li>                        
                        <li class="active">
                            <form action="profile" method="get" >
                                <input class="btn btn-link" type="submit" value="<spring:message code="profile.title" />"/>
                                <sec:csrfInput />
                            </form>                           
                        </li>
                    </sec:authorize>
                </ul>                
            </div>
        </div>
    </nav>

</html>