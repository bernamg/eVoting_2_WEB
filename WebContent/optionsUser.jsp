<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: berna
  Date: 06/05/2021
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
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
    <p><a href="${facebookBean.authorizationUrl}">Registo com o FB</a></p>
    <p><a href="<s:url action="votarEleicao" />">Votar</a></p>
    <p><a href="<s:url action="index" />" id="logout" value="Logout" onclick="logout()">Logout</a> </p>
</body>
</html>
