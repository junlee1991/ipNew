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
        System.out.println("Hello! I'm Duke\n" + "What can I do for you?");
    }

    public void exit(){
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showLoadingError(){
        System.out.println("Loading Error Encountered");
    }

    public void printDelete(){};

    public void printList(){};

    public void printMark(){};

    public void printUnmark(){};


    /**
     * List the items in the list
     */
    public void listItOut(TaskList lst){
        for (int i = 0; i < lst.size(); i++) {
            System.out.println(i + 1 + "." + lst.get(i));
        }
    }

    /**
     * Prints the error message when Exception occured
     *
     * @param s string that gets printed
     */
    public void showError(String s) {
        System.out.println(s);
    }
}
