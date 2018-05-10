/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CreditCard;
import model.Customer;
import model.Payment;
import model.Transaction;

/**
 *
 * @author lowlevel
 */
public class Queries {
    
    Connection conn = DatabaseConnection.getConnection();
    
    public ObservableList<Customer> queryCustomers(){
        ObservableList<Customer> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM Customer";
                System.out.println("sa" + conn);
                PreparedStatement statement = conn.prepareStatement(sql);
        
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                System.out.println("PRIMARY KEY: " + rs.getInt("id"));
                System.out.println(rs.getString("first_name"));
                data.add(new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("middle_name"), rs.getString("last_name"), rs.getString("email"), 
                rs.getString("ssn"), rs.getInt("phone"), 
                        rs.getString("street_name"), rs.getString("apt_no"), rs.getString("city"), "USA", "New York", rs.getString("zip"), rs.getInt("number_of_cc")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<CreditCard> queryCreditCardByCustomerId(int customerId){
        ObservableList<CreditCard> data = FXCollections.observableArrayList();
        try {
            // CHANGE THE SQL QUERY, USE JOINS
            String sql = "SELECT Branch.branch_name, CreditCard.* FROM Branch, CreditCard WHERE Branch.id = CreditCard.branch_code AND CreditCard.customer=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customerId);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                
                data.add(new CreditCard(rs.getInt("id"), rs.getString("credit_card_no"), rs.getString("branch_name"), rs.getInt("day"), rs.getInt("month"), rs.getInt("year")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Transaction> queryTransactionByCreditCardId(int creditCardId){
        ObservableList<Transaction> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM Transactions WHERE credit_card_no=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, creditCardId);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(new Transaction(rs.getInt("id"), rs.getInt("credit_card_no")+"", rs.getString("transaction_type"), "$ " + rs.getInt("transaction_value")+".00", rs.getString("transaction_date")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Transaction> queryTransactions(){
        ObservableList<Transaction> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM Transactions";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(new Transaction(rs.getInt("id"), rs.getInt("credit_card_no")+"", rs.getString("transaction_type"), "$ " + rs.getDouble("transaction_value")+".00", rs.getString("transaction_date")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<String> queryTypes(){
        ObservableList<String> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT distinct transaction_type FROM Transactions";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(rs.getString("transaction_type"));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<String> queryStates(){
        ObservableList<String> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM State";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(rs.getString("name"));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Payment> queryPayments(ArrayList<Payment> payment){
        ObservableList<Payment> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM Payments WHERE credit_card=? AND month=? AND year=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setInt(1, payment.get(0).getCredit_card());
            statement.setInt(2, payment.get(0).getMonth());
            statement.setInt(3, payment.get(0).getYear());
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(new Payment(rs.getInt("id"), rs.getInt("month"), rs.getInt("year"), rs.getDouble("balance"), rs.getDouble("payments"), rs.getInt("credit_card")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ObservableList<Transaction> queryTransactionsWithCustomerAndCreditCard(){  
        ObservableList<Transaction> data = FXCollections.observableArrayList();
        try {
            String sql = "SELECT c.first_name, s.name, c.last_name, c.zip, cc.credit_card_no as credit_card, t.* \n" +
                        "FROM CreditCard cc JOIN Transactions t ON (cc.id=t.credit_card_no)\n" +
                        "JOIN Customer c ON (c.id=cc.customer)\n" +
                        "JOIN State s ON (s.id=c.state)\n" +
                        "ORDER BY DAY(t.transaction_date);";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                data.add(new Transaction(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("name"), rs.getString("zip"), rs.getString("credit_card"), rs.getString("transaction_type"), "$ "+rs.getInt("transaction_value")+".00", rs.getString("transaction_date")));
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public boolean updateCustomerFirstName(int id, String new_first_name){
        try {
            String sql = "UPDATE Customer SET first_name=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_first_name);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerMiddleName(int id, String new_middle_name){
        try {
            String sql = "UPDATE Customer SET middle_name=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_middle_name);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerLastName(int id, String new_last_name){
        try {
            String sql = "UPDATE Customer SET last_name=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_last_name);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerEmail(int id, String new_email){
        try {
            String sql = "UPDATE Customer SET email=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_email);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerPhone(int id, int new_phone){
        try {
            String sql = "UPDATE Customer SET phone=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, new_phone);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerZip(int id, String new_zip){
        try {
            String sql = "UPDATE Customer SET zip=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_zip);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerAptNo(int id, String new_apt_no){
        try {
            String sql = "UPDATE Customer SET apt_no=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_apt_no);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerStreetName(int id, String new_street_name){
        try {
            String sql = "UPDATE Customer SET street_name=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_street_name);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerCity(int id, String new_city){
        try {
            String sql = "UPDATE Customer SET city=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_city);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean updateCustomerCountry(int id, String new_country){
        try {
            String sql = "UPDATE Customer SET country=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, new_country);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean updateCustomerState(int id, int new_state){
        try {
            String sql = "UPDATE Customer SET state=? WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, new_state);
            statement.setInt(2, id);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
