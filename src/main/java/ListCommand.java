public class ListCommand extends Command{

    public ListCommand(){
        super();
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + 1 + "." + taskList.get(i));
        }
    }
}

