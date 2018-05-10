/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom_cells;

import javafx.scene.control.TableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.util.Callback;
import model.Customer;

/**
 *
 * @author lowlevel
 */
public class CheckBoxSelectCustomer implements Callback{

    @Override
    public TableCell call(Object p) {
        CheckBoxTableCell<Customer,Boolean> checkBoxCell = new CheckBoxTableCell<>();
        return checkBoxCell;
    }
    
    
    
}
