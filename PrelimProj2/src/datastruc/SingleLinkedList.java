/**
 * September 15 | 20, 2023
 */
package datastruc;

public class SingleLinkedList <T> implements List {

    /**
     * Fields
     * September 20, 2023
     */
    private SingleNode <T> head;
    private SingleNode <T> tail;

    /**
     * Default constructor
     * September 20, 2023
     */
    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Parameterized Constructor
     * September 20, 2023
     */
    public SingleLinkedList(T data) {
        SingleNode<T> newNode = new SingleNode<>(data);
        head = newNode;
        tail = newNode;
    }

    /**
     * September 20, 2023
     */
    @Override
    public void add() {

    }

    /**
     * Adds an element at a specific index
     * September 20, 2023
     */
    @Override
    public void insert(Object element, int index) {

    }

    /**
     * Deletes an element at a specific index
     * September 20, 2023
     */
    @Override
    public void deleteAt(int index) {

    }

    /**
     * September 20, 2023
     */
    @Override
    public void deleteAtHead() {

    }

    /**
     * September 20, 2023
     */
    @Override
    public void deleteAtTail() {

    }


    /**
     * September 20, 2023
     */
    @Override
    public void clear() {

    }

    /**
     * September 20, 2023
     */
    @Override
    public boolean contains() {
        return false;
    }

    /**
     * September 20, 2023
     */
    @Override
    public int size() {
        return 0;
    }
}//End of class
