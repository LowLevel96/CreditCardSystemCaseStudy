/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lowlevel
 */
public class Payment {
    
    private IntegerProperty id;
    private IntegerProperty month;
    private IntegerProperty year;
    private DoubleProperty balance;
    private DoubleProperty payments;
    private IntegerProperty credit_card;
    
    public Payment(int month, int year, int credit_card) {
        this.month = new SimpleIntegerProperty(month);
        this.year = new SimpleIntegerProperty(year);
        this.credit_card = new SimpleIntegerProperty(credit_card);
    }

    public Payment(int id, int month, int year, double balance, double payments, int credit_card) {
        this.id = new SimpleIntegerProperty(id);
        this.month = new SimpleIntegerProperty(month);
        this.year = new SimpleIntegerProperty(year);
        this.balance = new SimpleDoubleProperty(balance);
        this.payments = new SimpleDoubleProperty(payments);
        this.credit_card = new SimpleIntegerProperty(credit_card);
    }

    public int getId() {
        return id.get();
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public int getMonth() {
        return month.get();
    }

    public void setMonth(IntegerProperty month) {
        this.month = month;
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(IntegerProperty year) {
        this.year = year;
    }

    public double getBalance() {
        return balance.get();
    }

    public void setBalance(DoubleProperty balance) {
        this.balance = balance;
    }

    public double getPayments() {
        return payments.get();
    }

    public void setPayments(DoubleProperty payments) {
        this.payments = payments;
    }

    public int getCredit_card() {
        return credit_card.get();
    }

    public void setCredit_card(IntegerProperty credit_card) {
        this.credit_card = credit_card;
    } 
}
