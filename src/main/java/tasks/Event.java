package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected String at;

    /**
     * Constructor to instantiate a tasks.Event object
     * @param description of tasks.Event
     * @param at in the form of a string in the format of day/month/year time eg. 02/05/2019 1800
     */

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    /***
     * Method to return the event time
     * @return String
     */
    public String getAt() {
        return this.at;
    }

    /**
     * Method to covert String into formatted string in date format.
     * @param str with the exact format day/month/year time(24 hour format)
     */

    public String dateConvert(String str){
        // String to LocalDate
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
        LocalDateTime date = LocalDateTime.parse(str, format1);
        // DateTime to String
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd MMM yyyy h:mm a"));
        return formattedDate;
    }
    /**
     * Override the toString format to include description and date
     * @return A string
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + dateConvert(at) + ")";
    }
}
