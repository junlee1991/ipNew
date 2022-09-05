package duke;

import tasks.Task;
import tasks.TaskList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ui {
    private Scanner scanner;

    /**
     * Initialises a new UI with a scanner to get user input
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String readCommand() {
        String s = "";
        try {
            s = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
        return s;
    }

    public void greet(){
        System.out.println("Hello! I'm duke.Duke\n" + "What can I do for you?");
    }

    public void exit(){
        this.scanner.close();
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showLoadingError(){
        System.out.println("Loading Error Encountered");
    }

    /**
     * List the items in the list
     */
    public void printList(TaskList taskList){
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + "." + taskList.get(i));
        }
    }

    public void printMark(int index, Task task){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(index + "." + task);
    }

    public void printUnmark(int index, Task task){
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(index + "." + task);
    }

    public void printAddTask(int size, Task task){
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.format("Now you have %s tasks in the list.\n", size);
    }

    public void printDelete(int index, Task task){
        System.out.println("Noted. I've removed this task: ");
        System.out.println(index + "." + task);
    }

    public void postDelete(TaskList taskList){
        System.out.println("Now you have " + taskList.size()  +" tasks in the list.");
    }

    /**
     * Prints the error message when Exception occurred
     *
     * @param s string that gets printed
     */
    public void showError(String s) {
        System.out.println(s);
    }

    public void showLine() {
        System.out.println("____________________________________________________________________________");
    }

}
