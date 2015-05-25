/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author x
 */
public class Task {
    
    private String taskName;
    private String deadline;
    private int taskPriority;
    
    Task(){
        
    }
    
    Task(String taskName, String deadline, int taskPriority){
        this.taskName = taskName;
        this.deadline = deadline;
        this.taskPriority = taskPriority;
    }
    
    public String getTaskName(){
        return taskName;
    }
    public String getDate(){
        return deadline;
    }
    public int getPriority(){
        return taskPriority;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDate(String deadline) {
        this.deadline = deadline;
    }

    public void setPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }
    
    
    
}
