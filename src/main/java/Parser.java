//import Exceptions.DukeException;
import Exceptions.*;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Handles user input.
 *
 * @author Julio Harjo
 */
public class Parser {

    /**
     * Stores tasks in a text file.
     */
    protected static Storage storage;

    /**
     * Handles User interaction.
     */
    protected static Ui ui;

    /**
     * Constructor.
     *
     * @param storage The storage list used.
     * @param ui   The Ui interface used.
     */
    public Parser(Storage storage, Ui ui) {
        this.storage = storage;
        this.ui = ui;
    }

    public static Command parse(String command) throws DukeException{
        String[] c = command.split(" ");

        try {
            if (c[0].equals("list")) {
                return new ListCommand();
            }

            else if (c[0].equals("mark")) {
                String number = command.substring(5);
                int taskNum = Integer.parseInt(number);
                return new MarkCommand(taskNum);
            }

            else if (c[0].equals("unmark")) {
                String number = command.substring(7);
                int index = Integer.parseInt(number);
                return new UnmarkCommand(index);
            }

            else if (c[0].equals("todo")) {
                return new TodoCommand(command);
            }

            else if (c[0].equals("deadline")) {
                return new DeadlineCommand(command);
            }

            else if (c[0].equals("event")) {
                return new EventCommand(command);
            }

            else if (c[0].equals("delete")) {
                int taskNum = Integer.parseInt(c[1]);
                return new DeleteCommand(taskNum);
            }

            else if (c[0].equals("bye")){
                return new ByeCommand();
            }

            else {
                throw new InvalidInstructionException();
            }
        }
        catch (DukeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}


