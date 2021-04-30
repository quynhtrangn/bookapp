/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapp;

/**
 *
 * @author nQuynhtrang
 */
public class UserModel {
    private int ID;
    private String Username;
    private String Password;
    private String Email;

    public UserModel(int ID, String Username, String Password, String Email) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public UserModel() {
    }

    public UserModel(int ID, String Username, String Password) {
        this.ID = ID;
        this.Username = Username;
        this.Password = Password;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    
}
