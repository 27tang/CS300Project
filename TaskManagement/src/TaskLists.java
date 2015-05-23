
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        System.out.println(filename);
        
        try{
            in = new Scanner(new BufferedReader(new FileReader(filename)));

            int type;
            String name;
            String date;
            int priority;
            
            
            while(in.hasNext()){
                type = Integer.parseInt(in.next());
                name = in.next();
                date = in.next();
                priority = Integer.parseInt(in.next());
                
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
                System.err.println("USERNAME FILE NEVER OPENED.");
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
            m2.addRow(new Object[]{false, listIterator2.next()});
        }
        ListIterator<Task> listIterator3 = doneList.listIterator();
        DefaultTableModel m3 = (DefaultTableModel)doneTable.getModel();
        while(listIterator3.hasNext()){
            m3.addRow(new Object[]{false, listIterator3.next()});
        }
    }
        
    public void addToDoTask(Task toAdd){
        toDoList.add(toAdd);
    }

    
}
