package command;

import duke.Storage;
import duke.Ui;
import tasks.TaskList;

public class ListCommand extends Command {

    public ListCommand(){
        super();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.printList(taskList);
    }
}

