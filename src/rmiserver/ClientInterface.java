package rmiserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    public void print_on_admin(String titulo_eleicao, String dep, int nVotos) throws RemoteException;
    public void printState(String msg) throws  RemoteException;

}
