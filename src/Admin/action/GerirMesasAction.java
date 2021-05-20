
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.Map;

public class GerirMesasAction extends ActionSupport implements SessionAware {
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null;
    private String submitOption = null;
    private String mesa = null;
    @Override

    public String execute() throws RemoteException {
        if(this.election!=null && !election.equals("") && submitOption != null && !submitOption.equals("")) {
            this.getRmiBean().setSubmitOption(this.submitOption);
            this.getRmiBean().setElection(this.election);
            return SUCCESS;
        }
        return ERROR;
    }

    public String addTable() throws RemoteException {
        if(this.mesa!=null && !mesa.equals("")) {
            this.getRmiBean().setMesa(this.mesa);
            if(this.getRmiBean().addTable()){
                System.out.println("Mesa Adicionada");
                return SUCCESS;
            }
            else{
                System.out.println("Mesa nao adicionada");
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        this.getRmiBean().setCheck(1);
        return ERROR;

    }

    public String delTable() throws RemoteException {
        if(this.mesa!=null && !mesa.equals("")) {
            this.getRmiBean().setMesa(this.mesa);
            if(this.getRmiBean().delTable()){
                System.out.println("Mesa eliminada");
                this.getRmiBean().setCheck(0);
                return SUCCESS;
            }else{
                System.out.println("Mesa nao eliminada");
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        System.out.println("Mesa nao eliminada");
        this.getRmiBean().setCheck(1);
        return ERROR;
    }

    public void setElection(String election) {
        this.election = election;
    }

    public void setSubmitOption(String submitOption) {
        this.submitOption = submitOption;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
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
