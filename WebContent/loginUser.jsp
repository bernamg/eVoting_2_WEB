<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <p><a href="${facebookBean.authorizationUrlLogin}">Login com o FB</a></p>

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
