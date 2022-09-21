package command;

import exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;

/***
 * This class has to do with exiting the program
 */

public class ByeCommand extends Command{

    /**
     * constructor for ByeCommand
     */
    public ByeCommand() {
        super();
    }

    /***
     * Exits the program
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        setExitTrue();
        return ui.exit();
    }
}
