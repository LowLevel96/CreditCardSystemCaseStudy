/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerTest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import task_controller.TaskCustomersController;

/**
 *
 * @author lowlevel
 */
public class CustomerTest {
    
    TaskCustomersController tc = new TaskCustomersController();
    
    
    @Test
    public void hello(){
        int n = 1;
        assertEquals(1, n);

    }
    
    @Test
    public void getMonthNumberTest(){
        String month = "December";
        int monthNumber = tc.getMonthNumber(month);
        assertEquals(12, monthNumber);
    }
    
}
