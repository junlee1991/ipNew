package command;

import exceptions.DukeException;
import exceptions.InvalidNumberException;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;

/**
 * This class handles marking a task as complete
 */
public class MarkCommand extends Command{

    private int index;

    /***
     * Constructor for MarkCommand
     * @param index
     */
    public MarkCommand(int index){
        super();
        this.index = index;
    }

//    public void validate() throws Exception {
//    }

    /***
     * marks task as done and update storage
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
        taskList.markTask(index);
        ui.printMark(index, taskList.get(taskNumMinusOne));
        storage.writeFile(taskList);
    }
}
