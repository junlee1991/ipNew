import Exceptions.DukeException;

public class TodoCommand extends Command{

    private String input;

    public TodoCommand(String input){
        super();
        this.input = input;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
            Task task= new Todo(input);
            taskList.add(task);
            ui.printAddTask(taskList.size(), task);
            storage.writeFile(taskList);
    }
}
