<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 03/05/2021
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login User</title>
</head>
<body>
    <c:choose>
        <c:when test="${facebookBean.authorizationUrl != null}">
            <p><a href="${facebookBean.authorizationUrl}">Login com o FB</a></p>
        </c:when>
    </c:choose>
    <s:if test="%{#authorizationUrl != null}"> <!-- ESTE IF ESTA A FALHAR -->

    </s:if>

    <h3>Login normal</h3>
    <s:form action="loginUser" method="post">
        <s:text name="Username:" />
        <s:textfield name="username" /><br>
        <s:text name="Password:" />
        <s:textfield name="password" type="password" /><br>
        <s:submit />
    </s:form>
    <p><a href="<s:url action="index" />">Back</a></p>
</body>
</html>
