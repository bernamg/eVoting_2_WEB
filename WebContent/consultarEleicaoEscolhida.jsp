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
     <p>Resultados da Eleicao:</p>
     <p>
         <c:forEach items="${rmiBean.resultsElection}" var="value">
             <c:out value="${value}" /><br>
         </c:forEach>
     </p>
    <p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>
