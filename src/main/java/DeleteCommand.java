import Exceptions.DukeException;

public class DeleteCommand extends Command{

    private int index;

    public DeleteCommand(int index){
        super();
        this.index = index;
    }

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


