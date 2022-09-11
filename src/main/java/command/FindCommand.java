package command;

import Exceptions.DukeException;
import duke.Storage;
import duke.Ui;
import tasks.Task;
import tasks.TaskList;
import java.util.ArrayList;

/***
 * Give users a way to find a task by searching for a keyword.
 */
public class FindCommand extends Command{

    private String keyword;

    /**
     * Constructor for find Command
     * @param keyword
     */
    public FindCommand(String keyword){
        super();
        this.keyword = keyword;
    }

    /***
     * Finds the relevant task with the keyword
     * @param taskList
     * @param ui
     * @param storage
     * @throws DukeException
     */

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException{
        ArrayList<Task> res = new ArrayList<>();
        for(int i = 0; i < taskList.size(); i++){
            Task t = taskList.get(i);
            String s = t.getDescription();
            if(s.contains(keyword)){
                res.add(t);
            }
        }
        ui.printFind(res);
    }
}


