<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Add employee</title>
</head>
<body>
<div class="container">
    <h1>
        Add employee
    </h1>

    <div class="span-12 last">
        <form:form modelAttribute="employee" action="employee" method="post">
            <form:input path="id" readonly="true" type="hidden"/>
            <fieldset>
                <legend>employee Fields</legend>
                <p>
                    <form:label for="firstName" path="firstName" cssErrorClass="error">firstName</form:label><br/>
                    <form:input path="firstName"/> <form:errors path="firstName"/>
                </p>

                <p>
                    <form:label for="lastName" path="lastName" cssErrorClass="error">lastName</form:label><br/>
                    <form:input path="lastName"/> <form:errors path="lastName"/>
                </p>

                <p>
                    <input type="submit"/>
                </p>
            </fieldset>
        </form:form>
    </div>
    <hr>
    <%--	<ul>
         <li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
     </ul>--%>
</div>
</body>
</html>