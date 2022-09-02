import Exceptions.DukeException;

public class ByeCommand extends Command{

    public ByeCommand() {
        super();
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        ui.exit();
        setExitTrue();
    }
}
