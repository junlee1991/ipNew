package duke;

import tasks.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/***
 * A storage class to deals with loading tasks from the file and saving tasks in the file
 * adapted from https://github.com/czhongwei/ip/commit/1a216bd556cf149302e4935a4272f2e0fc2768c1 credit to czhongwei
 */

public class Storage {

    protected String directory;
    protected String filePath;

    /***
     * Constructor for storage class
     * @param directory
     * @param filePath
     */
    public Storage(String directory, String filePath){
        this.directory = directory;
        this.filePath = filePath;
    }

    /***
     * Create file and directory if not exist
     * @return An ArrayList of Task
     * @throws IOException
     */
    public ArrayList<Task> load() throws IOException{
        assert directory != null;
        assert filePath != null;
        ArrayList<Task> al = new ArrayList<>();
        File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdir();
        }
        // make a file
        String FULL_FILE = directory  + File.separator + filePath;
        File file = new File(FULL_FILE);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            al = readFile(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return al;
    }

    /***
     * reads the given file and puts it in an ArrayList
     * @param file
     * @return ArrayList of Task
     */
    public static ArrayList<Task> readFile(File file) {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split("\\|");
                String task = split[0];
                String mark = split[1];
                switch (task) {
                    case "T":
                        Todo todo = new Todo(split[2]);
                        if (mark.equals("1")) {
                            todo.setAsMarked();
                        }
                        tasks.add(todo);
                        break;
                    case "D":
                        Deadline deadline = new Deadline(split[2], split[3]);
                        if (mark.equals("1")) {
                            deadline.setAsMarked();
                        }
                        tasks.add(deadline);
                        break;
                    case "E":
                        Event event = new Event(split[2], split[3]);
                        if (mark.equals("1")) {
                            event.setAsMarked();
                        }
                        tasks.add(event);
                        break;
                }
            }
            return tasks;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }

    /***
     * Overwrites and rewrites tasks to the duke.txt file
     * @param taskList
     */
    public void writeFile(TaskList taskList) {
        assert directory != null;
        assert filePath != null;
        try{
            String FULL_FILE = directory  + File.separator + filePath;
            File newFile = new File(FULL_FILE);
            FileWriter fw = new FileWriter(newFile);
            for(int i = 0; i < taskList.size(); ++i) {
                Task task = taskList.get(i);
                String done = task.getStatusIcon().equals("X") ? "1" : "0";
                String write = "|" + done + "|" + task.getDescription();
                if (task instanceof Todo) {
                    write = "T" + write;
                } else if (task instanceof Deadline) {
                    write = "D" + write + "|" + ((Deadline) task).getBy();
                } else if (task instanceof Event) {
                    write = "E" + write + "|" + ((Event) task).getAt();
                }
                fw.write(write);
                fw.write(System.lineSeparator());
            }
            fw.close();
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }
    }
}