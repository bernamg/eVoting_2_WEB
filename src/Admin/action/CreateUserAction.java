
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateUserAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String username = null, password = null,name=null,dep=null,numPhone=null,morada=null, numCC=null, valCC=null, tipoUser=null;
    @Override
    public String execute() throws RemoteException {
        if(this.name!=null && !name.equals("") && username != null && !username.equals("") && password !=null && !password.equals("") && this.dep!=null && !dep.equals("") && this.morada!=null && !morada.equals("") && this.numCC!=null && !numCC.equals("") && this.valCC!=null && !valCC.equals("")) {
            this.getRmiBean().setUsername(this.username);
            this.getRmiBean().setName(this.name);
            this.getRmiBean().setPassword(this.password);
            this.getRmiBean().setDep(this.dep);
            this.getRmiBean().setMorada(this.morada);
            this.getRmiBean().setNumCC(this.numCC);
            this.getRmiBean().setNumPhone(this.numPhone);
            this.getRmiBean().setTipoUser(this.tipoUser);
            this.getRmiBean().setValCC(this.valCC);
            if(this.getRmiBean().createUser()){
                System.out.println("Username: "+this.username);
                System.out.println("Password: "+this.password);
                System.out.println("User Registado");
                this.getRmiBean().setCheck(0);
                return SUCCESS;
            }else{
                System.out.println("User nao registado");
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        else
            this.getRmiBean().setCheck(1);
            return ERROR;
    }


    public void setUsername(String username) {
        this.username = username; // will you sanitize this input? maybe use a prepared statement?
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }


    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNumCC(String numCC) {
        this.numCC = numCC;
    }

    public void setValCC(String valCC) {
        this.valCC = valCC;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
