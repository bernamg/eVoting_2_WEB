<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consultar Eleicoes</title>
</head>
<body>
<p>Detalhes Eleicoes:</p>
<p>
    <c:forEach items="${rmiBean.infoEleicoes}" var="value">
        <c:out value="${value}" /><br>
    </c:forEach>
</p>
<p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
