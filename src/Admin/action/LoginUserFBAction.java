
package Admin.action;

import Admin.model.FacebookBean;
import Admin.model.RmiBean;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class LoginUserFBAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;

    private static final String NETWORK_NAME = "Facebook";
    private static final String PROTECTED_RESOURCE_URL = "https://graph.facebook.com/me";
    private static final Token EMPTY_TOKEN = null;
    private String code;

    @Override
    public String execute() throws RemoteException {

        Verifier verifier = new Verifier(code);

        OAuthService service = this.getFacebookBean().getService();

        //System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        //System.out.println("Got the Access Token!");
        //System.out.println("(if your curious it looks like this: " + accessToken + " )");
        //System.out.println();


        //Token accessToken = new Token("EAAHfZBdZAHqgkBAOrfLylxsExxfvMhNxn2ZC9En0e8sNTZCHoC1BZAO7ZBku8yU0tLOq11tb7s0SZBUBnrJvxn5V7eZCTxcjkZAXaz7h3b7PI4BjpAgj60AkHNUVcuXK4QZC8YwjCybwiBpxYFft089mB01zzRCOERvwW4xLIw8BdGsAZDZD",
        //        apiSecret);

        // Now let's go and ask for a protected resource!
        System.out.println("Now we're going to access a protected resource...");
        OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println("Got it! Lets see what we found...");
        System.out.println();
        System.out.println(response.getCode());
        System.out.println(response.getBody());

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
