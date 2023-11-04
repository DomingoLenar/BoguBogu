
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
        String user_input_string = promptMessage1();
        LinkedList<CustomNode> letter_frequency = null;

        if (user_input_string == null){
            // #TODO: add prompt message
            System.exit(0);
        }
        else if (user_input_string.matches("^[a-z .?‘!,']+$")){ // determine whether the string only contain letters and other special characters
             letter_frequency = processor.getFrequency(user_input_string);
            createTreeSkeleton(letter_frequency, huffmanTree);

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
            System.out.println(" Character | Huffman code | Number of Bits");
            System.out.println("---------------------");
            huffmanCode(root, "");
            memorySave(letter_frequency);
            huffmanTreeSkeleton();
        } else {
            // #TODO: add prompt message
            System.out.println("ERROR");
            System.exit(0);
        }

        String user_input_code = promptMessage2();
        System.out.println(huffmanCode);

        if (user_input_code == null)
            System.exit(0);
            // #TODO: add prompt message
        else if (user_input_code.matches("^[0-9]+$")) {
            String s = "";
            int i = 0;
            while (!letter_frequency.isEmpty()) {
                if ( i > letter_frequency.size() - 1) {
                    i = 0;
                } else {
                    CustomNode customNode = letter_frequency.get(i);
                    String character_code = characters_huffman_code.get(customNode.getCharacter().charAt(0));

                    if (user_input_code.isEmpty())
                        break;

                    if (user_input_code.contains(character_code) && user_input_code.startsWith(character_code)) {
                        user_input_code = user_input_code.substring(character_code.length());
                        s += customNode.getCharacter();
                    }
                    i++;
                }
//                pattern = Pattern.compile(character_code);
//                matcher = pattern.matcher(user_input_code);
//
//                if (!matcher.find()) {
//                    System.out.println("ERROR");
//                } else {
//                    Matcher matcher1 = pattern.matcher(huffmanCode);
//                    while (matcher1.find()) {
//                        s = customNode.getCharacter();
//                    }
//                }

            }
// 000100101
// HAAHAABAAACACAAAABABABEBEBBAABEEBBCCCCCAAAAAAACCCDDDDDDAAADDDDDEEEEEEDDADDDADDEEEEEEEECCCEEEEEEEEEEDDEEEEEEEEEEBBEEEEEFFGGHAHHEEHHA

            System.out.println(s);
        } else {
            // #TODO: add prompt message
            System.out.println("ERROR");
            System.exit(0);
        }

    }
    public String promptMessage1() {
        try {
            System.out.println("Input a string: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private String promptMessage2() {
        try {
            System.out.println("Input a code: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void huffmanTreeSkeleton() {
    }

    private void memorySave(LinkedList<CustomNode> letter_frequency) {
        CustomNode tNode;
        double ASCII_bits = 0, huffman_bits = 0, storagePercentage = 0;
        for (int i = 0; i < letter_frequency.size(); i++){
            tNode = letter_frequency.get(i);
            huffman_bits += tNode.getFrequency() * characters_no_bits.get(tNode.getCharacter().charAt(0));
            ASCII_bits += tNode.getFrequency();
        }

        ASCII_bits = ASCII_bits * 7;

        storagePercentage = ((ASCII_bits - huffman_bits)/ASCII_bits) * 100;
        System.out.println("Percentage of storage savings: " + storagePercentage);
    }
}
