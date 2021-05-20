/**
 * Raul Barbosa 2014-11-07
 */
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Map;
import Admin.model.RmiBean;

public class RegisterAction extends ActionSupport implements SessionAware, AdminAction{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null, password = null;

    @Override
    public String execute() throws IOException {
        System.out.println(username);
        this.getRmiBean().setUsername(username);
        this.getRmiBean().setPassword(password);
        if (this.username != null && !username.equals("") && this.password != null && !password.equals("")) {
            if (!(this.getRmiBean().checkAdmin())) {
                System.out.println("Utilizador ja registado");
                return ERROR;
            }
            System.out.println("Admin Registado");
            return SUCCESS;
        }
        System.out.println("Utilizador ja registado");
        return ERROR;
    }

    public void setUsername(String username) {
        this.username = username; // will you sanitize this input? maybe use a prepared statement?
    }

    public void setPassword(String password) {
        this.password = password; // what about this input?
    }

    public RmiBean getRmiBean() throws RemoteException {
        if(!session.containsKey("rmiBean"))
            this.setRmiBean(new RmiBean());;
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
