<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Carneiro
  Date: 12/05/2021
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultar Eleicoes</title>
</head>
<body>
<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro na escolha de Eleicao---------------------</p>
    </c:when>
</c:choose>

    <s:form action="ElectionResult" method="post">
        <c:forEach items="${rmiBean.closedElections}" var="value">
            <input type="radio" id="${value}" name="election" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
        <s:submit />
    </s:form>

    <p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
