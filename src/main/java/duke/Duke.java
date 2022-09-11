package duke;

import java.io.File;
import java.io.IOException;

import command.Command;
import exceptions.*;
import tasks.TaskList;

/***
 * Main class
 */

class Duke {

    public static final String DIRECTORY_NAME = System.getProperty("user.dir") + File.separator + "data";
    public static final String FILE_NAME = "duke.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /***
     * Constructor for Duke.
     * @param directory
     * @param filePath
     */
    // once duke gets initiated, create duke.Ui object, create storage
    public Duke(String directory, String filePath) {
        ui = new Ui();
        storage = new Storage(directory, filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            // print some error
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    /***
     * A method to runs the program.
     */
    public void run() {
        ui.greet();
        boolean isExit = false;
        while (!isExit) {
            try {
                // ui should scan for input.
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        new Duke(DIRECTORY_NAME, FILE_NAME).run();
    }
}