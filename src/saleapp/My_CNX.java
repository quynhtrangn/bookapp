/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saleapp;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author nQuynhtrang
 */
public class My_CNX {
    
    
    private static String servername="localhost";
    private static String username = "root";
    private static String dbname = "user_db";
    private static Integer portnumber = 3360;
    private static String password ="";
    
    public static Connection getConnection() {
        
        Connection cnx= null;
        MysqlDataSource mysql= new MysqlDataSource();
        mysql.setServerName(servername);
        mysql.setUser(username);
        mysql.setPassword(password);
        mysql.setDatabaseName(dbname);
        mysql.setPortNumber(portnumber);
        
        try {
            cnx = mysql.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger("get conection ->"+My_CNX.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }   
}
