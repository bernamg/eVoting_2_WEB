
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

public class ResultsElectionAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null;
    @Override

    public String execute() throws RemoteException {
        if(this.election!=null && !election.equals("")){
            this.getRmiBean().setElection(this.election);
            this.getRmiBean().setCheck(0);
            return SUCCESS;
        }
        this.getRmiBean().setCheck(1);
        return ERROR;
    }

    public void setElection(String election) {
        this.election = election;
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
