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
public class UserApplication {

    int User_ID;
    int Application_ID;
    int Age;
    String Email;
    String City;
    boolean userType;

    public UserApplication(int User_ID, int Application_ID, int Age, String Email, String City, boolean userType) {
        this.User_ID = User_ID;
        this.Application_ID = Application_ID;
        this.Age = Age;
        this.Email = Email;
        this.City = City;
        this.userType = userType;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public int getApplication_ID() {
        return Application_ID;
    }

    public void setApplication_ID(int Application_ID) {
        this.Application_ID = Application_ID;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public boolean getUserType() {
        return userType;
    }

    public void setUserType(boolean userType) {
        this.userType = userType;
    }

}
