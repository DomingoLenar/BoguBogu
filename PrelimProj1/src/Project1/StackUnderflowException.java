package Project1;

public class StackUnderflowException extends Exception {
    public StackUnderflowException() {
        super("Stack is empty");
    }

    public StackUnderflowException(String modifiedMessage) {
        super(modifiedMessage);
    }
}