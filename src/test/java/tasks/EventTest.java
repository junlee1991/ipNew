package tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void addEventTest() {
        Event e = new Event("Larry's birthday", "02/12/2022 1830");
        assertEquals("[E][ ] Larry's birthday (at: 02 Dec 2022 6:30 PM)", e.toString());
    }
}