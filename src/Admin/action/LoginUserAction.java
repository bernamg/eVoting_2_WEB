
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Map;
import Admin.model.RmiBean;

public class LoginUserAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null, password = null;

    @Override
    public String execute() throws RemoteException {
        if(this.username != null && !username.equals("") && this.password !=null && !password.equals("")) {
            this.getRmiBean().setUsername(this.username);
            this.getRmiBean().setPassword(this.password);
            if(this.getRmiBean().userLogin()){
                System.out.println("User Logged");
                return SUCCESS;
            }else{
                System.out.println("Password Incorreta");
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

    public RmiBean getRmiBean() {
        if(!session.containsKey("rmiBean"))
            this.setRmiBean(new RmiBean());
        return (RmiBean) session.get("rmiBean");
    }

    public void setRmiBean(RmiBean rmiBean) {
        this.session.put("rmiBean", rmiBean);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
