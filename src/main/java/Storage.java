import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Storage{

    protected String directory;
    protected String filePath;

    public Storage(String directory, String filePath){
        this.directory = directory;
        this.filePath = filePath;
    }

    public ArrayList<Task> load() throws IOException{
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

    //overwrites and rewrite to the text file
    public void writeFile(TaskList taskList) {
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



//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//
///**
// * Storage for the Duke chatbot, storing and restoring files into/from a save file.
// *
// * @author Aaron Tan
// */
//public class Storage {
//
//    private static final File FILE_PATH = new File("src/main/java/data/duke.txt");
//
//    /**
//     * Loads data from a save file.
//     *
//     * @return A TaskList with data loaded from a savefile.
//     */
//    protected static TaskList readData() {
//        try {
//            Scanner fileScanner = new Scanner(FILE_PATH);
//            TaskList tasks = new TaskList();
//            while (fileScanner.hasNextLine()) {
//                String[] info = fileScanner.nextLine().split(" \\| ");
//                String type = info[0];
//                boolean isDone = info[1].equals("1") ? true : false;
//                String description = info[2];
//                Task task;
//                switch (type) {
//                    case "T":
//                        task = new Todo(description, isDone);
//                        break;
//                    case "D":
//                        task = new Deadline(description, isDone, info[3]);
//                        break;
//                    case "E":
//                        task = new Event(description, isDone, info[3]);
//                        break;
//                    default:
//                        throw new DukeException("invalid task type, try T, D, E");
//                }
//                tasks.add(task);
//            }
//            fileScanner.close();
//            return tasks;
//        } catch (FileNotFoundException e) {
//            System.out.println("data cannot be found");
//        } catch (DukeException e) {
//            System.out.println("data cannot be read");
//        }
//        return null;
//    }
//
//    /**
//     * Saves data from given TaskList into save file.
//     *
//     * @param tasks TaskList to be saved.
//     */
//    protected void saveData(TaskList tasks) {
//        try {
//            FileWriter fw = new FileWriter(FILE_PATH);
//            for (int i = 0; i < tasks.size(); i++) {
//                Task task = tasks.get(i);
//                String toSave = task.saveString();
//                fw.write(toSave);
//            }
//            fw.close();
//        } catch (IOException e) {
//            System.out.println("data cannot be saved");
//        }
//    }
//}
