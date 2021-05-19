<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Votar em Lista</title>

    <script type="text/javascript">


        var websocket = null;

        window.onload = function() { // URI = ws://10.16.0.165:8080/WebSocket/ws
            connect('ws://' + window.location.host + '/metaWeb/ws');
        }

        function connect(host) { // connect to the host websocket
            if ('WebSocket' in window) {
                websocket = new WebSocket(host);
            }
            else if ('MozWebSocket' in window)
                websocket = new MozWebSocket(host);
            else {
                return;
            }

            websocket.onclose   = onClose;

        }

        function election(){
            websocket.send("left");
        }

        function doSend() {
            var message = document.getElementById('chat').value;
            if (message != '')
                websocket.send(message); // send the message to the server
            document.getElementById('chat').value = '';

        }
        function onClose(event) {
            writeToHistory('WebSocket closed (code ' + event.code + ').');
        }

    </script>
</head>
<body>

<c:choose>
    <c:when test="${rmiBean.check == 1}">
        <p>---------------------Erro ao Votar---------------------</p>
    </c:when>
</c:choose>


<s:form action="votarEleicaoFinal" method="post">
    <p>Escolha a Lista em que quer votar:</p>
        <c:forEach items="${rmiBean.list}" var="value">
            <input type="checkbox" id="${value}" name="votos" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    <p> <button type="submit" onclick="election()" >Submit</button></p>

</s:form>

<p><a href="<s:url action="votarEleicaoPage" />" id="back" onclick="election()">Back</a> </p>
</body>
</html>