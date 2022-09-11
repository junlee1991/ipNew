package command;

import Exceptions.DukeException;
import Exceptions.InvalidNumberException;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;

/**
 * This class handles setting a task as unmarked
 */
public class UnmarkCommand extends Command{
    private int index;

    /**
     * Constructor for UnmarkCommand
     * @param index
     */
    public UnmarkCommand(int index){
        super();
        this.index = index;
    }

    /**
     * handles unmarking a task and updating storage
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
            int taskNumMinusOne = index - 1;
            if(taskNumMinusOne < 0 || taskNumMinusOne > taskList.size() - 1)
                throw new InvalidNumberException();
            taskList.unmarkTask(index);
            ui.printUnmark(index , taskList.get(taskNumMinusOne));
            storage.writeFile(taskList);
    }
}
