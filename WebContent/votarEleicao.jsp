<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Editar Lista</title>
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

        function logout(){

            websocket.send("Logged Out");
        }

        function proxima(){

            websocket.send("Logged Out para eleicao");
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

<p>Eleicoes Disponiveis:</p>

<s:form action="votarEleicao" method="post">
    <p>
        <c:forEach items="${rmiBean.possibleElections}" var="value">
            <input type="radio" id="${value}" name="election" value="${value}">
            <label for="${value}">${value}</label><br>
        </c:forEach>
    </p>
    <p> <button type="submit">Submit</button></p>
</s:form>
<p><a href="<s:url action="index" />" id="logout" value="Logout" onclick="logout()">Logout</a> </p>


</body>
</html>