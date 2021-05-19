package Admin.ws;

import Admin.configurator.GetHttpSessionConfigurator;
import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/ws",  configurator = GetHttpSessionConfigurator.class)
public class WebSocketAnnotation {
    private Session session;
    private String username;
    private static final Set<WebSocketAnnotation> users = new CopyOnWriteArraySet<>();
    private HttpSession httpSession;
    private RmiBean bean;
    public WebSocketAnnotation() {

    }

    @OnOpen
    public void start(Session session,EndpointConfig config){
        this.session = session;
        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        bean = (RmiBean) this.httpSession.getAttribute("rmiBean");
        users.add(this);
        this.username=bean.getUserLoggedIn();
        if(bean.getElection()!=null && bean.getUserLoggedIn()!=null){
            sendMessage(bean.getUserLoggedIn() + " is in " + bean.getElection());
        }
        else if(bean.getUserLoggedIn()!=null) {
            String message = bean.getUserLoggedIn() + " Logged In";
            sendMessage(message);
        }
    }

    @OnClose
    public void end() {
    	// clean up once the WebSocket connection is closed
        System.out.println("Remove user");
        users.remove(this);
    }

    @OnMessage
    public void receiveMessage(String message) {
		// one should never trust the client, and sensitive HTML
        // characters should be replaced with &lt; &gt; &quot; &amp;
        if(message.equals("left")){
            sendMessage(username+ " left "+bean.getElection());
        }
        else if(message.equals("Logged Out")) {
            sendMessage(username+" "+ message);
        }

    }


    @OnError
    public void handleError(Throwable t) {
    	t.printStackTrace();
    }


    private void sendMessage(String text) {
    	// uses *this* object's session to call sendText()
    	try {
			//this.session.getBasicRemote().sendText(text);
            for (WebSocketAnnotation w : users){
                w.session.getBasicRemote().sendText(text);
            }
		} catch (IOException e) {
			// clean up once the WebSocket connection is closed
			try {
				this.session.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }


}
