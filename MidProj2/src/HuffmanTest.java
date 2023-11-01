
import java.util.*;

// TODO: consider all possible characters in a given set {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,space,.,?,’,!,,}
public class HuffmanTest implements Runnable{
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();

    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);

    /**
     *
     * @param root
     * @param s
     */
    public static void printCode(TreeNode root, String s){
        if (root.getLeft() == null && root.getRight() == null){
            System.out.println(root.getSymbol() + " | " + s);
            return;
        }


        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] symbolArray = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int[] symbolFrequency = {30, 12, 13, 20, 45, 2, 2, 7};

        PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();

        createTree(symbolArray, symbolFrequency, huffmanTree);

        TreeNode root = null;

        while (huffmanTree.size() > 1) { // construct the complete binary tree (huffman tree) to obtain huffman coding scheme
            TreeNode t = huffmanTree.peek();
            huffmanTree.poll();

            TreeNode u = huffmanTree.peek();
            huffmanTree.poll();

            TreeNode v = new TreeNode();
            v.setCount(t.getCount() + u.getCount());
            v.setSymbol('-');
            v.setLeft(t);
            v.setRight(u);
            root = v;

            huffmanTree.add(v);
        }
        System.out.println(" Char }| Huffman code ");
        System.out.println("---------------------");
        printCode(root, "");

    private String promptMessage() {
        try {
            System.out.println("Input a text: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createTree(char[] symbolArray, int[] symbolFrequency, PriorityQueue<TreeNode> huffmanTree ) {
        // arrange each node in huffman tree
        for (int i = 0; i < symbolArray.length; i++){
            TreeNode huffmanNode = new TreeNode();

            huffmanNode.setSymbol(symbolArray[i]);
            huffmanNode.setCount(symbolFrequency[i]);
            huffmanNode.setLeft(null);
            huffmanNode.setRight(null);

            huffmanTree.add(huffmanNode);
        }
    }

    public void createTable(TreeNode root, String edge){
        // TODO: display the table using hashmap another data structure
        if (root == null) // empty tree
            return;

        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getSymbol())){
            System.out.println(root.getSymbol() + " | " + edge);
            return;

        }

        printCode(root.getLeft(), edge + "0");
        printCode(root.getRight(), edge + "1");
    }
}
