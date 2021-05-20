
package Admin.action;

import Admin.model.FacebookBean;
import Admin.model.RmiBean;
import Admin.ws.WebSocketAnnotation;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import uc.sd.apis.FacebookApi2;

import java.rmi.RemoteException;
import java.util.Map;

public class LoginUserAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null, password = null;

    private static final String NETWORK_NAME = "Facebook";
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    private static final Token EMPTY_TOKEN = null;

    @Override
    public String execute() throws RemoteException {
        if(this.username != null && !username.equals("") && this.password !=null && !password.equals("")) { ;
            this.getRmiBean().setUsername(this.username);
            this.getRmiBean().setPassword(this.password);
            this.getRmiBean().setUserLoggedIn(this.username);
            if(this.getRmiBean().userLogin()){
                session.put("username", username);
                session.put("loggedinUser", true); // this marks the user as logged in
                System.out.println("User logado");

                // Preparar Associar User
                String apiKey = "527739111582217";
                String apiSecret = "38d8da36691c0bd8123a2ec6882f1d22";


                OAuthService service = new ServiceBuilder()
                        .provider(FacebookApi2.class)
                        .apiKey(apiKey)
                        .apiSecret(apiSecret)
                        .callback("http://localhost:8080/WebApp/associarUserFB")
                        .scope("public_profile")
                        .build();

                System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
                System.out.println();


                // Obtain the Authorization URL
                System.out.println("Fetching the Authorization URL...");
                String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
                System.out.println("Got the Authorization URL!");
                System.out.println(authorizationUrl);

                this.getFacebookBean().setService(service);
                this.getFacebookBean().setAuthorizationUrl(authorizationUrl);

                return SUCCESS;
            }else{
                return LOGIN;
            }
        }
        else
            return LOGIN;
    }


    public void setUsername(String username) {
        this.username = username; // will you sanitize this input? maybe use a prepared statement?
    }

    public void setPassword(String password) {
        this.password = password; // what about this input?
    }

    public RmiBean getRmiBean() throws RemoteException {
        if(!session.containsKey("rmiBean"))
            this.setRmiBean(new RmiBean());
        return (RmiBean) session.get("rmiBean");
    }


    public void setRmiBean(RmiBean rmiBean) {
        this.session.put("rmiBean", rmiBean);
    }

    public FacebookBean getFacebookBean(){
        if(!session.containsKey("facebookBean"))
            this.setFacebookBean(new FacebookBean());
        return (FacebookBean) session.get("facebookBean");
    }



    public void setFacebookBean(FacebookBean facebookBean) {
        this.session.put("facebookBean", facebookBean);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }


}
