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

<p>Detalhes de Eleitor:</p>

    <p>
        <c:forEach items="${rmiBean.infoUser}" var="value">
            <c:out value="${value}" /><br>
        </c:forEach>
    </p>
<p><a href="<s:url action="ondeVotouPage" />">Back</a></p>
</body>
</html>
