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
        <c:forEach items="${rmiBean.openElections}" var="value">
            <input type="radio" id="${value}" name="election" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>

    <h2>Insira as propriedades a alterar</h2>
    <label for="dataInicio">Data e Hora de Inicio:</label>
    <input type="datetime-local" id="dataInicio" name="dataInicio">
    <p> <label for="dataFim">Data e Hora de Fim:</label>
        <input type="datetime-local" id="dataFim" name="dataFim"></p>

    <p>Escolha <strong>uma ou mais</strong> opcoes:</p>
    <input type="checkbox" id="estudante" name="quemVota" value="estudante">
    <label for="estudante">Estudante</label><br>
    <input type="checkbox" id="docente" name="quemVota" value="docente">
    <label for="docente"> Docente</label><br>
    <input type="checkbox" id="funcionario" name="quemVota" value="funcionario">
    <label for="funcionario">Funcionario</label>
    <p>
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
