/**
 * Node class for binary tree implementation
 * November 16, 2023
 */
package Tree;

public class TNode {
    private int key;
    private TNode left, right;

    /*
    Default Constructor
     */
    public TNode(){
        key = 0;
        left = null;
        right = null;
    }

    /*
    Parameterized Constructor
     */
    public TNode(int key, TNode left, TNode right){
        this.key = key;
        this.left = left;
        this.right = right;
    }

    /*
    Setters
     */
    public void setKey(int key) {
        this.key = key;
    }
    public void setLeft(TNode left) {
        this.left = left;
    }

    public void setRight(TNode right) {
        this.right = right;
    }

    /*
    Getters
     */
    public int getKey() {
        return key;
    }
    public TNode getLeft() {
        return left;
    }
    public TNode getRight() {
        return right;
    }
}
