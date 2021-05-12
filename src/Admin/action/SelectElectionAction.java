
package Admin.action;

import Admin.model.RmiBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.rmi.RemoteException;
import java.util.*;

public class SelectElectionAction extends ActionSupport implements SessionAware{
    private static final long serialVersionUID = 4L;
    private Map<String, Object> session;
    private String election=null;
    private int votosBrancos=0;
    private int votosNulos=0;
    private ArrayList<String> nomeListaCandidatos = null;
    private ArrayList<Integer> votosListaCandidatos = null;
    private ArrayList<Float> percVotosListaCandidatos = null;

    @Override
    public String execute() throws RemoteException {

        if(this.election!=null && !election.equals("")) {
            this.getRmiBean().setTitulo(this.election);

            HashMap<String,String> detalhes = this.getRmiBean().getDetalhesEleicao(this.election);

            this.getRmiBean().setnVotosTotal(Integer.parseInt(detalhes.get("nVotosTotal")));
            this.getRmiBean().setVotosBrancos(Integer.parseInt(detalhes.get("votosBranco")));
            this.getRmiBean().setVotosNulos(Integer.parseInt(detalhes.get("votosNulo")));

            if(detalhes.containsKey("votosLista")){

                // numero de votos de cada candidato
                ArrayList<Integer> votosListaCandidatos = new ArrayList<>();
                String arr[] = detalhes.get("votosLista").split(",");
                for(String s : arr){
                    votosListaCandidatos.add(Integer.parseInt(s));
                }
                this.getRmiBean().setVotosListaCandidatos(votosListaCandidatos);

                //nomeListaCandidatos
                ArrayList<String> nomeListaCandidatos = new ArrayList<>();
                arr = detalhes.get("nomeLista").split(",");
                for(String s : arr){
                    nomeListaCandidatos.add(s);
                }
                this.getRmiBean().setNomeListaCandidatos(nomeListaCandidatos);
            }


            if(Integer.parseInt(detalhes.get("nVotosTotal")) > 0){ // por aqui tudo que seja com percetagens
                // votosListaPercentagem
                ArrayList<Float> votosListaPerc = new ArrayList<>();
                String arr[] = detalhes.get("votosListaPerc").split(",");
                for(String s : arr){
                    votosListaPerc.add(Float.parseFloat(s));
                }
                this.getRmiBean().setPercVotosListaCandidatos(votosListaPerc);

                //votosBrancoPerc
                this.getRmiBean().setVotosBrancosPerc(Float.parseFloat(detalhes.get("votosBrancoPerc")));

                //votosNulosPerc
                this.getRmiBean().setVotosNulosPerc(Float.parseFloat(detalhes.get("votosNulosPerc")));
            }

            return SUCCESS;
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
