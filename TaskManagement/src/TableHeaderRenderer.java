
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;



/**
 *
 * @author Xuan Tang
 * This is a class that formats a JTable header to have a desired color and look
 */
public class TableHeaderRenderer extends DefaultTableCellRenderer{
    @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {

            JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            l.setBorder(new LineBorder(Color.WHITE, 1));

            l.setBackground(Color.BLACK);

            return l;
        }
    
}
