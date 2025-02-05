package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A type of tasks which takes in a specified date and time (deadline)
 */

public class Deadline extends Task {

    protected String by;
    /**
     * Constructor of Deadline
     * @param description of deadline
     * @param by in the format of a string in the format of day/month/year time eg. 02/05/2019 1800
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }
    /**
     * Method to covert String into formatted string in date format.
     * @param str with the exact format day/month/year time(24 hour format) eg. 02/05/2019 1800
     */

    public String dateConvert(String str){
        // String to LocalDate
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime date = LocalDateTime.parse(str, format1);
        // DateTime to String
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd MMM yyyy h:mm a"));
        return formattedDate;
    }

    /***
     * Overrides the toString format to represent a Deadline Object
     * @return A string
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dateConvert(by) + ")";
    }
}