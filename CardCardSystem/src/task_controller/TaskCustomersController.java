/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_controller;

import database.Queries;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.CreditCard;
import model.Customer;
import model.Payment;
import model.Transaction;

/**
 * FXML Controller class
 *
 * @author lowlevel
 */
public class TaskCustomersController implements Initializable {

    Queries queries = new Queries();
    
    // Customers TableView and TableColumns
    @FXML private TextField customerSearchByFullName;
    @FXML private TextField customerSearchByEmail;
    @FXML private TextField customerSearchBySSN;
    @FXML private TextField customerSearchByPhone;
    @FXML private TableView<Customer> customerTableView;
    @FXML private TableColumn<Customer, Boolean> customerRadio;
    @FXML private TableColumn<Customer, Integer>customerId;
    @FXML private TableColumn<Customer, String> customerFirstName;
    @FXML private TableColumn<Customer, String> customerMiddleName;
    @FXML private TableColumn<Customer, String> customerLastName;
    @FXML private TableColumn<Customer, String> customerEmail;
    @FXML private TableColumn<Customer, String> customerSSN;
    @FXML private TableColumn<Customer, Integer> customerPhone;
    @FXML private TableColumn<Customer, String> customerStreetName;
    @FXML private TableColumn<Customer, String> customerAptNo;
    @FXML private TableColumn<Customer, String> customerCity;
    @FXML private TableColumn<Customer, String> customerCountry;
    @FXML private TableColumn<Customer, String> customerState;
    @FXML private TableColumn<Customer, String> customerZip;
    @FXML private TableColumn<Customer, Integer> customerNumberOfCC;
    
    // Credit Card TableView and TableColumns
    @FXML private TableView<CreditCard> creditCardTableView;
    @FXML private TableColumn<CreditCard, Integer> creditCardId;
    @FXML private TableColumn<CreditCard, String> creditCardNumber;
    @FXML private TableColumn<CreditCard, String> creditCardBranchName;
//    @FXML private TableColumn<CreditCard, String> creditCardDueDate;
    @FXML private TableColumn<CreditCard, Integer> creditCardDay;
    @FXML private TableColumn<CreditCard, Integer> creditCardMonth;
    @FXML private TableColumn<CreditCard, Integer> creditCardYear;
    
    // Transaction TableView and TableColumns
    @FXML private TableView<Transaction> transactionTableView;
    @FXML private TableColumn<Transaction, Integer> transactionId;
    @FXML private TableColumn<Transaction, Integer> transactionCreditCard;
    @FXML private TableColumn<Transaction, String> transactionType;
    @FXML private TableColumn<Transaction, Integer> transactionValue;
    @FXML private TableColumn<Transaction, String> transactionDate;
    @FXML private DatePicker transactionsDateFrom;
    @FXML private DatePicker transactionsDateTo;
    
    // Generate montly bill
    @FXML private ComboBox generateMonthsComboBox;
    @FXML private ComboBox generateYearsComboBox;
    @FXML private Button generateBillButton;
    @FXML private Label generateLabelText;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        addValuesToMonthComboBox();
        addValuesToYearComboBox();
        
        listenerCustomerTableView();
        listenerCreditCardTableView();
        
        generateBillButtonListener();
        
        refreshScene();
    }
    
    public void refreshScene(){
        refreshCustomerTableView();
    }
    
    public SortedList<Customer> listenerCustomerTableView(ObservableList<Customer> data){
        SortedList<Customer> sortedData;
        sortedData = listenerSearchByFullName(data);
        sortedData = listenerSearchByEmail(sortedData);
        sortedData = listenerSearchBySSN(sortedData);
        sortedData = listenerSearchByPhone(sortedData);
        
        return sortedData;
    }

    public void refreshCustomerTableView(){
        ObservableList<Customer> data = queries.queryCustomers();    
//        listenerSearchByFullName(data);
//        listenerSearchByEmail(customerTableView.getItems());
        //SortedList<Customer> sortedData = listenerSearchByFullName(data);
//        listenerCustomerTableView(data)
        customerTableView.setItems(listenerCustomerTableView(data));
        customerTableView.setEditable(true);
        
        customerId.setCellValueFactory(new PropertyValueFactory<>("id"));
        customerFirstName.setCellValueFactory(new PropertyValueFactory<>("first_name"));
        customerMiddleName.setCellValueFactory(new PropertyValueFactory<>("middle_name"));
        customerLastName.setCellValueFactory(new PropertyValueFactory<>("last_name"));
        customerEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        customerSSN.setCellValueFactory(new PropertyValueFactory<>("ssn"));
        customerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        customerStreetName.setCellValueFactory(new PropertyValueFactory<>("street_name"));
        customerAptNo.setCellValueFactory(new PropertyValueFactory<>("apt_no"));
        customerCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        customerCountry.setCellValueFactory(new PropertyValueFactory<>("country"));
        customerState.setCellValueFactory(new PropertyValueFactory<>("state"));
        customerZip.setCellValueFactory(new PropertyValueFactory<>("zip"));
        customerNumberOfCC.setCellValueFactory(new PropertyValueFactory<>("number_of_cc"));
        
        customerFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerFirstName();
        customerMiddleName.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerMiddleName();
        customerLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerLastName();
        customerEmail.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerEmail();
//        customerPhone.setCellFactory(TextFieldTableCell.forTableColumn());
//        editCustomerPhone();
        customerZip.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerZip();
        customerAptNo.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerAptNo();
        customerStreetName.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerStreeName();
        customerCity.setCellFactory(TextFieldTableCell.forTableColumn());
        editCustomerCity();
        customerState.setCellFactory(TextFieldTableCell.forTableColumn());
//        editCustomerState();
//        customerCountry.setCellFactory(TextFieldTableCell.forTableColumn());
//        editCustomerCountry();
    }
    
    public void refreshCreditCardTableView(int customerId){
        ObservableList<CreditCard> data = queries.queryCreditCardByCustomerId(customerId);
        
        try {
            creditCardTableView.getItems().clear();
            creditCardTableView.setItems(data);
            
            creditCardId.setCellValueFactory(new PropertyValueFactory<>("creditCardId"));
            creditCardNumber.setCellValueFactory(new PropertyValueFactory<>("creditCardNumber"));
            creditCardBranchName.setCellValueFactory(new PropertyValueFactory<>("creditCardBranchName"));
//            creditCardDueDate.setCellValueFactory(new PropertyValueFactory<>("creditCardDueDate"));
            creditCardDay.setCellValueFactory(new PropertyValueFactory<>("creditCardDay"));
            creditCardMonth.setCellValueFactory(new PropertyValueFactory<>("creditCardMonth"));
            creditCardYear.setCellValueFactory(new PropertyValueFactory<>("creditCardYear"));
        }catch (Exception e) {
            
            
        }
        
    }

    public void refreshTransactionTableView(int creditCardId){
        ObservableList<Transaction> data = FXCollections.observableArrayList();
        data = queries.queryTransactionByCreditCardId(creditCardId);
        
        try{
            transactionTableView.setItems(listenerTransactionTableView(data));

            transactionId.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
            transactionCreditCard.setCellValueFactory(new PropertyValueFactory<>("transactionCreditCard"));
            transactionType.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
            transactionValue.setCellValueFactory(new PropertyValueFactory<>("transactionValue"));
            transactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        }catch(Exception e){
            
        }
        
    }
    
     public SortedList<Transaction> listenerTransactionTableView(ObservableList<Transaction> data){
        SortedList<Transaction> sortedData;
        sortedData = listenerFilterByDateFrom(data);
        sortedData = listenerFilterByDateTo(sortedData);
        
        return sortedData;
    }
    
    public void listenerCustomerTableView(){
            customerTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                refreshCreditCardTableView(newSelection.getId());
                refreshTransactionTableView(0);
            }
        });
    }
    
    public void listenerCreditCardTableView(){
        creditCardTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                
                transactionsDateFrom.setValue(null);
                System.out.println(newSelection.getCreditCardId());
                refreshTransactionTableView(newSelection.getCreditCardId());
            }
        });
    }
    
        
    public SortedList<Customer> listenerSearchByFullName(ObservableList<Customer> data){
        
        FilteredList<Customer> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        customerSearchByFullName.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                String fullName = customer.getFirst_name().concat(" "+customer.getLast_name());
                
                if(fullName.toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(customerTableView.comparatorProperty());
        
        return sortedData;
//        customerTableView.setItems(sortedData);
    }
    
    public SortedList<Customer> listenerSearchByEmail(ObservableList<Customer> data){
        
        FilteredList<Customer> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        customerSearchByEmail.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
       
                System.out.println(customer.getEmail());
                if(customer.getEmail().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(customerTableView.comparatorProperty());
//        customerTableView.setItems(sortedData);
        return sortedData;
    }
    
    public SortedList<Customer> listenerSearchBySSN(ObservableList<Customer> data){
        
        FilteredList<Customer> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        customerSearchBySSN.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                String fullName = customer.getFirst_name().concat(" "+customer.getLast_name());
                
                if(customer.getSsn().startsWith(lowerCaseFilter)){
                    return true;
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(customerTableView.comparatorProperty());
        
        return sortedData;
    }
    
    public SortedList<Customer> listenerSearchByPhone(ObservableList<Customer> data){
        
        FilteredList<Customer> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        customerSearchByPhone.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
         
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                
                if(Integer.toString(customer.getPhone()).startsWith(lowerCaseFilter)){
                    return true;
                }

                return false; // Does not match.
            });
            
        });
        

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(customerTableView.comparatorProperty());
        
        return sortedData;
    }
    
    public SortedList<Transaction> listenerFilterByDateFrom(ObservableList<Transaction> data){
        
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionsDateFrom.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (transactionsDateFrom.getValue() == null) {
                    return true;
                }
                
                String str = customer.getTransactionDate();
                System.out.println(str);
                str = str.split(" ")[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime = LocalDate.parse(str, formatter);
                System.out.println(dateTime);
           

                // Compare first name and last name of every person with filter text.
                String dateFilter = transactionsDateFrom.getValue().format(DateTimeFormatter.ISO_DATE);
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime2 = LocalDate.parse(dateFilter, formatter2);
                
                System.out.println(dateTime2);
                if(dateTime.isAfter(dateTime2)){
                    return true;
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Transaction> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(transactionTableView.comparatorProperty());
        
        return sortedData;
    }
    
    public SortedList<Transaction> listenerFilterByDateTo(ObservableList<Transaction> data){
        
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionsDateTo.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.
                if (newValue == null) {
                    return true;
                }
                
                String str = customer.getTransactionDate();
                System.out.println(str);
                str = str.split(" ")[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime = LocalDate.parse(str, formatter);
                System.out.println(dateTime);
           

                // Compare first name and last name of every person with filter text.
                String dateFilter = newValue.format(DateTimeFormatter.ISO_DATE);
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime2 = LocalDate.parse(dateFilter, formatter2);
                
                System.out.println(dateTime2);
                if(dateTime.isBefore(dateTime2)){
                    return true;
                }

                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Transaction> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(transactionTableView.comparatorProperty());
        
        return sortedData;
    }
    
    public void generateBillButtonListener(){
        EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
//                label.setText("Accepted");
                try{
                    ArrayList<Payment> payment = getAllValuesForGenerating();
                    ObservableList<Payment> data = queries.queryPayments(payment);
                    generateBillStatement(data);
                }catch(java.lang.NullPointerException e){
                    generateLabelText.setText("You have to spcify Credit Card, month and year. Please try again!");
                }
                event.consume();
            }
        };
        
        generateBillButton.setOnAction(buttonHandler);
    }
    
    public void generateBillStatement(ObservableList<Payment> data){
        BufferedWriter bw = null;
        FileWriter fw = null;
        
        int month = data.get(0).getMonth();
        int year = data.get(0).getYear();
        double balance = data.get(0).getBalance();
        double payments = data.get(0).getPayments();
        
        try{
            fw = new FileWriter(month+"-"+year+"-Statement.txt");
            bw = new BufferedWriter(fw);
            
            bw.append("Month: " + month);
            bw.append("\nYear: " + year);
            bw.append("\nBalance: " + balance);
            bw.append("\nPayments: " + payments);
        } catch (IOException ex) {
            Logger.getLogger(TaskCustomersController.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            try{
                if(bw!=null){
                    bw.close();
                }else if(fw!=null){
                    fw.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(TaskCustomersController.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                generateLabelText.setText("Statement create successfully. Filename: " + month+"-"+year+"-Statement.txt" );
            }
            

        }
    }
    
    public ArrayList<Payment> getAllValuesForGenerating(){
        
        try{
            int credit_card_id = creditCardTableView.getSelectionModel().selectedItemProperty().getValue().getCreditCardId();
            String month = generateMonthsComboBox.getValue().toString();
            String year = generateYearsComboBox.getValue().toString();
            
            ArrayList<Payment> payment = new ArrayList<>();
            payment.add(new Payment(getMonthNumber(month), Integer.parseInt(year), credit_card_id));
            
            return payment;
        }catch(NullPointerException ex){
            generateLabelText.setText("You have to spcify Credit Card, month and year. Please try again!");
        }catch(IllegalArgumentException ex){
            generateLabelText.setText("You have to spcify Credit Card, month and year. Please try again!");
        }
        
        return null;
    }
    
    public int getMonthNumber(String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }
    
    public void addValuesToMonthComboBox(){
        String[] months = new DateFormatSymbols().getMonths();
        ArrayList<String> s = new ArrayList<String>(Arrays.asList(months));
        s.add(0, "Month");
        s.remove(s.size()-1);
        System.out.println(s.toString());
        ObservableList<String> data = FXCollections.observableArrayList(s);
        generateMonthsComboBox.setItems(data);
        
    }
    
    public void addValuesToYearComboBox(){
        int fromYear = 2010;
        int toYear = Year.now().getValue();
        ObservableList<String> data = FXCollections.observableArrayList();
        
        for(int i = fromYear; i <= toYear; i++){
            data.add(i+"");
        }
        Collections.reverse(data);
        generateYearsComboBox.setItems(data);
    }
    
    public void editCustomerFirstName(){
        customerFirstName.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setFirst_name((event.getNewValue()));
            queries.updateCustomerFirstName(customer.getId(), customer.getFirst_name());
        });
    }
    
    public void editCustomerMiddleName(){
        customerMiddleName.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setMiddle_name((event.getNewValue()));
            queries.updateCustomerMiddleName(customer.getId(), customer.getMiddle_name());
        });
    }
    
    public void editCustomerLastName(){
        customerLastName.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setLast_name((event.getNewValue()));
            queries.updateCustomerLastName(customer.getId(), customer.getLast_name());
        });
    }
    
    public void editCustomerEmail(){
        customerEmail.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setEmail((event.getNewValue()));
            queries.updateCustomerEmail(customer.getId(), customer.getEmail());
        });
    }
    
    public void editCustomerPhone(){
        customerPhone.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setPhone((event.getNewValue()));
            queries.updateCustomerPhone(customer.getId(), customer.getPhone());
        });
    }
    
    public void editCustomerZip(){
        customerZip.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setZip((event.getNewValue()));
            queries.updateCustomerZip(customer.getId(), customer.getZip());
        });
    }
    
    public void editCustomerAptNo(){
        customerAptNo.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setApt_no((event.getNewValue()));
            queries.updateCustomerAptNo(customer.getId(), customer.getApt_no());
        });
    }
    
    public void editCustomerStreeName(){
        customerStreetName.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setStreet_name((event.getNewValue()));
            queries.updateCustomerStreetName(customer.getId(), customer.getStreet_name());
        });
    }
    
    public void editCustomerCity(){
        customerCity.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setCity((event.getNewValue()));
            queries.updateCustomerCity(customer.getId(), customer.getCity());
        });
    }
    
    public void editCustomerCountry(){
        customerCountry.setOnEditCommit(event -> {
            Customer customer = event.getRowValue();
            customer.setCountry((event.getNewValue()));
            queries.updateCustomerCountry(customer.getId(), customer.getCountry());
        });
    }
    
    

//    public void editCustomerState(){
//        customerState.setOnEditCommit(event -> {
//            Customer customer = event.getRowValue();
//            customer.setState((event.getNewValue()));
//            queries.updateCustomerState(customer.getId(), customer.getState());
//        });
//    }
    
    
}
