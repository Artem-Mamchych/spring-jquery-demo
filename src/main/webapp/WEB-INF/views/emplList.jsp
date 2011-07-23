<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head></head>
<body>
<table border="1" width="100%">
    <c:forEach var="employee" items="${employees}" varStatus="i">
        <tr>
            <td width="20%"><spring:message code="label.fullname"/> <c:out
                    value="${employee.firstName} ${employee.lastName}"/>

            </td>
            <td width="80%"><spring:message code="label.salary"/> <c:out
                    value="${employee.baseSalary}"/>
            </td>
            <%--<td>
                 <a href="${pageContext.request.contextPath}/message/update/<c:out
                    value="${message.id}"/>"><spring:message code="label.message.edit"/></a>
                <a href="${pageContext.request.contextPath}/message/delete/<c:out
                    value="${message.id}"/>"><spring:message code="label.message.delete"/></a>
            </td>--%>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/add/"><spring:message code="label.add"/></a>
</body>
</html>