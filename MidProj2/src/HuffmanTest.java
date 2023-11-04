
import java.util.*;

public class HuffmanTest implements Runnable{
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
    HashMap<Character, Integer> characters_no_bits = new HashMap<>();
    HashMap<Character, String> characters_huffman_code = new HashMap<>();
    String huffmanCode = "";
    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);

    /**
     *
     * @param root
     * @param s
     */
    public void huffmanCode(TreeNode root, String s){
        if (root.getLeft() == null && root.getRight() == null){
            System.out.println(root.getSymbol() + " | " + s + " | " + s.length());
            characters_no_bits.put(root.getSymbol(), s.length());
            characters_huffman_code.put(root.getSymbol(), s);
            huffmanCode += s;
            return;
        }


        huffmanCode(root.getLeft(), s + "0");
        huffmanCode(root.getRight(), s + "1");

    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            HuffmanTest obj = new HuffmanTest();
            obj.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String promptMessage() {
        try {
            System.out.println("Input a text: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void createTree(LinkedList<CustomNode> letter_frequency, PriorityQueue<TreeNode> huffmanTree ) {
        // arrange each node in huffman tree
        for (CustomNode customNode : letter_frequency) {
            TreeNode huffmanNode = new TreeNode();

            huffmanNode.setSymbol(customNode.getCharac().charAt(0));
            huffmanNode.setCount(customNode.getFrequency());
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

    @Override
    public void run() {
        String user_input = promptMessage();
        Character[] set = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','.','?','’','!',','};
//        if (user_input.matches()) // # TODO: create a regex that satisfies the requirement
        LinkedList<CustomNode> letter_frequency = processor.getFrequency(user_input);
        createTree(letter_frequency, huffmanTree);

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
        System.out.println(" Char | Huffman code ");
        System.out.println("---------------------");
        printCode(root, "");
    }
}
