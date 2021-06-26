package htw.calenderproject.exceptions;

public class EventNotFoundException extends RuntimeException {
    /**
     * Constructs a <code>EventNotFoundException</code> with the specified message.
     * @param msg the detail message.
     */
    public EventNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code EventNotFoundException} with the specified message and root
     * cause.
     * @param msg the detail message.
     * @param cause root cause
     */
    public EventNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
