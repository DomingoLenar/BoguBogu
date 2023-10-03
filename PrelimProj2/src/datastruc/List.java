/**
 * The `List` interface represents a generic list data structure with common operations.
 *
 * @param <T> The type of elements stored in the list.
 * @since September 20, 2023
 */
package datastruc;

    /**
     * Adds an element to the end of the list.
     *
     * @param data The data to be added to the list.
     */

public interface List<T>{
    void add(T data);
    
    /**
     * Deletes an element at the specified index in the list.
     *
     * @param index The index of the element to be deleted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    void deleteAt (int index);
    
    /**
     * Deletes the element at the head (beginning) of the list.
     */
    void deleteAtHead();
    
    /**
     * Deletes the element at the tail (end) of the list.
     */
    void deleteAtTail();//
    
    /**
     * Clears the entire content of the list, making it empty.
     */
    void clear();

    /**
     * Retrieves the size (number of elements) of the list.
     *
     * @return The size of the list.
     */
    int getSize();
    
    /**
     * Checks if the specified element exists within the list.
     *
     * @param data The element to check for existence.
     * @return True if the element exists in the list; otherwise, false.
     */
    boolean contains(T data);
}//end of interface
