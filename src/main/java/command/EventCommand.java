package command;

import exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.Event;
import tasks.Task;
import tasks.TaskList;

public class EventCommand extends Command {

    private String input;

    public EventCommand(String input) {
        super();
        this.input = input;
    }

    /***
     * Adds an Event Task into the taskList and updates storage files
     * if duplicate detected, no changes made to taskList or storage
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        input = input.substring(6);
        String[] split = input.split("/at");
        String description = split[0].trim();
        String time = split[1].trim();
        Task task = new Event(description, time);
        if(taskList.checkDuplicate(task)){
            return ui.printDuplicates(task);
        }else {
            taskList.add(task);
            storage.writeFile(taskList);
            return ui.printAddTask(taskList.size(), task);
        }
    }
}