/**
 * A generic doubly linked list node class.
 *
 * This class represents a node containing data and links to the next and previous nodes.
 *
 * @param <T> The type of data stored in the node.
 * @since September 15, 2023
 */
package datastruc;

public class DoubleNode <T>{

    /**
     * Fields
     */
    private T data;
    private DoubleNode <T> link;
    private DoubleNode <T> leftLink;

    /**
     * Default Constructor
     * Initializes a new DoubleNode with no data.
     */
    public DoubleNode (){
        this(null);
    }

    /**
     * Parameterized Constructor
     * Initializes a new DoubleNode with the specified data.
     *
     * @param data The data to be stored in the node.
     */
    public DoubleNode (T data){
        this.data = data;
    }

    /**
     * Retrieves the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public T getData() {
        return data;
    } 

    /**
     * Retrieves the link to the next node.
     *
     * @return The link to the next node.
     */
    public DoubleNode<T> getLink() {
        return link;
    } 

    /**
     * Retrieves the link to the previous node.
     *
     * @return The link to the previous node.
     */
    public DoubleNode<T> getLeftLink() {
        return leftLink;
    }

    /**
     * Sets the data to be stored in the node.
     *
     * @param data The data to be stored in the node.
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Sets the link to the next node.
     *
     * @param link The link to the next node.
     */
    public void setLink(DoubleNode<T> link) {
        this.link = link;
    }

    /**
     * Sets the link to the previous node.
     *
     * @param leftLink The link to the previous node.
     */
    public void setLeftLink(DoubleNode<T> leftLink) {
        this.leftLink = leftLink;
    }

}//end of class
