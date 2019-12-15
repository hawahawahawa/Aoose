/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author bibo_121
 */
public interface AuthenticationInterface extends Remote {

    public Account login(String username, String password) throws RemoteException;

    public boolean registerClient(int Client_ID, int Payment_ID, int User_ID, String First_Name, String Last_Name, String Address, String Phone_Number, String Email, String Country, String Username, String Password) throws RemoteException;

    public boolean registerOwner(int Owner_ID, String gender, int User_ID, String First_Name, String Last_Name, String Address, String Phone_Number, String Email, String Country, String Username, String Password) throws RemoteException;

}
