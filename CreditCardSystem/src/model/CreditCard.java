/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lowlevel
 */
public class CreditCard {
    
    //private BooleanProperty selected;
    private IntegerProperty creditCardId;
    private StringProperty creditCardNumber;
    private StringProperty creditCardBranchName;
    private IntegerProperty creditCardDay;
    private IntegerProperty creditCardMonth;
    private IntegerProperty creditCardYear;

    public CreditCard(){}

    public CreditCard(int creditCardId, String creditCardNumber, String creditCardBranchName, int creditCardDay, int creditCardMonth, int creditCardYear) {
        this.creditCardId = new SimpleIntegerProperty(creditCardId);
        this.creditCardNumber = new SimpleStringProperty(creditCardNumber);
        this.creditCardBranchName = new SimpleStringProperty(creditCardBranchName);
        this.creditCardDay = new SimpleIntegerProperty(creditCardDay);
        this.creditCardMonth = new SimpleIntegerProperty(creditCardMonth);
        this.creditCardYear = new SimpleIntegerProperty(creditCardYear);
    }

    public int getCreditCardId() {
        return creditCardId.get();
    }

    public void setCreditCardId(IntegerProperty creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreditCardNumber() {
        return creditCardNumber.get();
    }

    public void setCreditCardNumber(StringProperty creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardBranchName() {
        return creditCardBranchName.get();
    }

    public void setCreditCardBranchName(StringProperty creditCardBranchName) {
        this.creditCardBranchName = creditCardBranchName;
    }

    public int getCreditCardDay() {
        return creditCardDay.get();
    }

    public void setCreditCardDay(IntegerProperty creditCardDay) {
        this.creditCardDay = creditCardDay;
    }

    public int getCreditCardMonth() {
        return creditCardMonth.get();
    }

    public void setCreditCardMonth(IntegerProperty creditCardMonth) {
        this.creditCardMonth = creditCardMonth;
    }

    public int getCreditCardYear() {
        return creditCardYear.get();
    }

    public void setCreditCardYear(IntegerProperty creditCardYear) {
        this.creditCardYear = creditCardYear;
    }
}
