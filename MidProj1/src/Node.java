public class Node<T> {
    // Reference to the next node in the linked list
    Node<T> next;

    // Data stored in the node
    T data;

    // Default constructor initializes next to null and data to null
    public Node() {
        setNext(null);
        setData(null);
    } // end of default constructor

    // Constructor initializes next to null and data to the given value
    public Node(T data) {
        setNext(null);
        setData(data);
    } // end of constructor

    // Getter method for retrieving the next node in the linked list
    public Node<T> getNext() {
        return next;
    }

    // Getter method for retrieving the data stored in the node
    public T getData() {
        return data;
    }

    // Setter method for updating the reference to the next node
    public void setNext(Node<T> node) {
        next = node;
    }

    // Setter method for updating the data stored in the node
    public void setData(T data) {
        this.data = data;
    }
} // end of Node class
