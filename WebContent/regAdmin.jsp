<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 03/05/2021
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Admin</title>
</head>
<body>
    <s:form action="registerAdmin" method="post">
        <s:text name="Username:" />
        <s:textfield name="username" /><br>
        <s:text name="Password:" />
        <s:textfield name="password" type="password" /><br>
        <s:submit />
    </s:form>
    <p><a href="<s:url action="index" />">Back</a></p>
</body>
</html>
