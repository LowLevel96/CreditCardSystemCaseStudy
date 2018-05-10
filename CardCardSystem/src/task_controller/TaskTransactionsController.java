/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task_controller;

import database.Queries;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Transaction;

/**
 * FXML Controller class
 *
 * @author lowlevel
 */
public class TaskTransactionsController implements Initializable {

    Queries queries = new Queries();

    // Transaction TableView and TableColumns
    @FXML private TableView<Transaction> transactionTableView;
    @FXML private TableColumn<Transaction, Integer> transactionId;
    @FXML private TableColumn<Transaction, String> customerFirstName;
    @FXML private TableColumn<Transaction, String> customerLastName;
    @FXML private TableColumn<Transaction, String> customerZip;
    @FXML private TableColumn<Transaction, Integer> transactionCreditCard;
    @FXML private TableColumn<Transaction, String> transactionType;
    @FXML private TableColumn<Transaction, Integer> transactionValue;
    @FXML private TableColumn<Transaction, String> transactionDate;
    @FXML private ComboBox<String> transactionStatesComboBox;
    @FXML private ComboBox<String> transactionTypesComboBox;
    @FXML private ComboBox<String> transactionMonthsComboBox;
    @FXML private ComboBox<String> transactionYearsComboBox;
    @FXML private TextField transactionFilterByZip;
    @FXML private Label transactionsNumberByTypes;
    @FXML private Label transactionsValueByTypes;
    @FXML private Label transactionsNumberByState;
    @FXML private Label transactionsValueByState;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshScene();
        
        addValuesToYearComboBox();
        addValuesToMonthComboBox();
        addValuesToStatesComboBox();
        addValuesToTypesComboBox();
    }
    
    public void listenersForLabels(ObservableList<Transaction> data){
        listenerFilterByTypes(data);
        listenerFilterByStates(data);
    }
    
    public void refreshScene(){
        refreshTransactionTableView();
    }
    
    public void refreshTransactionTableView(){
        ObservableList<Transaction> data = FXCollections.observableArrayList();
        data = queries.queryTransactionsWithCustomerAndCreditCard();
        listenersForLabels(data);
        
        try{
            //transactionTableView.getItems().clear();
            transactionTableView.setItems(listenerTransactionTableView(data));
            
            transactionId.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
            customerFirstName.setCellValueFactory(new PropertyValueFactory<>("customerFirstName"));
            customerLastName.setCellValueFactory(new PropertyValueFactory<>("customerLastName"));
            customerZip.setCellValueFactory(new PropertyValueFactory<>("customerZip"));
            transactionCreditCard.setCellValueFactory(new PropertyValueFactory<>("transactionCreditCard"));
            transactionType.setCellValueFactory(new PropertyValueFactory<>("transactionType"));
            transactionValue.setCellValueFactory(new PropertyValueFactory<>("transactionValue"));
            transactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public void addValuesToStatesComboBox(){
        transactionStatesComboBox.setItems(queries.queryStates());
    }
    
    public void addValuesToTypesComboBox(){
        transactionTypesComboBox.setItems(queries.queryTypes());
    }
    
    public void addValuesToMonthComboBox(){
        String[] months = new DateFormatSymbols().getMonths();
        ArrayList<String> s = new ArrayList<String>(Arrays.asList(months));
        s.add(0, "Month");
        s.remove(s.size()-1);
        System.out.println(s.toString());
        ObservableList<String> data = FXCollections.observableArrayList(s);
        transactionMonthsComboBox.setItems(data);
        
    }
    
    public void addValuesToYearComboBox(){
        int fromYear = 2010;
        int toYear = Year.now().getValue();
        ObservableList<String> data = FXCollections.observableArrayList();
        
        for(int i = fromYear; i <= toYear; i++){
            data.add(i+"");
        }
        Collections.reverse(data);
        transactionYearsComboBox.setItems(data);
    }
    
    public SortedList<Transaction> listenerFilterByZip(ObservableList<Transaction> data){
        System.out.println("1." + data);
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionFilterByZip.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                // If filter text is empty, display all persons.
         
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                //String lowerCaseFilter = newValue.toLowerCase();
                
                if(transaction.getCustomerZip().startsWith(newValue)){
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
    
    public SortedList<Transaction> listenerFilterByMonth(ObservableList<Transaction> data){
        System.out.println("1." + data);
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionMonthsComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                // If filter text is empty, display all persons.
         
                if (newValue == null || newValue.isEmpty() || newValue.equals("Month")) {
                    return true;
                }

                String str = transaction.getTransactionDate().split(" ")[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime = LocalDate.parse(str, formatter);
                
   
                
                if(dateTime.getMonthValue()==getMonthNumber(newValue)){
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
    
    public SortedList<Transaction> listenerFilterByYear(ObservableList<Transaction> data){
        System.out.println("1." + data);
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionYearsComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                // If filter text is empty, display all persons.
         
                if (newValue == null || newValue.isEmpty() || newValue.equals("Month")) {
                    return true;
                }

                String str = transaction.getTransactionDate().split(" ")[0];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateTime = LocalDate.parse(str, formatter);
                
                if(dateTime.getYear()==Integer.parseInt(newValue)){
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
    
    public int listenerFilterByTypes(ObservableList<Transaction> data){
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionTypesComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                // If filter text is empty, display all persons.
                //System.out.println("Types: " + newValue);
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                if(transaction.getTransactionType().equals(newValue)){
                    return true;
                }

                return false; // Does not match.
            });
            
            transactionsNumberByTypes.setText(filteredData.size()+"");
            transactionsValueByTypes.setText(sumTransactionsValues(filteredData)+"");
        });
        
        return filteredData.size();
    }
    
    public double sumTransactionsValues(FilteredList<Transaction> data){
        double sum = 0;
        for(Transaction i : data){
            String iNew = i.getTransactionValue().substring(1, i.getTransactionValue().length()-1);
            sum += Double.parseDouble(iNew);
        }
        return sum;
    }
    
    public int listenerFilterByStates(ObservableList<Transaction> data){
        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
        // 2. Set the filter Predicate whenever the filter changes.
        transactionStatesComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(transaction -> {
                // If filter text is empty, display all transactions.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                
                if(transaction.getTransactionState().equals(newValue)){
                    return true;
                }

                return false; // Does not match.
            });
            
            transactionsNumberByState.setText(filteredData.size()+"");
            transactionsValueByState.setText(sumTransactionsValues(filteredData)+"");
        });
        
        return filteredData.size();
    }
    
    public int getMonthNumber(String monthName) {
            return Month.valueOf(monthName.toUpperCase()).getValue();
    }
    
    public SortedList<Transaction> listenerTransactionTableView(ObservableList<Transaction> data){
        SortedList<Transaction> sortedData;
        sortedData = listenerFilterByZip(data);
        sortedData = listenerFilterByMonth(sortedData);
        sortedData = listenerFilterByYear(sortedData);
        
        return sortedData;
    }
     
//     public SortedList<Transaction> listenerSearchByPhone(ObservableList<Transaction> data){
//        
//        FilteredList<Transaction> filteredData = new FilteredList<>(data, p -> true);
//        // 2. Set the filter Predicate whenever the filter changes.
//        transactionsDateFrom.valueProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate(customer -> {
//                // If filter text is empty, display all persons.
//         
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//
//                // Compare first name and last name of every person with filter text.
//                String lowerCaseFilter = newValue.toLowerCase();
//                
//                if(Integer.toString(customer.getPhone()).startsWith(lowerCaseFilter)){
//                    return true;
//                }
//
//                return false; // Does not match.
//            });
//            
//        });
//        
//
//        // 3. Wrap the FilteredList in a SortedList. 
//        SortedList<Customer> sortedData = new SortedList<>(filteredData);
//
//        // 4. Bind the SortedList comparator to the TableView comparator.
//        sortedData.comparatorProperty().bind(customerTableView.comparatorProperty());
//        
//        return sortedData;
//    }
    
}
