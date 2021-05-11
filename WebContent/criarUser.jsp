<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 06/05/2021
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
</head>
<body>
    <c:choose>
        <c:when test="${rmiBean.check == 1}">
            <p>---------------------User nao registado---------------------</p>
        </c:when>
    </c:choose>
    <s:form action="createUser" method="post">
        <input type="radio" id="estudante" name="tipoUser" value="estudante">
        <label for="estudante">Estudante</label><br>
        <input type="radio" id="docente" name="tipoUser" value="docente">
        <label for="docente">Docente</label><br>
        <input type="radio" id="funcionario" name="tipoUser" value="funcionario">
        <label for="funcionario">Funcionario</label>
       <p>
        <s:text name="Nome:" />
        <s:textfield name="name" /><br>
        <s:text name="Username:" />
        <s:textfield name="username" /><br>
        <s:text name="Password:" />
        <s:textfield name="password" type="password" /><br>
        <s:text name="Departamento:" />
        <s:textfield name="dep" /><br>
        <s:text name="Numero Telefone:" />
        <s:textfield name="numPhone" type="number" /><br>
        <s:text name="Morada:" />
        <s:textfield name="morada" /><br>
        <s:text name="Numero Cartao de Cidadao:" />
        <s:textfield name="numCC" type="number" /><br>
        <s:text name="Validade Cartao de Cidadao:" />
        <s:textfield name="valCC" /><br>
        <s:submit /> <input type="reset">
       </p>
    </s:form>
    <p><a href="<s:url action="optionsAdminPage" />">Back</a></p>
    </body>
</html>
