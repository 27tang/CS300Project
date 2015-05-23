
import javax.swing.table.DefaultTableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x
 */
public class TaskRenderer extends DefaultTableCellRenderer{
    
    @Override public void setValue(Object aValue){
        Task aTask = (Task)aValue;
        super.setValue(aTask.getTaskName());
        
    }
}
