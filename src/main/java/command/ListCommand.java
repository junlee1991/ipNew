package command;

import duke.Storage;
import duke.Ui;
import tasks.TaskList;

/**
 * This class handles listing the entire TaskList
 */
public class ListCommand extends Command {

    /**
     * Constructor for listCommand
     */
    public ListCommand(){
        super();
    }

    /**
     * Prints the entire taskList
     * @param taskList
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printList(taskList);
    }
}

