/**
 *
 * @author Xuan Tang
 * The Task class models a single task. A task has three attributes, a name,
 * a deadline, and a prioirty level.
 */
public class Task {
    
    private String taskName;
    private String deadline;
    private int taskPriority;
    /**
     * default constructor
     */
    Task(){
        
    }
    /**
     * constructor with arguments to set its attributes
     * @param taskName
     * The name of the task
     * @param deadline
     * The deadline of the task
     * @param taskPriority 
     * the prioirty level of the task
     */
    Task(String taskName, String deadline, int taskPriority){
        this.taskName = taskName;
        this.deadline = deadline;
        this.taskPriority = taskPriority;
    }
    /**
     * Gets the task name
     * @return task name
     */
    public String getTaskName(){
        return taskName;
    }
    /**
     * gets the deadline
     * @return deadline
     */
    public String getDate(){
        return deadline;
    }
    /**
     * gets the prioirty level
     * @return prioirty
     */
    public int getPriority(){
        return taskPriority;
    }
    /**
     * sets the taskName to a new value
     * @param taskName 
     * the new taskName to adopt
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    /**
     * sets the deadline to a new value
     * @param deadline
     * the new deadline to adopt
     */
    public void setDate(String deadline) {
        this.deadline = deadline;
    }
    /**
     * sets the prioirty to a new value
     * @param taskPriority 
     * the new priority level to adopt
     */
    public void setPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }
    
    
    
}
