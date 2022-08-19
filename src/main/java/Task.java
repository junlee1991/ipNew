public class Task {

    private String name;
    private boolean isDone = false;

    /**
     * Constructor to create task object
     */
    public Task(String name){
        this.name = name;
    }

//    public boolean getStatus(){
//        return this.isDone;
//    }

    public void setAsMarked(){
        isDone = true;
    }

    public String getDescription(){
        return this.name;
    }

    /**
     * retrieves status of task
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
     * Returns the string representation of the Task object.
     *
     * @return the string listing the elements in TaskList
     */
    @Override
    public String toString(){
        if(isDone == true)
            return "[X] " + name;
        else
            return "[ ] " + name;
    }
}
