/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;
import rmi.Client;
import rmi.Admin;


/**
 *
 * @author Mohamed
 */
public class ReadOnly {
    
      private static ReadOnly system;  
  ArrayList<Client> customerList= new ArrayList<Client>();
  ArrayList<Admin> adminList= new ArrayList<Admin>();
  
 private ReadOnly()
 {
     this.system=system;
 }
 
public void addClient(Client Client)
{

}
public void deleteClient(Client Client)
{

}
public void modifyCustomer(Client Client)
{
    
}
public void addAdmin(Admin Admin)
{
    
}
public void modifyAdmin(Admin Admin)
{
    
}
public void deleteAdmin(Admin Admin)
{
    
}
public void addApartment()
{
    
}
public void updateApartment()
{
    
}
public void deleteApartment()
{
    
}
public void viewApartment()
{
    
}

     
 public static ReadOnly Readonly()
  {
      if(system==null)
      {
          system=new ReadOnly();
      }
      return system;
  }
}

    

