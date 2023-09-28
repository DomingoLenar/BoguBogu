/**
 * September 15 | 20, 2023
 */
package datastruc;

public class SingleNode <T> {

    /**
     * Fields
     */
    private T data;
    private SingleNode <T> link;

    /**
     * Default constructor
     */
    public SingleNode (){
        this(null);
    }

    /**
     * Parameterized Constructor
     */
    SingleNode (T data) {
        this.data = data;
    }

    /**
     * Getters
     */
    public T getData() {
        return data;
    }
    public SingleNode<T> getLink() {
        return link;
    }

    /**
     * Setters
     */
    public void setData(T data) {
        this.data = data;
    }
    public void setLink(SingleNode<T> link) {
        this.link = link;
    }

}//end of class
