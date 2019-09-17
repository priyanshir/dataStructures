package misc.exceptions;

/**
 * An exception used in node data structures when a cycle is detected.
 */
public class CycleDetectedException extends RuntimeException {
    public CycleDetectedException() {
        super();
    }

    public CycleDetectedException(String message) {
        super(message);
    }

    public CycleDetectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CycleDetectedException(Throwable cause) {
        super(cause);
    }
}
