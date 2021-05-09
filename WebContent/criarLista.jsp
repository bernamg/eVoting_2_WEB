<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Criar Lista</title>
</head>
<body>

<c:forEach items="${RmiBean.allUsers}" var="value">
    <a href="<s:url action="criarListasPage" />">${value}!</a> <br>
</c:forEach>



<c:forEach items="${RmiBean.allElections}" var="value">
    <a href="<s:url action="criarListasPage" />">${value}!</a> <br>
</c:forEach>

<p><a href="<s:url action="gerirListasPage" />">Back</a></p>
<p><a href="<s:url action="criarListaPage" />">Here</a></p>
</body>
</html>