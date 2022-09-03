package Exceptions;

public class BlankException extends DukeException {
    public BlankException() {
        super("OOPS!!! This description cannot be empty.");
    }
}
