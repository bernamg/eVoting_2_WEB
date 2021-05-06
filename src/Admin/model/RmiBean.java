package Admin.model;

import rmiserver.RMIServerInterface;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class RmiBean {
    private RMIServerInterface server;
    private String username; // username and password supplied by the user
    private String password;

    public RmiBean() {
        try {
            server = (RMIServerInterface) Naming.lookup("RMISV");
        }
        catch(NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace(); // what happens *after* we reach this line?
        }
    }

    public boolean checkAdmin() throws RemoteException {
        return server.checkNcreateAdmin(this.username,this.password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
