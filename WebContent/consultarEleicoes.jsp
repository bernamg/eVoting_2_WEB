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
    <s:form action="selectElection" method="post">
        <h3>Eleicoes passadas</h3>
    <c:forEach items="${rmiBean.closedElections}" var="value">
        <input type="radio" id="${value}" name="election" value="${value}">
        <label for="${value}">${value}</label><br>
    </c:forEach>
    <s:submit />
    </s:form>
</body>
</html>
