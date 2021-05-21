
package Admin.action;

import Admin.model.FacebookBean;
import Admin.model.RmiBean;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import uc.sd.apis.FacebookApi2;

import java.rmi.RemoteException;
import java.util.Map;

public class PrepararLoginUserAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;

    private static final String NETWORK_NAME = "Facebook";
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    private static final Token EMPTY_TOKEN = null;

    @Override
    public String execute() throws RemoteException {
        if(this.getRmiBean().getUserLoggedIn() != null) {
            System.out.println("LOGGED INNNNNNNNNNNNNNNNN");
            return LOGIN; // aqui ele vai saltar o login visto que ja esta logged in
        }

        // Preparar Associar User
        String apiKey = "527739111582217";
        String apiSecret = "38d8da36691c0bd8123a2ec6882f1d22";

        // ASSOCIAR
        OAuthService service = new ServiceBuilder()
                .provider(FacebookApi2.class)
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .callback("https://localhost:8443/Meta2/associarUserFB")
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


        // LOGIN
        service = new ServiceBuilder()
                .provider(FacebookApi2.class)
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .callback("https://localhost:8443/Meta2/loginUserFB")
                .scope("public_profile")
                .build();

        System.out.println("=== " + NETWORK_NAME + "'s OAuth Workflow ===");
        System.out.println();


        // Obtain the Authorization URL
        System.out.println("Fetching the Authorization URL...");
        authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
        System.out.println("Got the Authorization URL!");
        System.out.println(authorizationUrl);

        this.getFacebookBean().setServiceLogin(service);
        this.getFacebookBean().setAuthorizationUrlLogin(authorizationUrl);

        return SUCCESS;

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
