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
<p>Eleicao a editar:</p>
<s:form action="editListFirst" method="post">
    <p>
        <c:forEach items="${rmiBean.openElections}" var="value">
            <input type="radio" id="${value}" name="election" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>
    <s:submit />
</s:form>
<p><a href="<s:url action="gerirListasPage" />">Back</a></p>
</body>
</html>