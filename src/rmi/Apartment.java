/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author bibo_121
 */
public class Apartment {

    int apartment_ID;
    int Owner_ID;
    String address;
    int noOfRooms;
    String status;

    public Apartment(int apartment_ID, int Owner_ID, String address, int noOfRooms, String status) {
        this.apartment_ID = apartment_ID;
        this.Owner_ID = Owner_ID;
        this.address = address;
        this.noOfRooms = noOfRooms;
        this.status = status;
    }

    public int getApartment_ID() {
        return apartment_ID;
    }

    public void setApartment_ID(int Apartment_ID) {
        this.apartment_ID = Apartment_ID;
    }

    public int getOwner_ID() {
        return Owner_ID;
    }

    public void setOwner_ID(int Owner_ID) {
        this.Owner_ID = Owner_ID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
