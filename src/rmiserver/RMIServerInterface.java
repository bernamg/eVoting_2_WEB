/**
 * Raul Barbosa 2014-11-07
 */
package rmiserver;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RMIServerInterface extends Remote {
	public boolean checkNcreateAdmin(String username, String password) throws RemoteException;
}
