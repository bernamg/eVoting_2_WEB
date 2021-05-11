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
<p>Lista a editar:</p>

<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro Na Apresentacao das Listas---------------------</p>
    </c:when>
</c:choose>

<s:form action="editListSecond" method="post">
    <p>
        <c:forEach items="${rmiBean.list}" var="value">
            <input type="radio" id="${value}" name="list" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>
    <p><button type="submit" id="insertElement" name="submitOption" value="insertElement" >Inserir Elemento</button></p>
   <p><button type="submit" id="deleteElement" name="submitOption" value="deleteElement" >Eliminar Elemento</button></p>
    <p> <button type="submit" id="deleteList" name="submitOption" value="deleteList" >Eliminar Lista</button></p>

</s:form>
<p><a href="<s:url action="editarListaEscolhaPage" />">Back</a></p>
</body>
</html>