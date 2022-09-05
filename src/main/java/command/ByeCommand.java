package command;

import Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;


public class ByeCommand extends Command{

    public ByeCommand() {
        super();
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        ui.exit();
        setExitTrue();
    }
}
