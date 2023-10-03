/**
 * September 15 | 20 | 27, 2023
 */
package datastruc;

/**
 * A generic doubly linked list implementation.
 * This class provides methods for adding, deleting, and managing elements in a doubly linked list.
 *
 * @param <T> The type of elements stored in the linked list.
 */
public class DoubleLinkedList<T> implements List {


    /**
     * Fields
     * September 20, 2023
     */
    private DoubleNode <T> head;
    private DoubleNode <T> tail;
    private int size = 0;

    /**
     * Default constructor
     * Initializes an empty doubly linked list.
     * September 20, 2023
     
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Parameterized Constructor
     * Initializes a doubly linked list with a single element.
     *
     * @param data The data to initialize the list with.
     * September 20, 2023
     */
    public DoubleLinkedList (T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        this.head = head;
        this.tail =tail;
    }

    /**
     * Method that adds an element
     * September 20 | 28, 2023
     * @param data The data to be added to the list.
     */
    @Override
    public void add(Object data) {
        DoubleNode<T> newNode = new DoubleNode(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.setLink(newNode);
            newNode.setLeftLink(tail);
            tail = newNode;
        }


    }

    /**
     * Method that deletes an element at a specific index
     * September 20 | 28, 2023
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
            if (head != null) {
                head.setLeftLink(null);
            }
        } else if (index == size - 1) {
            tail = tail.getLeftLink();
            tail.setLink(null);
        } else {
            DoubleNode<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getLink();
            }
            current.getLeftLink().setLink(current.getLink());
            current.getLink().setLeftLink(current.getLeftLink());
        }
        size--;
    }

    /**
     * Method that deletes an element at the head
     * September 20 | 23, 2023
     *
     * @param index The index of the element to be deleted.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @Override
    public void deleteAtHead() {
        if (head != null) {
            head = head.getLink();
            if (head != null) {
                head.setLeftLink(null);
            } else {
                tail = null;
            }
            size--;
        }
    }

    /**
     * Method that deletes an element at the tail
     * September 20 | 28, 2023
     */
    @Override
    public void deleteAtTail() {
        if (tail != null) {
            tail = tail.getLeftLink();
            if (tail != null) {
                tail.setLink(null);
            } else {
                head = null;
            }
            size--;
        }
    }

    /**
     * Method that deletes the whole of the list
     * September 20 | 28, 2023
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Method that returns size of the linked list
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Method for checking if specified element is within list
     * September 20 | 27, 2023
     * @param data The element to check for existence.
     * @return True if the element exists in the list; otherwise, false.
     */
    @Override
    public boolean contains(Object data) {
        DoubleNode<T> current = head;
        while (current != null){
            if (current.getData().equals(data)){
                return true;
            }
        }
        return false;
    }

}//end of class
