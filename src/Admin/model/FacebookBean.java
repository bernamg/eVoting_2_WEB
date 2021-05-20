package Admin.model;


import com.github.scribejava.core.oauth.OAuthService;
import rmiserver.RMIServerInterface;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class FacebookBean {
    OAuthService service = null;
    private String authorizationUrl = null;

    public FacebookBean() {

    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public void setAuthorizationUrl(String authorizationUrl) {
        this.authorizationUrl = authorizationUrl;
    }

    public OAuthService getService() {
        return service;
    }

    public void setService(OAuthService service) {
        this.service = service;
    }
}

