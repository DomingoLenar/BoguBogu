/**
 * Custom exception class indicating that a stack underflow has occurred.
 * This exception is thrown when attempting to pop or peek an empty stack.
 */
public class StackUnderflowException extends Exception {

    /**
     * Constructs a new StackUnderflowException with a default message.
     * The default message is "Stack is empty".
     */
    public StackUnderflowException() {
        super("Stack is empty");
    }

    /**
     * Constructs a new StackUnderflowException with a custom message.
     * @param modifiedMessage The custom message to be displayed.
     */
    public StackUnderflowException(String modifiedMessage) {
        super(modifiedMessage);
    }
}
