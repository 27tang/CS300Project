
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
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
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        Task aTask = (Task)value;
        int priority = aTask.getPriority();
        // You'll need some way to supply the filter value, may via a centralised 
        // manager of some kind.
        if (priority == 3) {
            setOpaque(true);
            setBackground(new Color(70,0,0));
        } else if(priority == 2){
            setOpaque(true);
            setBackground(new Color(0,0,50));
        }else {
            setOpaque(false);
        }
        return this;
    }
    
}
