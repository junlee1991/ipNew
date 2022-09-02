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
        System.out.println("Noted. I've removed this task: ");
        System.out.println(index + "." + taskList.get(taskNumMinusOne));
        taskList.remove(taskNumMinusOne);
        System.out.println("Now you have " + taskList.size()  +" tasks in the list.");
        storage.writeFile(taskList);
    }
}


