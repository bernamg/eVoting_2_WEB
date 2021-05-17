<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Gerir Mesas</title>
</head>
<body>
<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro na Operacao---------------------</p>
    </c:when>
</c:choose>


<c:choose>
    <c:when test="${rmiBean.submitOption == 'insertTable'}">
        <p>--------------------- Mesas Presentes ---------------------</p>
        <c:forEach items="${rmiBean.tablesFromList}" var="value">
            <c:out value="${value}" /><br>
        </c:forEach>
        <s:form action="adicionarMesa" method="post">
            <s:text name="Nova Mesa de Voto:" />
            <s:textfield name="mesa" /><br>
            <s:submit />
        </s:form>
    </c:when>
    <c:when test="${rmiBean.submitOption == 'deleteTable'}">
        <p>Mesa a eliminar: </p>
        <s:form action="eliminarMesa" method="post">
            <p>
                <c:forEach items="${rmiBean.tablesFromList}" var="value">
                    <input type="radio" id="${value}" name="mesa" value="${value}">
                    <label for="${value}">${value}</label><br>
                </c:forEach>
            </p>
            <s:submit />
        </s:form>
    </c:when>
    <c:when test="${rmiBean.submitOption == 'deleteList'}">

    </c:when>
</c:choose>
<p><a href="<s:url action="gerirMesasPage" />">Back</a></p>


</body>
</html>