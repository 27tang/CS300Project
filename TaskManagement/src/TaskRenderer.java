
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Xuan Tang
 * the TaskRenderer sets the look and feel of a cell in a JTable. It also allows
 * the cell to display the task's taskName.
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
