import Exceptions.DukeException;

public class DeadlineCommand extends Command{

    private String input;

    public DeadlineCommand(String input){
        super();
        this.input = input;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        input = input.substring(9);
        String[] split = input.split("/by");
        String description = split[0].trim();
        String time = split[1].trim();
        Task task = new Deadline(description, time);
        taskList.add(task);
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.format("Now you have %s tasks in the list.\n", taskList.size());
        storage.writeFile(taskList);
    }
}
