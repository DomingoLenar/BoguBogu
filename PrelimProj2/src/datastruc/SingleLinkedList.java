/**
 * A singly linked list implementation.
 * 
 * This class represents a singly linked list with common operations for adding,
 * deleting, and managing elements. It also provides methods for checking the
 * existence of an element and accessing the size of the list.
 *
 * @param <T> The type of elements stored in the linked list.
 * @since September 15 | 20 | 27, 2023
 */
package datastruc;

public class SingleLinkedList<T> implements List<T> {

    /**
     * Fields
     * September 20, 2023
     */
    private SingleNode<T> head;
    private SingleNode<T> tail;

    private int size;

    /**
     * Default constructor
     * Initializes an empty singly linked list.
     * September 20, 2023
     */
    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Parameterized Constructor
     * Initializes a singly linked list with a single element.
     *
     * @param data The data to initialize the list with.
     * September 20, 2023
     */
    public SingleLinkedList(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
        head = newNode;
        tail = newNode;
    }

    /**
     * Method to add an element to the end of the list.
     * September 20, 2023
     *
     * @param data The data to be added to the list.
     */
    @Override
    public void add(Object data) {
        SingleNode newNode = new SingleNode(data);
        if (this.head == null) {
            head = newNode;
            tail = head;
            size++;
        } else {
            tail.setLink(newNode);
            tail = newNode;
            size++;
        }
    }

    public void addAtHead(T data){
        SingleNode<T> newNode = new SingleNode<>(data);
        if(head == null){
            head = newNode;
            tail = head;
            size++;
        }{
            newNode.setLink(head);
            head = newNode;
            size++;
        }
    }

    /**
     * Method to delete an element at a specific index.
     * September 20, 2023
     *
     * @param index The index of the element to be deleted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void deleteAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }

        if (index == 0) {
            head = head.getLink();
            size--;

            if (size == 0) {
                tail = null;
            }
        } else {
            SingleNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getLink();
            }
            current.setLink(current.getLink().getLink());

            if (index == size - 1) {
                tail = current;
            }
            size--;
        }
    }

    /**
     * Method to delete an element at the head
     * September 20, 2023
     */
    @Override
    public void deleteAtHead() {
        if (head != null){
            head.getLink();
            size--;
        }
        if (head == null){
            tail = null;
        }
    }

    /**
     * Method to delete an element at the tail
     * September 20, 2023
     */
    @Override
    public void deleteAtTail() {
        if (head == null){
            return;
        }
        if (head.getLink() == null){
            head = null;
            tail = null;
            size--;
            return;
        }

        SingleNode<T> current = head;
        while (current.getLink().getLink() != null){
            current = current.getLink();
        }
        current.setLink(null);
        tail = current;
        size--;
    }


    /**
     * Method to clear the current list
     * September 20, 2023
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Method to return the size (number of elements) of the linked list.
     * September 27, 2023
     *
     * @return The size of the linked list.
     */
    @Override
    public int getSize(){
        return this.size;
    }

    /**
     * Method to check if a specified element exists within the list.
     * September 20, 2023
     *
     * @param data The element to check for existence.
     * @return True if the element exists in the list; otherwise, false.
     */
    @Override
    public boolean contains(Object T) {
        SingleNode<T> current = head;
        while (current != null) {
            if (current.getData().equals(T)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method to retrieve the head node of the linked list.
     *
     * @return The head node of the linked list.
     */
    public SingleNode<T> getHead(){
        return head;
    }
}//end of class
