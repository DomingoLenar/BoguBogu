

import java.util.*;

public class HuffmanTest implements Runnable{
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
    HashMap<Character, Integer> characters_no_bits = new HashMap<>();
    HashMap<Character, String> characters_huffman_code = new HashMap<>();
    String text_to_huffman = "";
    TreeNode root = null;

    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);

    /**
     *
     * @param root
     * @param s
     */
    public void huffmanCode(TreeNode root, String s){
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.symbol)){
            System.out.println(root.getSymbol() + " | " + s + " | " + s.length());
            characters_no_bits.put(root.getSymbol(), s.length());
            characters_huffman_code.put(root.getSymbol(), s);
            text_to_huffman += s;
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

    private static void createTreeSkeleton(LinkedList<CustomNode> letter_frequency, PriorityQueue<TreeNode> huffmanTree ) {
        // attach each node in huffman tree
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

        huffmanCode(root.getLeft(), edge + "0");
        huffmanCode(root.getRight(), edge + "1");
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
            //ExecutePythonScript.run();
        } else {
            // #TODO: add prompt message
            System.out.println("ERROR");
            System.exit(0);
        }

        String user_input_code = promptMessage2();
        System.out.println(text_to_huffman);

        if (user_input_code == null)
            System.exit(0);
            // #TODO: add prompt message
        else if (user_input_code.matches("^[0-9]+$")) {
//            String letter_huffman_code = "";
//            letter_huffman_code = huffmanCode_text_representation(letter_huffman_code, user_input_code, root);

            String huffman_to_text = "";
            int i = 0;

            while (!letter_frequency.isEmpty()) {
                if ( i > letter_frequency.size() - 1) {
                    i = 0;
                } else {
                    CustomNode customNode = letter_frequency.get(i);
                    String character_code = characters_huffman_code.get(customNode.getCharac().charAt(0));
                    if (user_input_code.isEmpty())
                        break;

                    if (user_input_code.contains(character_code) && user_input_code.startsWith(character_code)) {

                        for (int j = 0; j < user_input_string.length(); j++) {
                            if ( customNode.getCharac().charAt(0) == user_input_string.charAt(j)) {
                                user_input_code = user_input_code.substring(character_code.length());
                                huffman_to_text += customNode.getCharac();
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
            System.out.println(huffman_to_text);

//// 000100101
//// HAAHAABAAACACAAAABABABEBEBBAABEEBBCCCCCAAAAAAACCCDDDDDDAAADDDDDEEEEEEDDADDDADDEEEEEEEECCCEEEEEEEEEEDDEEEEEEEEEEBBEEEEEFFGGHAHHEEHHA
        }
        else {
            // #TODO: add prompt message
            System.out.println("ERROR");
            System.exit(0);
        }

    }

//    private String huffmanCode_text_representation(String letterHuffmanCode, String user_input_code, TreeNode root) {
//
//            if (root.getLeft() == null && root.getRight() == null) {
//                letterHuffmanCode += characters_huffman_code.get(root.getSymbol());
//
//                if (letterHuffmanCode.startsWith(user_input_code)) {
//                    user_input_code = user_input_code.substring(letterHuffmanCode.length() - 1);
//                }
//        }
//            huffmanCode_text_representation(letterHuffmanCode, user_input_code, root.getLeft());
//            huffmanCode_text_representation(letterHuffmanCode, user_input_code, root.getRight());
//
//            return letterHuffmanCode;
//    }

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
            huffman_bits += tNode.getFrequency() * characters_no_bits.get(tNode.getCharac().charAt(0));
            ASCII_bits += tNode.getFrequency();
        }

        ASCII_bits = ASCII_bits * 7;

        storagePercentage = ((ASCII_bits - huffman_bits)/ASCII_bits) * 100;
        System.out.println("Percentage of storage savings: " + storagePercentage);
    }

}
