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
    <p><a href="<s:url action="gerirListasPage" />">Gerir lista de candidatos numa eleicao</a></p>
    <p><a href="<s:url action="gerirMesasPage" />">Gerir Mesas de Voto</a></p>
    <p><a href="<s:url action="gerirEleicaoPage" />">Alterar propriedades de uma eleicao</a></p>
    <p><a href="<s:url action="ondeVotouPage" />">Saber onde votou cada eleitor</a></p>
    <p><a href="<s:url action="detalhesEleicoesPage" />">Consultar detalhes das eleicoes</a></p>
    <p><a href="<s:url action="estadoUserPage" />">Listar Utilizadores Online</a></p>
    <p><a href="<s:url action="consultarEleicoesPage" />">Consultar resultados detalhados de eleições passadas</a></p>
    <p><a href="<s:url action="index" />">Back</a></p>
</body>
</html>
