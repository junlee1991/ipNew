package command;

import Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.Task;
import tasks.TaskList;

/***
 * this class handles deleting a task as a command
 */
public class DeleteCommand extends Command{

    private int index;

    /**
     * Constructor for DeleteCommand
     * @param index
     */
    public DeleteCommand(int index){
        super();
        this.index = index;
    }

    /***
     * removes the task from taskList and updates the storage file
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        int taskNumMinusOne = index - 1;
        Task taskToDelete = taskList.get(taskNumMinusOne);
        ui.printDelete(index, taskToDelete);
        taskList.remove(taskNumMinusOne);
        ui.postDelete(taskList);
        storage.writeFile(taskList);
    }
}


