
public class TreeNode implements Comparable<TreeNode>{
    int count;
    char symbol;
    TreeNode left;
    TreeNode right;

    public TreeNode(){
        count = 0;
        symbol = 'x';
        left = null;
        right = null;
    }

    public TreeNode(int count, char symbol, TreeNode left, TreeNode right){
        this.count = count;
        this.symbol = symbol;
        this.left = left;
        this.right = right;
    }

    /**
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @param symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @param left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     *
     * @param right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     *
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @return the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     *
     * @return left node
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     *
     * @return right node
     */
    public TreeNode getRight() {
        return right;
    }

    /**
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
