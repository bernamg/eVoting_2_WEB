package Admin.model;


import rmiserver.RMIServerInterface;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public class RmiBean {
    private RMIServerInterface server;
    private String username; // username and password supplied by the user
    private String password,name=null,dep=null,numPhone=null,morada=null, numCC=null, valCC=null, tipoUser=null, titulo=null, desc=null, quemVota=null;
    private String nomeLista=null, firstUser = null, election = null, list=null,submitOption=null, user=null, mesa=null;;
    private Date dataInicio=null, dataFim=null;
    private int check=0;
    private ArrayList<String> users=null;
    public RmiBean() {
        try {
            server = (RMIServerInterface) Naming.lookup("RMISV");
        }
        catch(NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace(); // what happens *after* we reach this line?
        }
    }

    public boolean checkAdmin() throws IOException {
        return server.checkNcreateAdmin(this.username,this.password);
    }

    public boolean adminLogin() throws RemoteException {
        return server.loginAdmin(this.username, this.password);
    }

    public boolean userLogin() throws RemoteException {
        return server.loginUser(this.username, this.password);
    }

    public boolean createUser() throws RemoteException{
        check=0;
        return server.createUserWeb(this.tipoUser,this.username,this.password,this.dep,this.numPhone,this.morada,this.numCC,this.valCC);
    }

    public boolean createElection() throws RemoteException{
        check =0;
        String[] tmp = quemVota.split(", ");
        ArrayList<String> quemVota1 = new ArrayList<>();
        for(String s : tmp){
            if (s.equals("estudante")){
                quemVota1.add("1");
            }
            if (s.equals("docente")){
                quemVota1.add("2");
            }
            if (s.equals("funcionario")){
                quemVota1.add("3");
            }
        }
        return server.createElectionWeb(dataInicio,dataFim,titulo,desc,quemVota1);
    }

    public boolean editElection() throws IOException {
        check =0;
        ArrayList<String> quemVota1;
        if(quemVota!=null) {
            String[] tmp = quemVota.split(", ");
            quemVota1 = new ArrayList<>();
            for (String s : tmp) {
                if (s.equals("estudante")) {
                    quemVota1.add("1");
                }
                if (s.equals("docente")) {
                    quemVota1.add("2");
                }
                if (s.equals("funcionario")) {
                    quemVota1.add("3");
                }
            }
        } else {
            quemVota1 = null;
        }
        return server.editElectionWeb(this.election,dataInicio,dataFim,titulo,desc,quemVota1);
    }

    public boolean createList() throws RemoteException{
        return server.createListWeb(this.nomeLista,this.firstUser,this.election);
    }
    public boolean insertUserToList() throws RemoteException{
        return server.addUserToList(this.election,this.nomeLista,this.user);
    }

    public boolean addTable() throws RemoteException{
        return server.addTable(this.election,this.mesa);
    }

    public boolean delTable() throws RemoteException{
        return server.delTable(this.election,this.mesa);
    }

    public boolean deleteUserFromList() throws RemoteException{
        return server.deleteUserFromList(this.election,this.nomeLista,this.user);
    }

    public boolean deleteList() throws  RemoteException{
        System.out.println("called deleteList");
        return server.deleteList(this.election,this.list);
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setQuemVota(String quemVota) {
        this.quemVota = quemVota;
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

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setValCC(String valCC) {
        this.valCC = valCC;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setSubmitOption(String submitOption) {
        this.submitOption = submitOption;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public ArrayList<String> getAllUsers() throws RemoteException {
        return server.getAllUsers();
    }

    public ArrayList<String> getOpenElections() throws RemoteException {
        return server.getOpenElections();
    }

    public int getCheck() {
        return this.check;
    }

    public ArrayList<String> getList() throws RemoteException {
        return  server.getLists(this.election);
    }

    public ArrayList<String> getUsersFromList() throws RemoteException {
        System.out.println("Called getUserFromList");
        return server.getUsersFromList(this.election,this.nomeLista);
    }

    public String getSubmitOption() {
        return submitOption;
    }

    public ArrayList<String> getTablesFromList() throws RemoteException {
        return server.getTablesFromList(this.election);
    }
}
