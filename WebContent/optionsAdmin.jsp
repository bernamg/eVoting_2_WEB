<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 06/05/2021
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <p><a href="<s:url action="createUserPage" />">Registar Pessoa</a></p>
    <p><a href="<s:url action="createElectionPage" />">Criar Eleicao</a></p>
    <p><a href="<s:url action="createElectionPage" />">Gerir lista de candidatos numa eleicao</a></p>
    <p><a href="<s:url action="index" />">Back to Index From optionsAdmin</a></p>
</body>
</html>
