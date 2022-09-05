package command;

import Exceptions.*;
import duke.Storage;
import duke.Ui;
import tasks.TaskList;

public abstract class Command{

    private boolean isExit;

    /**
     * Constructor that initializes whether the program should exit or not
     */
    public Command() {
        this.isExit = false;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public void setExitTrue(){
        isExit = true;
    }

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException;
}