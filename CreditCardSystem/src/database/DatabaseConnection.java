/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lowlevel
 */
public class DatabaseConnection {
    
    private static Connection instance = null;
    
    private DatabaseConnection(){}
    
    public static Connection getConnection(){
        if(instance==null){
            try {
            Class.forName("com.mysql.jdbc.Driver");
            instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/CASESTUDY?autoReconnect=true&useSSL=false", "root", "3323");
            
            } catch (ClassNotFoundException ex) {

            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return instance;
    }
    
    
}
