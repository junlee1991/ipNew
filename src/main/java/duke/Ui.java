package duke;

import tasks.Task;
import tasks.TaskList;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/***
 * A class that deals with interactions with the user
 */
public class Ui {
    private Scanner scanner;

    /**
     * Initialises a new UI with a scanner to get user input
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /***
     * read command of user
     * @return input in the form of a string
     */
    public String readCommand() {
        String s = "";
        try {
            s = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.print(e.getMessage());
        }
        return s;
    }

    /***
     * prints greet message
     */
    public void greet(){
        System.out.println("Hello! I'm duke.Duke\n" + "What can I do for you?");
    }

    /***
     * prints farewell message
     */
    public void exit(){
        this.scanner.close();
        System.out.println("Bye. Hope to see you again soon!");
    }
    /***
     * prints loading error message
     */
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
    /**
     * prints message after task is marked
     */
    public void printMark(int index, Task task){
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(index + "." + task);
    }
    /**
     * prints message after task is unmarked
     */
    public void printUnmark(int index, Task task){
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(index + "." + task);
    }
    /**
     * prints message after task is added to taskList
     */
    public void printAddTask(int size, Task task){
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.format("Now you have %s tasks in the list.\n", size);
    }
    /**
     * prints message when task is about to be deleted
     */
    public void printDelete(int index, Task task){
        System.out.println("Noted. I've removed this task: ");
        System.out.println(index + "." + task);
    }
    /**
     * prints message after task is deleted
     */
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
    /**
     * prints a line
     */
    public void showLine() {
        System.out.println("____________________________________________________________________________");
    }

    public void printFind(ArrayList<Task> res) {
        System.out.println("Here are the matching tasks in your list: ");
        for (int j = 0; j < res.size(); j++) {
            System.out.println("        " + (j + 1) + " " + res.get(j));
        }
    }
}
