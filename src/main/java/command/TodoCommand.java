package command;

import Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.Task;
import tasks.TaskList;
import tasks.Todo;

/**
 * This class handles when a Todo task is added
 */
public class TodoCommand extends Command{

    private String input;

    /***
     * Constructor for TodoCommand
     * @param input
     */
    public TodoCommand(String input){
        super();
        this.input = input;
    }

    /***
     * adds todo task into Tasklist and updates storage
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
            Task task= new Todo(input);
            taskList.add(task);
            ui.printAddTask(taskList.size(), task);
            storage.writeFile(taskList);
    }
}
