/**
 * Represents a node in a tree used for encoding and decoding symbols in Huffman coding.
 * Each node contains a count, symbol, left child, and right child.
 */
public class TreeNode implements Comparable<TreeNode>{
    int count; // Number of occurrences of the symbol represented by this node
    char symbol; // The symbol associated with this node
    TreeNode left; // Reference to the left child node
    TreeNode right; // Reference to the right child node

    /**
     * Default constructor initializes the node with zero count, placeholder symbol 'x', and null children.
     */
    public TreeNode(){
        count = 0;
        symbol = 'x';
        left = null;
        right = null;
    }

    /**
     * Parameterized constructor to create a TreeNode with specified count, symbol, left, and right children.
     *
     * @param count  The number of occurrences of the symbol.
     * @param symbol The symbol associated with this node.
     * @param left   Reference to the left child node.
     * @param right  Reference to the right child node.
     */
    public TreeNode(int count, char symbol, TreeNode left, TreeNode right){
        this.count = count;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    /**
     * Set the count of occurrences for the symbol represented by this node.
     *
     * @param count The number of occurrences.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Set the symbol associated with this node.
     *
     * @param symbol The symbol to be associated with this node.
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Set the left child node.
     *
     * @param left Reference to the left child node.
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Set the right child node.
     *
     * @param right Reference to the right child node.
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Get the count of occurrences for the symbol represented by this node.
     *
     * @return The number of occurrences.
     */
    public int getCount() {
        return count;
    }

    /**
     * Get the symbol associated with this node.
     *
     * @return the symbol.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get the left child node.
     *
     * @return Reference to the left child node.
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Get the right child node.
     *
     * @return Reference to the right child node.
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Get a string representation of the count and symbol of this node.
     *
     * @return A string containing the count and symbol.
     */
    public String getData(){
        return String.valueOf(count)+","+String.valueOf(symbol);
    }

    /**
     * Compare this node with another node based on their counts.
     *
     * @param o the object to be compared.
     * @return if node is less than another node
     */
    @Override
    public int compareTo(TreeNode o) {
        if (this.getCount() == o.getCount())
            return 0;
        else
        if (this.getCount() < o.getCount())
            return -1;
        else
            return 1;
    }
}
