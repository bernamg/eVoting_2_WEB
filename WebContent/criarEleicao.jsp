<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 06/05/2021
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Election</title>
</head>
<body>
<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro na criacao da Eleicao---------------------</p>
    </c:when>
</c:choose>

<s:form action="createElection" method="post">
        <label for="dataInicio">Data e Hora de Inicio:</label>
        <input type="datetime-local" id="dataInicio" name="dataInicio">
       <p> <label for="dataFim">Data e Hora de Fim:</label>
        <input type="datetime-local" id="dataFim" name="dataFim"></p>

        <p>Escolha <strong>uma ou mais</strong> opcoes:</p>
        <input type="checkbox" id="estudante" name="quemVota" value="Estudante">
        <label for="estudante">Estudante</label><br>
        <input type="checkbox" id="docente" name="quemVota" value="Docente">
        <label for="docente"> Docente</label><br>
        <input type="checkbox" id="funcionario" name="quemVota" value="Funcionario">
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
