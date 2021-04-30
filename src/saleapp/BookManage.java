/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nQuynhtrang
 */
public class BookManage {
    private List <Book> bookb;
    public BookManage(){
        bookb = new ArrayList<Book>();
    }

    public List<Book> getBookb() {
        return bookb;
    }

    public void setBookb(List<Book> bookb) {
        this.bookb = bookb;
    }
    public void addbook(Book book){
        bookb.add(book);
    }
}
