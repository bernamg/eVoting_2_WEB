/**
 * Raul Barbosa 2014-11-07
 */
package rmiserver;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface RMIServerInterface extends Remote {
	public boolean checkNcreateAdmin(String username, String password) throws RemoteException, IOException;
	public boolean loginAdmin(String username, String password) throws RemoteException;
	public boolean createUserWeb(String tipoUser, String username, String password, String dep, String numPhone, String morada, String numCC, String valCC) throws RemoteException;
	public boolean createElectionWeb(Date dataInicio, Date dataFim, String titulo, String desc, ArrayList<String> quemVota) throws RemoteException;
	public ArrayList<String> getAllUsers() throws RemoteException;
	public boolean createListWeb(String nome, String user, String eleicao) throws RemoteException;
	public boolean editElectionWeb(String eleicao, Date dataInicio, Date dataFim, String titulo, String desc, ArrayList<String> quemVota) throws IOException;
	public ArrayList<String> getOpenElections() throws RemoteException;
	public boolean loginUser(String nome, String password) throws RemoteException;
	public ArrayList<String> getLists(String eleicao) throws RemoteException;
	public boolean addUserToList(String eleicao, String lista, String user) throws RemoteException;
	public ArrayList<String> getUsersFromList(String eleicao, String lista) throws RemoteException;
	public boolean deleteUserFromList(String eleicao, String lista, String user) throws RemoteException;
}
