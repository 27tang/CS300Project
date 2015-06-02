
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author x
 */
public class TaskLists {
    private LinkedList<Task> toDoList = new LinkedList<Task>();
    private LinkedList<Task> inProgList = new LinkedList<Task>();
    private LinkedList<Task> doneList = new LinkedList<Task>();
    
    
    
    public void populateLists(String username) throws IOException{
        Scanner in = null;
        
        String filename = "userfiles/"+username + ".txt";
        
        try{
            in = new Scanner(new BufferedReader(new FileReader(filename)));

            int type;
            String name;
            String date;
            int priority;
            
            in.useDelimiter(":");
            while(in.hasNext()){
                
                if(!in.hasNext())
                    break;
                type = in.nextInt();
                name = in.next();
                date = in.next();
                
                String test = in.next();
                
                priority = Integer.parseInt(test.trim());
                if(type == 1){
                    toDoList.add(new Task(name, date, priority));
                }else if(type == 2){
                    inProgList.add(new Task(name, date, priority));
                }else if(type == 3){
                    doneList.add(new Task(name, date, priority));
                }
                
            }
        }finally{
            if(in!=null)
                in.close();
            else
                System.err.println("USERFILE NEVER OPENED.");
        }

    }
        
    public void populateTables(JTable toDoTable, JTable inProgressTable, JTable doneTable){
        ListIterator<Task> listIterator1 = toDoList.listIterator();
        DefaultTableModel m1 = (DefaultTableModel)toDoTable.getModel();
        while(listIterator1.hasNext()){
            m1.addRow(new Object[]{listIterator1.next()});
        }
        ListIterator<Task> listIterator2 = inProgList.listIterator();
        DefaultTableModel m2 = (DefaultTableModel)inProgressTable.getModel();
        while(listIterator2.hasNext()){
            m2.addRow(new Object[]{listIterator2.next()});
        }
        ListIterator<Task> listIterator3 = doneList.listIterator();
        DefaultTableModel m3 = (DefaultTableModel)doneTable.getModel();
        while(listIterator3.hasNext()){
            m3.addRow(new Object[]{listIterator3.next()});
        }
    }
    
    
    public void writeOut(String username) throws IOException{
        
        String filename = "userfiles/"+ username + ".txt";
        PrintWriter out = null; 
        
        
        try{
            out = new PrintWriter(new FileWriter(filename));
            ListIterator<Task> listIterator1 = toDoList.listIterator();
            boolean fileIsEmpty = true;
            if(listIterator1.hasNext())
                fileIsEmpty = false;
            while(listIterator1.hasNext()){
                Task currentTask = listIterator1.next();
                out.print("1:");
                out.print(currentTask.getTaskName()+":");
                out.print(currentTask.getDate()+":");
                out.print(currentTask.getPriority());
                if(listIterator1.hasNext())
                    out.print(":");
            }
            
            ListIterator<Task> listIterator2 = inProgList.listIterator();
            if(listIterator2.hasNext() && !fileIsEmpty)
                out.print(":");
            else if(listIterator2.hasNext() && fileIsEmpty){
                fileIsEmpty = false;
            }
            while(listIterator2.hasNext()){
                Task currentTask = listIterator2.next();
                out.print("2:");
                out.print(currentTask.getTaskName()+":");
                out.print(currentTask.getDate()+":");
                out.print(currentTask.getPriority());
                if(listIterator2.hasNext())
                    out.print(":");
            }
            
            
            ListIterator<Task> listIterator3 = doneList.listIterator();
            if(listIterator3.hasNext()&& !fileIsEmpty)
                out.print(":");
            else if(listIterator2.hasNext() && fileIsEmpty){
                fileIsEmpty = false;
            }
            while(listIterator3.hasNext()){
                Task currentTask = listIterator3.next();
                out.print("3:");
                out.print(currentTask.getTaskName()+":");
                out.print(currentTask.getDate()+":");
                out.print(currentTask.getPriority());
                if(listIterator3.hasNext())
                    out.print(":");
            }        
            
        }finally{
            if(out!=null)
                out.close();
            else
                System.err.println("USERFILE NEVER OPENED.");
        }
    }    
            
    public void addToDoTask(Task toAdd){
        toDoList.add(toAdd);
    }

    public void moveToDoToInProg(JTable toDoTable, JTable inProgressTable){
        Task taskToMove = toDoList.remove(toDoTable.getSelectedRow());
        inProgList.add(taskToMove);
        DefaultTableModel m1 = (DefaultTableModel)toDoTable.getModel();
        m1.removeRow(toDoTable.getSelectedRow());
        
        DefaultTableModel m2 = (DefaultTableModel)inProgressTable.getModel();
        m2.addRow(new Object[]{taskToMove});
    }
    
    public void moveInProgToDone(JTable inProgTable, JTable doneTable){
        Task taskToMove = inProgList.remove(inProgTable.getSelectedRow());
        doneList.add(taskToMove);
        DefaultTableModel m1 = (DefaultTableModel)inProgTable.getModel();
        m1.removeRow(inProgTable.getSelectedRow());
        
        DefaultTableModel m2 = (DefaultTableModel)doneTable.getModel();
        m2.addRow(new Object[]{taskToMove});
    }
    
    public void deleteTask(int index, int listType){
        if(listType == 1){
            toDoList.remove(index);
        } else if(listType == 2){
            inProgList.remove(index);
        } else if(listType == 3){
            doneList.remove(index);
        }
    }
    
}
