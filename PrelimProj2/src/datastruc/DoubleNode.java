/**
 * September 15 | 20, 2023
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
     */
    public DoubleNode (){
        this(null);
    }

    /**
     * Parameterized Constructor
     */
    public DoubleNode (T data){
        this.data = data;
    }

    /**
     * Getters
     */
    public T getData() {
        return data;
    }
    public DoubleNode<T> getLink() {
        return link;
    }
    public DoubleNode<T> getLeftLink() {
        return leftLink;
    }

    /**
     * Setters
     */
    public void setData(T data) {
        this.data = data;
    }
    public void setLink(DoubleNode<T> link) {
        this.link = link;
    }
    public void setLeftLink(DoubleNode<T> leftLink) {
        this.leftLink = leftLink;
    }

}//End of class
