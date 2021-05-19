
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;

public class EditElectionAction extends ActionSupport implements SessionAware, AdminAction{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null;
    private String titulo=null;
    private String desc=null;
    private String quemVota=null;
    private String dataInicio=null;
    private String dataFim = null;
    private String[] tmp=null, tmp1=null;

    @Override
    public String execute() throws IOException {
        System.out.println("EXECUTING EDIT_ELECTION_ACTION.JAVA");
        Date TdataInicio=null,TdataFim=null;
        if(this.dataInicio!=null && !dataInicio.equals("")) {
            tmp = dataInicio.split("[-T:]");
            TdataInicio = new GregorianCalendar(
                    Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) - 1, Integer.parseInt(tmp[2]),
                    Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])).getTime();
        }

        if(this.dataFim!=null && !dataFim.equals("")) {
            tmp = dataFim.split("[-T:]");
            TdataFim = new GregorianCalendar(
                    Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) - 1, Integer.parseInt(tmp[2]),
                    Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])).getTime();
        }

        if(this.election!=null && !election.equals("")){ // se eleicao tiver sido selecionada
            this.getRmiBean().setElection(this.election);
            if(titulo!=null && !titulo.equals(""))
                this.getRmiBean().setTitulo(this.titulo);
            else
                this.getRmiBean().setTitulo("");
            if(this.desc!=null && !desc.equals(""))
                this.getRmiBean().setDesc(this.desc);
            else
                this.getRmiBean().setDesc("");
            if(this.dataInicio!=null && !dataInicio.equals(""))
                this.getRmiBean().setDataInicio(TdataInicio);
            else
                this.getRmiBean().setDataInicio(null);
            if(this.dataFim!=null && !dataFim.equals(""))
                this.getRmiBean().setDataFim(TdataFim);
            else
                this.getRmiBean().setDataFim(null);
            if(this.getRmiBean().editElection()){
                System.out.println("Eleicao Editada");
                this.getRmiBean().setCheck(0);
                return SUCCESS;
            }else{
                System.out.println("Eleicao nao editada");
                this.getRmiBean().setCheck(1);
                return ERROR;
            }
        }
        else {
            System.out.println("Eleicao nao selecionada!");
            this.getRmiBean().setCheck(1);
            return ERROR;
        }
    }

    public void setElection(String election) {
        this.election = election;
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
