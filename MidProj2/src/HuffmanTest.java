import java.util.*;

public class HuffmanTest implements Runnable {
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
    HashMap<Character, Integer> characters_no_bits = new HashMap<>();
    HashMap<Character, String> characters_huffman_code = new HashMap<>();
    String huffmanCode = "";
    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);

    private boolean isFirstRun = true;

    public void huffmanCode(TreeNode root, String s) {
        if (root.getLeft() == null && root.getRight() == null) {
            System.out.println(root.getSymbol() + " | " + s + " | " + s.length());
            characters_no_bits.put(root.getSymbol(), s.length());
            characters_huffman_code.put(root.getSymbol(), s);
            huffmanCode += s;
            return;
        }

        huffmanCode(root.getLeft(), s + "0");
        huffmanCode(root.getRight(), s + "1");
    }

    public static void main(String[] args) {
        try {
            HuffmanTest obj = new HuffmanTest();
            obj.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createTreeSkeleton(LinkedList<CustomNode> letter_frequency, PriorityQueue<TreeNode> huffmanTree) {
        for (CustomNode customNode : letter_frequency) {
            TreeNode huffmanNode = new TreeNode();

            huffmanNode.setSymbol(customNode.getCharac().charAt(0));
            huffmanNode.setCount(customNode.getFrequency());
            huffmanNode.setLeft(null);
            huffmanNode.setRight(null);

            huffmanTree.add(huffmanNode);
        }
    }

    public void createTable(TreeNode root, String edge) {
        if (root == null)
            return;

        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getSymbol())) {
            System.out.println(root.getSymbol() + " | " + edge);
            return;
        }

        huffmanCode(root.getLeft(), edge + "0");
        huffmanCode(root.getRight(), edge + "1");
    }

    @Override
    public void run() {
        while (true) {
            if (isFirstRun) {
                System.out.println("Welcome to Huffman Coding Scheme.");
                isFirstRun = false;
            }

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

                System.out.println(" Character | Huffman code | Number of Bits");
                System.out.println("---------------------");
                huffmanCode(root, "");
                memorySave(letter_frequency);
                huffmanTreeSkeleton();

                while (true) {
                    String user_input_code = promptMessage2();
                    System.out.println(huffmanCode);

                    if (user_input_code == null) {
                        System.exit(0);
                    } else if (user_input_code.matches("^[0-9]+$")) {
                        String s = "";
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
                                    user_input_code = user_input_code.substring(character_code.length());
                                    s += customNode.getCharac();
                                }
                                i++;
                            }
                        }

                        System.out.println(s);
                        break;  // Exit the loop if everything is successful
                    } else {
                        System.out.println("ERROR: Invalid input. Please enter a valid code.");
                    }
                }
                break;  // Exit the outer loop if everything is successful
            } else {
                System.out.println("ERROR: Invalid input. Please enter a valid string.");
            }
        }
    }

    public String promptMessage1() {
        try {
            System.out.print("Input a String: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String promptMessage2() {
        try {
            System.out.print("Input a Code: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void huffmanTreeSkeleton() {
        // TODO: Implement huffmanTreeSkeleton method
    }

    private void memorySave(LinkedList<CustomNode> letter_frequency) {
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
