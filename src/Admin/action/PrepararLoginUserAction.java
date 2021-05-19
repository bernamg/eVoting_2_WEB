
package Admin.action;

import Admin.model.FacebookBean;
import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;
import java.util.Scanner;
import com.github.scribejava.apis.FacebookApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Token;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.model.Verifier;
import com.github.scribejava.core.oauth.OAuthService;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xml.sax.InputSource;
import uc.sd.apis.FacebookApi2;

public class PrepararLoginUserAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;

    private static final String NETWORK_NAME = "Facebook";
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    private static final Token EMPTY_TOKEN = null;

    @Override
    public String execute() throws RemoteException {

        String apiKey = "527739111582217";
        String apiSecret = "38d8da36691c0bd8123a2ec6882f1d22";


        OAuthService service = new ServiceBuilder()
                .provider(FacebookApi2.class)
                .apiKey(apiKey)
                .apiSecret(apiSecret)
                .callback("http://localhost:8080/WebApp/loginUserFB")
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
