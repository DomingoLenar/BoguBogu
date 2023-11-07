import java.io.IOException;
import java.util.*;
import java.lang.Runnable;

public class HuffmanTest implements Runnable {
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
    HashMap<Character, Integer> characters_no_bits = new HashMap<>();
    HashMap<Character, String> characters_huffman_code = new HashMap<>();
    String text_to_huffman = "";
    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);

    // Method to generate Huffman codes for each leaf node in the Huffman tree
    public void huffmanCode (TreeNode root, String s){
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.symbol)) {
            System.out.println(root.getSymbol() + " | " + s + " | " + s.length());
            characters_no_bits.put(root.getSymbol(), s.length());
            characters_huffman_code.put(root.getSymbol(), s);
            text_to_huffman += s;
            return;
        }
                huffmanCode(root.getLeft(), s + "0");
                huffmanCode(root.getRight(), s + "1");

    }

    // Main method
    public static void main (String[]args){
        try {
            HuffmanTest obj = new HuffmanTest();
            obj.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to create the initial tree structure from letter frequencies
    private static void createTreeSkeleton(LinkedList < CustomNode > letter_frequency, PriorityQueue < TreeNode > huffmanTree){
        for (CustomNode customNode : letter_frequency) {
            TreeNode huffmanNode = new TreeNode();

            huffmanNode.setSymbol(customNode.getCharac().charAt(0));
            huffmanNode.setCount(customNode.getFrequency());
            huffmanNode.setLeft(null);
            huffmanNode.setRight(null);

            huffmanTree.add(huffmanNode);
        }
    }

    // Method to display the Huffman code table
    public void createTable (TreeNode root, String edge){
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getSymbol())) {
            System.out.println(root.getSymbol() + " | " + edge);
            return;

        }

        huffmanCode(root.getLeft(), edge + "0");
        huffmanCode(root.getRight(), edge + "1");
    }

    // Run method to execute the Huffman coding program
    @Override
    public void run () {
        String user_input_string = promptMessage1();
        LinkedList<CustomNode> letter_frequency = null;

        if (user_input_string == null) {
            System.exit(0);
        } else if (user_input_string.matches("^[a-z .?‘!,']+$")) {
            letter_frequency = processor.getFrequency(user_input_string);
            createTreeSkeleton(letter_frequency, huffmanTree);

            TreeNode root = null;

            while (huffmanTree.size() > 1) {
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
            try {
                GenerateDiagram diagramGenerator = new GenerateDiagram();
                diagramGenerator.run(huffmanTree.peek());
            }catch(IOException iE){
                iE.printStackTrace();
            }
            System.out.println(" Character | Huffman code | Number of Bits");
            System.out.println("---------------------");
            huffmanCode(root, "");
            memorySave(letter_frequency);
            System.out.println("Text to Huffman code representation: " + text_to_huffman);
            //ExecutePythonScript.run();
        } else {
            System.out.println("ERROR");
            System.exit(0);
        }

        String user_input_code = promptMessage2();

        if (user_input_code == null)
            System.exit(0);
        else if (user_input_code.matches("^[0-9]+$")) {
            String huffman_to_text = "";
            int i = 0;

            while (!letter_frequency.isEmpty()) {
                if (i > letter_frequency.size() - 1) {
                    i = 0;
                } else {
                    CustomNode customNode = letter_frequency.get(i);
                    String character_code = characters_huffman_code.get(customNode.getCharac().charAt(0));
                    if (user_input_code.isEmpty())
                        break;

                    if (user_input_code.contains(character_code) && user_input_code.startsWith(character_code)) {

                        for (int j = 0; j < user_input_string.length(); j++) {
                            if (customNode.getCharac().charAt(0) == user_input_string.charAt(j)) {
                                user_input_code = user_input_code.substring(character_code.length());
                                huffman_to_text += customNode.getCharac();
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
            System.out.println("Huffman code to Text representation: " + huffman_to_text);

        } else {
            System.out.println("ERROR: Invalid input. Please enter a valid string.");
        }
    }

    // Prompt user to input a string
    public String promptMessage1 () {
        try {
            System.out.println("Input a string: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Prompt user to input a code
    private String promptMessage2 () {
        try {
            System.out.print("Input a Code: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to calculate and display memory savings using Huffman coding
    private void memorySave (LinkedList < CustomNode > letter_frequency) {
        CustomNode tNode;
        double ASCII_bits = 0, huffman_bits = 0, storagePercentage = 0;
        for (int i = 0; i < letter_frequency.size(); i++) {
            tNode = letter_frequency.get(i);
            huffman_bits += tNode.getFrequency() * characters_no_bits.get(tNode.getCharac().charAt(0));
            ASCII_bits += tNode.getFrequency();
        }

        ASCII_bits = ASCII_bits * 7;

        storagePercentage = ((ASCII_bits - huffman_bits) / ASCII_bits) * 100;
        System.out.println("Percentage of storage savings: " + storagePercentage);
    }
}
