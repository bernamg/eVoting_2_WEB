<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Editar Lista</title>
</head>
<body>

<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro na criacao da Eleicao---------------------</p>
    </c:when>
</c:choose>

<p>Eleitores Registados:</p>

<s:form action="ondeVotou" method="post">
    <p>
        <c:forEach items="${rmiBean.allUsers}" var="value">
            <input type="radio" id="${value}" name="user" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>
    <s:submit />
</s:form>
<p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
</body>
</html>