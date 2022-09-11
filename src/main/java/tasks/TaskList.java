package tasks;

import java.util.ArrayList;

/***
 * A class to store information of a TaskList
 */
public class TaskList {

    private ArrayList<Task> taskList;

    /***
     * Constructor for TaskList
     * @param taskList
     */
    public TaskList(ArrayList<Task> taskList){
        this.taskList = taskList;
    }

    /***
     * Constructor overloading
     */
    public TaskList(){
        this.taskList = new ArrayList<>();
    }

    /***
     * Method that informs users how many tasks in the list
     * @return integer
     */
    public int size(){
        return taskList.size();
    }

    /***
     * Adds task to the taskList
     * @param task
     */
    public void add(Task task){
        taskList.add(task);
    }

    /***
     * Marks the specified index tasks as done
     * @param index
     */
    public void markTask(int index){
        taskList.get(index - 1).setAsMarked();
    }

    /***
     * Marks the specified index tasks as not done
     * @param index
     */
    public void unmarkTask(int index){
        taskList.get(index - 1).setAsUnmarked();
    }

    /***
     * returns the task at the specified index.
     * The first index is 0.
     * @param index
     * @return Task
     */
    public Task get(int index){
        return taskList.get(index);
    }

    /***
     * removes the task at the specified index
     * @param index
     */
    public void remove(int index){
        taskList.remove(index);
    }
}
