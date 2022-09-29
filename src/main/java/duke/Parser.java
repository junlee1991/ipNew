package duke;

import command.*;
import exceptions.BlankException;
import exceptions.DukeException;
import exceptions.InvalidInstructionException;

/**
 * A Parser class to deal with making sense of the user command
 *
 * @author Julio Harjo
 * reused from https://github.com/shaniceng/ip with modification
 * reused from https://github.com/benmurphyy/ip/commit/f6c1f7b09b91227f5bf75fa8548de7bdacf49279 with modification
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
     * @param ui      The duke.Ui interface used.
     */
    public Parser(Storage storage, Ui ui) {
        Parser.storage = storage;
        Parser.ui = ui;
    }

    /***
     * parse command according to instruction
     * @param command
     * @return Command
     * @throws DukeException
     */
    public static Command parse(String command) throws DukeException {
        String[] c = command.split(" ", 2);
        String instruction = c[0];
        Command com;
        switch (instruction) {
            case ("list"):
                com = new ListCommand();
                break;
            case ("find"):
                checkIfBlank(c);
                com = new FindCommand(c[1]);
                break;
            case ("mark"):
                checkIfBlank(c);
                checkIfValidInteger(c);
                assert !command.substring(5).isEmpty();
                String number = command.substring(5);
                int taskNum = Integer.parseInt(number);
                com = new MarkCommand(taskNum);
                break;
            case ("unmark"):
                checkIfBlank(c);
                checkIfValidInteger(c);
                assert !command.substring(7).isEmpty();
                number = command.substring(7);
                int index = Integer.parseInt(number);
                com = new UnmarkCommand(index);
                break;
            case ("todo"):
                checkIfBlank(c);
                com = new TodoCommand(command);
                break;
            case ("deadline"):
                checkIfBlank(c);
                assert !command.substring(9).isEmpty();
                String[] stuff = c[1].split(" /by ");
                checkIfBlank(stuff);
                com = new DeadlineCommand(command);
                break;
            case ("event"):
                checkIfBlank(c);
                String[] stuff2 = c[1].split(" /at ");
                checkIfBlank(stuff2);
                com = new EventCommand(command);
                break;
            case ("delete"):
                checkIfBlank(c);
                checkIfValidInteger(c);
                assert !command.substring(7).isEmpty();
                int taskNum2 = Integer.parseInt(c[1]);
                com = new DeleteCommand(taskNum2);
                break;
            case ("bye"):
                com = new ByeCommand();
                break;
            default:
                throw new InvalidInstructionException();
        }
        return com;
    }

    /***
     * Check if description after command is empty
     * @param arr
     * @throws BlankException
     */
    public static void checkIfBlank(String[] arr) throws BlankException {
        try {
            if (arr[1].isBlank())
                throw new BlankException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BlankException();
        }
    }

    /***
     * checks if input is a valid integer from the list
     * @param arr
     * @throws NumberFormatException
     */
    public static void checkIfValidInteger(String[] arr) throws NumberFormatException {
        try {
            Integer.parseInt(arr[1]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please provide a valid number");
        }
    }
}

