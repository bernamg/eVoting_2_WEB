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
	public boolean checkNcreateAdmin(String username, String password) throws RemoteException;
	public boolean loginAdmin(String username, String password) throws RemoteException;
	public boolean createUserWeb(String tipoUser, String username, String password, String dep, String numPhone, String morada, String numCC, String valCC) throws RemoteException;
	public boolean createElectionWeb(Date dataInicio, Date dataFim, String titulo, String desc, ArrayList<String> quemVota) throws RemoteException;
}
