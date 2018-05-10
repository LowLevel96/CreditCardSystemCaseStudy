/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.Queries;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author lowlevel
 */
public class Customer {
    
//    Queries query = new Queries();   
    private BooleanProperty selected;
    private IntegerProperty id;
    private StringProperty first_name;
    private StringProperty middle_name;
    private StringProperty last_name;
    private StringProperty email;
    private StringProperty ssn;
    private IntegerProperty phone;
    private StringProperty street_name;
    private StringProperty apt_no;
    private StringProperty city;
    private StringProperty country;
    private StringProperty state;
    private StringProperty zip;
    private IntegerProperty number_of_cc;

    public Customer() {}
    
    public Customer(int id, String first_name, String middle_name, String last_name, String email, String ssn, int phone, String street_name, String apt_no, String city, String country, String state, String zip, int number_of_cc) {
        this.selected = new SimpleBooleanProperty(false);
        this.id = new SimpleIntegerProperty(id);
        this.first_name = new SimpleStringProperty(first_name);
        this.middle_name = new SimpleStringProperty(middle_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.email = new SimpleStringProperty(email);
        this.ssn = new SimpleStringProperty(ssn);
        this.phone = new SimpleIntegerProperty(phone);
        this.street_name = new SimpleStringProperty(street_name);
        this.apt_no = new SimpleStringProperty(apt_no);
        this.city = new SimpleStringProperty(city);
        this.country = new SimpleStringProperty(country);
        this.state = new SimpleStringProperty(state);
        this.zip = new SimpleStringProperty(zip);
        this.number_of_cc = new SimpleIntegerProperty(number_of_cc);
    }
    
    
    public boolean getSelected() {
        return selected.get();
    }

    // Getters //
    public void setSelected(BooleanProperty selected) {
        this.selected = selected;
    }

    public int getId() {
        return id.get();
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public String getMiddle_name() {
        return middle_name.get();
    }

    public String getLast_name() {
        return last_name.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getSsn() {
        return ssn.get();
    }

    public int getPhone() {
        return phone.get();
    }

    public String getStreet_name() {
        return street_name.get();
    }
    
    public String getApt_no() {
        return apt_no.get();
    }
    
    public String getCity() {
        return city.get();
    }

    public String getCountry() {
        return country.get();
    }

    public String getState() {
        return state.get();
    }

    public String getZip() {
        return zip.get();
    }

    public int getNumber_of_cc() {
        return number_of_cc.get();
    }
    
    //

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = new SimpleStringProperty(first_name);
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = new SimpleStringProperty(middle_name);
    }

    public void setLast_name(String last_name) {
        this.last_name = new SimpleStringProperty(last_name);
    }

    public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }

    public void setSsn(String ssn) {
        this.ssn = new SimpleStringProperty(ssn);
    }

    public void setPhone(int phone) {
        this.phone = new SimpleIntegerProperty(phone);
    }

    public void setStreet_name(String street_name) {
        this.street_name = new SimpleStringProperty(street_name);
    }
    
    public void setApt_no(String apt_no) {
        this.apt_no = new SimpleStringProperty(apt_no);
    }
    
    public void setCity(String city) {
        this.city = new SimpleStringProperty(city);
    }

    public void setCountry(String country) {
        this.country = new SimpleStringProperty(country);
    }

    public void setState(String state) {
        this.state = new SimpleStringProperty(state);
    }

    public void setZip(String zip) {
        this.zip = new SimpleStringProperty(zip);
    }

    public void setNumber_of_cc(int number_of_cc) {
        this.number_of_cc = new SimpleIntegerProperty(number_of_cc);
    }
}
