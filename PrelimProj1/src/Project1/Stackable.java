package Project1;

public interface Stackable<T> {
    int size();
    void push(T element);
    T pop() throws StackUnderflowException;
    T peek() throws StackUnderflowException;
    boolean isEmpty();
    String stackToString(String delimiter) throws StackUnderflowException;

}