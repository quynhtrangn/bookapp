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
public class Book {
    private String namebook;
    private int Money;
    private int Quantity;

    public Book(String namebook, int Money) {
        this.namebook = namebook;
        this.Money = Money;
    }
    
    
    public Book() {
    }

    public Book(String namebook, int Money, int Quantity) {
        this.namebook = namebook;
        this.Money = Money;
        this.Quantity = Quantity;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int Money) {
        this.Money = Money;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    
    
}
