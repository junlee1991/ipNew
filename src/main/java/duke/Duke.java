package duke;

import java.io.File;
import java.io.IOException;
import tasks.TaskList;
import command.Command;
import exceptions.*;

import javafx.scene.image.Image;

/***
 * Main class
 */

public class Duke {

    public static final String DIRECTORY_NAME = System.getProperty("user.dir") + File.separator + "data";
    public static final String FILE_NAME = "duke.txt";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    private Image user = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image duke = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /***
     * Constructor for Duke
     * Creates new storage and UI object once initialized
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage(DIRECTORY_NAME, FILE_NAME);

        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            // print some error
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }


    /**
     * You should have your own function to generate a response to user input.
     * Replace this stub with your completed method.
     */
    public String getResponse(String command) {
        try {
            Command c = Parser.parse(command);
            String output = c.execute(tasks, ui, storage);
            return output;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    /***
     * A method to runs the program.
     */
    public void run() {
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
        new Duke().run();
    }
}
