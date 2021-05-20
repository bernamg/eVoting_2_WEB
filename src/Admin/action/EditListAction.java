
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class EditListAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null,list=null, submitOption=null,user=null;
    private String firstUser = null;
    @Override

    public String execute() throws RemoteException {
        if (this.election != null && !election.equals("")) {
            this.getRmiBean().setElection(this.election);
        }
        return SUCCESS;
    }

    public String escolhaLista() throws RemoteException {
        if (this.list != null && !list.equals("")) {
            this.getRmiBean().setSubmitOption(this.submitOption);
            this.getRmiBean().setList(this.list);
            if(this.submitOption.equals("deleteList")){
                this.getRmiBean().deleteList();
                System.out.println("Lista Eliminada");
                return NONE;
            }
            this.getRmiBean().setCheck(0);
            return SUCCESS;
        }else{
            this.getRmiBean().setCheck(1);
            System.out.println("here");
            return ERROR;
        }

    }

    public String inserirElemento() throws RemoteException {
        if (this.user != null && !user.equals("")) {
            this.getRmiBean().setUser(this.user);
            if(this.getRmiBean().insertUserToList()){
                System.out.println("User adicionado a lista");
                this.getRmiBean().setCheck(0);
                return SUCCESS;
            }else{
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }else{
            this.getRmiBean().setCheck(1);
            return ERROR;
        }
    }

    public String eliminarElemento() throws RemoteException {
        if (this.user != null && !user.equals("")) {
            this.getRmiBean().setUser(this.user);
            if(this.getRmiBean().deleteUserFromList()){
                System.out.println("User eliminado da lista");
                return SUCCESS;
            }else{
                return ERROR;
            }
        }else{
            this.getRmiBean().setCheck(1);
            return ERROR;
        }
    }

    public void setUser(String user) {
        this.user = user;
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

    public void setSubmitOption(String submitOption) {
        this.submitOption = submitOption;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
