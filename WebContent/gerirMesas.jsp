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
        <p>Adeus</p>
        <c:forEach items="${rmiBean.allElections}" var="value">
            <a href="<s:url action="gerirMesasPage" />">${value}!</a> <br>
        </c:forEach>
    <p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
