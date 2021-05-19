
package Admin.action;

import Admin.model.RmiBean;
import Admin.ws.WebSocketAnnotation;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import Admin.model.RmiBean;

public class VoteElectionAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null;
    private String votos=null;
    @Override

    public String execute() throws RemoteException {
        if(this.election!=null && !election.equals("")){
            this.getRmiBean().setElection(this.election);
            return SUCCESS;
        }
        return ERROR;
    }

    public String votar() throws RemoteException {
        this.getRmiBean().setVoto(this.votos);
        if(this.getRmiBean().votar() && this.getRmiBean().userVoted()) {
            System.out.println("success");
            this.getRmiBean().setElection(null);
            return SUCCESS;
        }else{
            System.out.println("error");
            return ERROR;
        }
    }


    public void setElection(String election) {
        this.election = election;
    }

    public void setVotos(String votos) {
        this.votos = votos;
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
