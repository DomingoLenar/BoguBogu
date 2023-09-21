/**
 * September 15 | 20, 2023
 */
package datastruc;

public class DoubleLinkedList <T> implements List {

    /**
     * Fields
     * September 20, 2023
     */
    private DoubleNode <T> head;
    private DoubleNode <T> tail;

    /**
     * Default constructor
     * September 20, 2023
     */
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * Parameterized Constructor
     * September 20, 2023
     */
    public DoubleLinkedList (T data){
        DoubleNode<T> newNode = new DoubleNode<>(data);
        this.head = head;
        this.tail =tail;
    }

    /**
     * September 20, 2023
     */
    @Override
    public void add() {

    }

    /**
     * September 20, 2023
     */
    @Override
    public void insert(Object element, int index) {

    }

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
}
