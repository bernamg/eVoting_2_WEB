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
    <title>Gerir Eleicao</title>
</head>
<body>
<p>Eleicao a editar:</p>
<s:form action="editElection" method="post">
    <p>
        <c:forEach items="${rmiBean.toStartElections}" var="value">
            <input type="radio" id="${value}" name="election" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>
    <p>
        <label for="dataInicio">Data e Hora de Inicio:</label>
        <input type="datetime-local" id="dataInicio" name="dataInicio">
        <p> <label for="dataFim">Data e Hora de Fim:</label>
        <input type="datetime-local" id="dataFim" name="dataFim"></p>
        <s:text name="Titulo:" />
        <s:textfield name="titulo" /><br>
        <s:text name="Descricao:" />
        <s:textfield name="desc" /><br>
        <s:submit /> <input type="reset">
    </p>
</s:form>
<p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
