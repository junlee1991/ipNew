package Exceptions;

public class BlankException extends DukeException {
    public BlankException() {
        super("OOPS!!! This command needs a description. See instruction for more details");
    }
}
