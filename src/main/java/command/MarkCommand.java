package command;

import Exceptions.DukeException;
import Exceptions.InvalidNumberException;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;

public class MarkCommand extends Command{

    private int index;

    public MarkCommand(int index){
        super();
        this.index = index;
    }

    public void validate() throws Exception {

    }

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
