/**
 * A generic singly linked list node class.
 *
 * This class represents a node containing data and a link to the next node in a singly linked list.
 *
 * @param <T> The type of data stored in the node.
 * @since September 15 | 20, 2023
 */
package datastruc;

public class SingleNode<T> {

    /**
     * Fields
     */
    private T data;
    private SingleNode<T> link;

    /**
     * Default constructor
     * Initializes a new `SingleNode` with no data.
     */
    public SingleNode (){
        this(null);
    }

    /**
     * Parameterized Constructor
     * Initializes a new `SingleNode` with the specified data.
     *
     * @param data The data to be stored in the node.
     */

    SingleNode (T data) {
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
    public SingleNode<T> getLink() {
        return link;
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
    public void setLink(SingleNode<T> link) {
        this.link = link;
    }

}//end of class
