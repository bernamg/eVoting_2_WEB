
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

public class CreateElectionAction extends ActionSupport implements SessionAware, AdminAction{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String titulo=null;
    private String desc=null;
    private String quemVota=null;
    private String dataInicio=null;
    private String dataFim = null;
    private String[] tmp=null, tmp1=null;
    @Override
    public String execute() throws RemoteException {
        tmp = dataInicio.split("[-T:]");
        Date TdataInicio = new GregorianCalendar(
                Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])-1, Integer.parseInt(tmp[2]),
                Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])).getTime();

        tmp = dataFim.split("[-T:]");
        Date TdataFim = new GregorianCalendar(
                Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])-1, Integer.parseInt(tmp[2]),
                Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])).getTime();


        if(this.titulo!=null && !titulo.equals("") && desc != null && !desc.equals("") && quemVota !=null && !quemVota.equals("") && this.dataInicio!=null && !dataInicio.equals("") && this.dataFim!=null && !dataFim.equals("")) {
            this.getRmiBean().setTitulo(this.titulo);
            this.getRmiBean().setDesc(this.desc);
            this.getRmiBean().setDataInicio(TdataInicio);
            this.getRmiBean().setDataFim(TdataFim);
            this.getRmiBean().setQuemVota(this.quemVota);
            if(this.getRmiBean().createElection()){
                this.getRmiBean().setCheck(0);
                return SUCCESS;
            }else{
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        else
            this.getRmiBean().setCheck(1);
            return ERROR;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQuemVota(String quemVota) {
        this.quemVota = quemVota;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
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
