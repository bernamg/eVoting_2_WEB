<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Votar em Lista</title>
</head>
<body>

<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro ao Votar---------------------</p>
    </c:when>
</c:choose>


<s:form action="votarEleicaoFinal" method="post">
    <p>Escolha <strong>a</strong> Lista em que quer votar:</p>
        <c:forEach items="${rmiBean.list}" var="value">
            <input type="checkbox" id="${value}" name="votos" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    <s:submit />
</s:form>

<p><a href="<s:url action="votarEleicaoPage" />">Back</a></p>
</body>
</html>