<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 10/05/2021
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gerir Mesas de Voto</title>
</head>
<body>
    <p>Eleicao a editar:</p>
    <s:form action="gerirMesas" method="post">
        <p>
            <c:forEach items="${rmiBean.openElections}" var="value">
                <input type="radio" id="${value}" name="election" value="${value}">
                <label for="${value}">${value}</label><br>
            </c:forEach>
        </p>
        <p><button type="submit" id="insertTable" name="submitOption" value="insertTable" >Adicionar Mesa</button></p>
        <p><button type="submit" id="deleteTable" name="submitOption" value="deleteTable" >Eliminar Mesa</button></p>
    </s:form>
    <p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
