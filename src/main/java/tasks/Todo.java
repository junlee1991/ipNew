package tasks;

/***
 * A class to store information of a Todo task
 */
public class Todo extends Task {
    /***
     * Constructor for Todo
     * @param description
     */
    public Todo(String description) {
        super(description);
    }

    /***
     * String representation of Todo object
     * @return String
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
