/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.Observable;

/**
 *
 * @author bibo_121
 */
public class Advertisement extends Observable {

    int adv_ID;
    int Owner_id;
    String description;
    String startDate;
    String endDate;
    int price;
    Apartment apartment;

    public Advertisement(int adv_ID, int Owner_id, String description, String startDate, String endDate, int price) {
        this.adv_ID = adv_ID;
        this.Owner_id = Owner_id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        notifyObservers(toString());
    }

    public int getAdv_ID() {
        return adv_ID;
    }

    public void setAdv_ID(int adv_ID) {
        this.adv_ID = adv_ID;
    }

    public int getOwner_id() {
        return Owner_id;
    }

    public void setOwner_id(int Owner_id) {
        this.Owner_id = Owner_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
