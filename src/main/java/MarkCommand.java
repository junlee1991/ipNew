import Exceptions.DukeException;
import Exceptions.InvalidNumberException;

public class MarkCommand extends Command{

    private int index;

    public MarkCommand(int index){
        super();
        this.index = index;
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
