package tasks;

/***
 * A task class to store information about a task.
 */

public class Task {

    private String name;
    private boolean isDone = false;

    /**
     * Constructor to create task object
     */
    public Task(String name){
        this.name = name;
    }

    /***
     * set the task as done
     */
    public void setAsMarked(){
        isDone = true;
    }
    /***
     * a method to get the description of the task
     * @return String
     */
    public String getDescription(){
        return this.name;
    }

    /**
     * retrieves status of task
     * @return String
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * set task as not done
     * @return false boolean which means undone
     */
    public void setAsUnmarked(){
        isDone = false;
    }

    /**
     * Returns the string representation of the tasks.Task object.
     * @return the string listing the elements in tasks.TaskList
     */
    @Override
    public String toString(){
        if(isDone == true)
            return "[X] " + name;
        else
            return "[ ] " + name;
    }
}
