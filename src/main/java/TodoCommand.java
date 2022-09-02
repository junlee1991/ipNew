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
            System.out.println("Got it. I've added this task: \n" + task);
            System.out.format("Now you have %s tasks in the list.\n", taskList.size());
            storage.writeFile(taskList);
    }
}
