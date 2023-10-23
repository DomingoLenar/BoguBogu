/**
 * An interface representing a generic stack.
 * @param <T> The type of elements stored in the stack.
 */
public interface Stackable<T> {

    /**
     * Returns the number of elements in the stack.
     * @return The size of the stack.
     */
    int size();

    /**
     * Adds an element to the top of the stack.
     * @param element The element to be added.
     */
    void push(T element);

    /**
     * Removes and returns the element from the top of the stack.
     * @return The element removed from the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    T pop() throws StackUnderflowException;

    /**
     * Returns the element from the top of the stack without removing it.
     * @return The element at the top of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    T peek() throws StackUnderflowException;

    /**
     * Checks if the stack is empty.
     * @return True if the stack is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Returns a string representation of the stack.
     * @param delimiter The delimiter to be used between stack elements.
     * @return A string representation of the stack.
     * @throws StackUnderflowException If the stack is empty.
     */
    String stackToString(String delimiter) throws StackUnderflowException;
}
