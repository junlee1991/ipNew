import Exceptions.DukeException;

public class EventCommand extends Command {

    private String input;

    public EventCommand(String input) {
        super();
        this.input = input;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        input = input.substring(6);
        String[] split = input.split("/at");
        String description = split[0].trim();
        String time = split[1].trim();
        Task task = new Event(description, time);
        taskList.add(task);
        System.out.println("Got it. I've added this task: \n" + task);
        System.out.format("Now you have %s tasks in the list.\n", taskList.size());
        storage.writeFile(taskList);
    }
}