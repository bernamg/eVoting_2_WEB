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
    <title>Gerir Listas de Candidatos</title>
</head>
<body>
    <p><a href="<s:url action="criarListaPage" />">Criar Lista</a></p>
    <p><a href="<s:url action="editarListaEscolhaPage" />">Editar Listas Existentes</a></p>
    <p><a href="<s:url action="optionsAdminPage" />">Voltar</a></p>
</body>
</html>
