/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lowlevel
 */
public class Transaction {
    
    private IntegerProperty transactionId;
    private StringProperty customerFirstName;
    private StringProperty customerLastName;
    private StringProperty customerZip;
    private StringProperty transactionCreditCard;
    private StringProperty transactionType;
    private StringProperty transactionValue;
    private StringProperty transactionDate;
    private StringProperty transactionState;

    public Transaction(){}
    
    public Transaction(int transactionId, String transactionCreditCard, String transactionType, String transactionValue, String transactionDate) {
        this.transactionId = new SimpleIntegerProperty(transactionId);
        this.transactionCreditCard = new SimpleStringProperty(transactionCreditCard);
        this.transactionType = new SimpleStringProperty(transactionType);
        this.transactionValue = new SimpleStringProperty(transactionValue);
        this.transactionDate = new SimpleStringProperty(transactionDate);
    }

    public Transaction(int transactionId, String customerFirstName, String customerLastName, String customerZip, String transactionCreditCard, String transactionType, String transactionValue, String transactionDate) {
        this.transactionId = new SimpleIntegerProperty(transactionId);
        this.customerFirstName = new SimpleStringProperty(customerFirstName);
        this.customerLastName = new SimpleStringProperty(customerLastName);
        this.customerZip = new SimpleStringProperty(customerZip);
        this.transactionCreditCard = new SimpleStringProperty(transactionCreditCard);
        this.transactionType = new SimpleStringProperty(transactionType);
        this.transactionValue = new SimpleStringProperty(transactionValue);
        this.transactionDate = new SimpleStringProperty(transactionDate);
    }
    
    public Transaction(int transactionId, String customerFirstName, String customerLastName, String transactionState, String customerZip, String transactionCreditCard, String transactionType, String transactionValue, String transactionDate) {
        this.transactionId = new SimpleIntegerProperty(transactionId);
        this.customerFirstName = new SimpleStringProperty(customerFirstName);
        this.customerLastName = new SimpleStringProperty(customerLastName);
        this.customerZip = new SimpleStringProperty(customerZip);
        this.transactionCreditCard = new SimpleStringProperty(transactionCreditCard);
        this.transactionType = new SimpleStringProperty(transactionType);
        this.transactionValue = new SimpleStringProperty(transactionValue);
        this.transactionDate = new SimpleStringProperty(transactionDate);
        this.transactionState = new SimpleStringProperty(transactionState);
    }

    public String getTransactionState() {
        return transactionState.get();
    }

    public void setTransactionState(StringProperty transactionState) {
        this.transactionState = transactionState;
    }

    public String getCustomerFirstName() {
        return customerFirstName.get();
    }

    public void setCustomerFirstName(StringProperty customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName.get();
    }

    public void setCustomerLastName(StringProperty customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerZip() {
        return customerZip.get();
    }

    public void setCustomerZip(StringProperty customerZip) {
        this.customerZip = customerZip;
    }

    public int getTransactionId() {
        return transactionId.get();
    }

    public void setTransactionId(IntegerProperty transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionCreditCard() {
        return transactionCreditCard.get();
    }

    public void setTransactionCreditCard(StringProperty transactionCreditCard) {
        this.transactionCreditCard = transactionCreditCard;
    }

    public String getTransactionType() {
        return transactionType.get();
    }

    public void setTransactionType(StringProperty transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionValue() {
        return transactionValue.get();
    }

    public void setTransactionValue(StringProperty transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getTransactionDate() {
        return transactionDate.get();
    }

    public void setTransactionDate(StringProperty transactionDate) {
        this.transactionDate = transactionDate;
    }
    
    
    
}
