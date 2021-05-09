
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import Admin.model.RmiBean;

public class CreateListAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String nomeLista=null;
    private String firstUser = null;
    @Override

    public String execute() throws RemoteException {
        if(this.nomeLista!=null && !nomeLista.equals("") && firstUser != null && !firstUser.equals("")){
            this.getRmiBean().setNomeLista(this.nomeLista);
            this.getRmiBean().setFirstUser(this.firstUser);
            if(this.getRmiBean().createList()){
                this.getRmiBean().setCheck(1);
                return SUCCESS;
            }else{
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        this.getRmiBean().setCheck(1);
        return ERROR;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public void setFirstUser(String firstUser) {
        this.firstUser = firstUser;
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
