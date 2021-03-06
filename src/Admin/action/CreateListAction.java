
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class CreateListAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String nomeLista=null;
    private String firstUser = null;
    private String election=null;
    @Override

    public String execute() throws RemoteException {
        if(this.nomeLista!=null && !nomeLista.equals("") && firstUser != null && !firstUser.equals("") && this.election!=null && !election.equals("")){
            this.getRmiBean().setNomeLista(this.nomeLista);
            this.getRmiBean().setFirstUser(this.firstUser);
            this.getRmiBean().setElection(this.election);
            if(this.getRmiBean().createList()){
                this.getRmiBean().setCheck(0);
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

    public void setElection(String election) {
        this.election = election;
    }

    public void setFirstUser(String firstUser) {
        this.firstUser = firstUser;
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
