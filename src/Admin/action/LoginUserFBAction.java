
package Admin.action;

import Admin.model.FacebookBean;
import Admin.model.RmiBean;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuthService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import uc.sd.apis.FacebookApi2;

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
        System.out.println("LOGGING IN");

        Verifier verifier = new Verifier(code);

        OAuthService service = this.getFacebookBean().getServiceLogin();

        //System.out.println("Trading the Request Token for an Access Token...");
        Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
        //System.out.println("Got the Access Token!");
        //System.out.println("(if your curious it looks like this: " + accessToken + " )");
        //System.out.println();

        // Now let's go and ask for a protected resource!
                OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        service.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println(response.getBody());

        String username = this.getRmiBean().getUsernameFromFbCode( getFormattedCode(response.getBody()) );
        if(username != null){
            System.out.println("SUCCESS CARALHOOOO");
            //dizer na session que o gajo esta logado

            this.getRmiBean().setUsername(username);
            //this.getRmiBean().setPassword(this.password);
            this.getRmiBean().setUserLoggedIn(username);
            session.put("username", username);
            session.put("loggedinUser", true); // this marks the user as logged in
            System.out.println("User logado");
            return SUCCESS;
        }
        System.out.println("FALHOU LOGIN");
        return LOGIN;
    }

    private String getFormattedCode(String str){
        String[] arrOfStr = str.split(",");
        String[] arrOfStr2 = arrOfStr[1].split(":");
        System.out.println( arrOfStr2[1].substring( 1,arrOfStr2[1].length()-2 ) );
        return arrOfStr2[1].substring( 1,arrOfStr2[1].length()-2 );
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
