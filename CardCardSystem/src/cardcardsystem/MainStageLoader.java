/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardcardsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import mainstage.MainStageController;

/**
 *
 * @author lowlevel
 */
public class MainStageLoader extends Application{


    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("2");
        // Load Tab Pane
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainstage/MainStage.fxml"));
        TabPane root = loader.load();
        MainStageController msc = loader.getController();
        
        //Load each Task Tab and add to Tab Pane
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/task_tabs/TaskCustomers.fxml"));
        Tab taskCustomer = loader2.load();
        root.getTabs().add(taskCustomer);
        
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("/task_tabs/TaskTransactions.fxml"));
        Tab taskTransaction = loader3.load();
        root.getTabs().add(taskTransaction);

        // In Debug modes use this
        //Parent root = FXMLLoader.load(getClass().getResource("/task_tabs/TaskCustomers.fxml"));
        
        stage.setTitle("Welcome to Card Credit System");
        stage.setScene(new Scene(root,1600,1000));
        stage.show();
    }
//    
//    public static void main(String[] args) {
//        launch(args);
//    }
    
    
    
}
