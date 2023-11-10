import java.io.IOException;
import java.util.*;
import java.lang.Runnable;

public class HuffmanGenerator implements Runnable {
    PriorityQueue<TreeNode> huffmanTree = new PriorityQueue<>();
    HashMap<Character, Integer> characters_no_bits = new HashMap<>();
    HashMap<Character, String> characters_huffman_code = new HashMap<>();
    String text_to_huffman = "";
    StringProcessor processor = new StringProcessor();
    Scanner kyb = new Scanner(System.in);
    LinkedList<CustomNode> letter_frequency = null;


    /**
     * This method recursively generates Huffman codes for characters in a Huffman tree.
     */
    public void huffmanCode (TreeNode root, String s,StringBuilder output){
        if (root.getLeft() == null && root.getRight() == null && (Character.isLetter(root.symbol) || String.valueOf(root.getSymbol()).equals("\s"))) {
            System.out.println(root.getSymbol() + " | " + s + " | " + s.length());
            output.append(root.getSymbol() + " | " + s + " | " + s.length()+"\n");
            characters_no_bits.put(root.getSymbol(), s.length());
            characters_huffman_code.put(root.getSymbol(), s);
            return;
        }
                huffmanCode(root.getLeft(), s + "0",output);
                huffmanCode(root.getRight(), s + "1",output);

    }//end of huffmanCode

    // Main method
    public static void main (String[]args){
        try {
            HuffmanGenerator obj = new HuffmanGenerator();
            obj.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of main

    /**
     * This method populates a priority queue with initial nodes for a Huffman tree based on letter frequencies.
     */
    private static void createTreeSkeleton(LinkedList < CustomNode > letter_frequency, PriorityQueue < TreeNode > huffmanTree){
        for (CustomNode customNode : letter_frequency) {
            TreeNode huffmanNode = new TreeNode();

            if(customNode.getCharac().equals("space")){
                huffmanNode.setSymbol(' ');
            }
            huffmanNode.setSymbol(customNode.getCharac().charAt(0));
            huffmanNode.setCount(customNode.getFrequency());
            huffmanNode.setLeft(null);
            huffmanNode.setRight(null);

            huffmanTree.add(huffmanNode);
        }
    }//end of createTreeSkeleton



    // Run method to execute the Huffman coding program
    @Override
    public void run () {
        String user_input_string = promptMessage1();

        generateHuffmanCode(user_input_string);

        String user_input_code = promptMessage2();

        huffmanToText(user_input_code, letter_frequency, user_input_string);
    }//end of run

    public String generateHuffmanCode(String textToConvert){
        StringBuilder huffmanCodeString = new StringBuilder();


        if (textToConvert == null) {
            System.exit(0);
        } else if (textToConvert.matches("(?i)^[a-z .?‘!,']+$")) {
            letter_frequency = processor.getFrequency(textToConvert);
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
            huffmanCode(root, "",huffmanCodeString);
            memorySave(letter_frequency);
            text_to_huffman = text_to_huffman(textToConvert);
            System.out.println("Text to Huffman code representation: " + text_to_huffman);
            //ExecutePythonScript.run();
        } else {
            System.out.println("ERROR");
            System.exit(0);
        }

        return huffmanCodeString.toString();
    }//end of generateHuffmancode

    /**
     * This method HUffman-codes a given text and returns the result.
     * It iterates through characters, appends their Huffman codes,
     * and stops when the character frequency list is empty.
     */
    private String text_to_huffman(String textToConvert) {
        String convertedText = "";
        int i = 0;
        while (!letter_frequency.isEmpty()) {
            if (letter_frequency.size() - 1 < i) {
                break;
            }

            CustomNode customNode = letter_frequency.get(i);

            for (int j = 0; j < textToConvert.length(); j++) {
                if (customNode.getCharac().charAt(0) == textToConvert.charAt(j)) {
                    convertedText += characters_huffman_code.get(customNode.getCharac().charAt(0));
                    break;
                }
            }

            i++;
        }
        return convertedText;
    }//end of text_to_huffman

    /**
     * This method decodes a Huffman binary string, using a character frequency list and the original string.
     */
    public String huffmanToText(String huffmanBinary, LinkedList<CustomNode> letter_frequency, String originalStringGiven){
        String convertedText = "";

        if (huffmanBinary.matches("^[0-9]+$")) {
            int i = 0;

            while (!letter_frequency.isEmpty()) {
                if (i > letter_frequency.size() - 1) {
                    i = 0;
                } else {
                    CustomNode customNode = letter_frequency.get(i);
                    String character_code = String.valueOf(characters_huffman_code.get(customNode.getCharac().charAt(0)));
                    if (huffmanBinary.isEmpty())
                        break;
                    if (huffmanBinary.contains(character_code) && huffmanBinary.startsWith(character_code)) {

                        for (int j = 0; j < originalStringGiven.length(); j++) {
                            if (customNode.getCharac().charAt(0) == originalStringGiven.charAt(j)) {
                                huffmanBinary = huffmanBinary.substring(character_code.length());
                                convertedText += customNode.getCharac();
                                break;
                            }
                        }
                    }
                    i++;
                }
            }
            System.out.println("Huffman code to Text representation: " + convertedText);

        } else {
            System.out.println("ERROR: Invalid input. Please enter a valid string.");
        }


        return convertedText;
    }//end of huffmanToText

    /**
     * Prompt user to input a string
     */
    public String promptMessage1 () {
        try {
            System.out.println("Input a string: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//end of promptMessage1

    /**
     * Prompt user to input a code
     */
    private String promptMessage2 () {
        try {
            System.out.print("Input a Code: ");
            return kyb.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }//end of promptMessage2

    /**
     * This method computes the storage savings percentage achieved
     * by Huffman coding over ASCII encoding for a given character frequency list.
     */
    public String memorySave (LinkedList < CustomNode > letter_frequency) {
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
        return"Percentage of storage savings: "+storagePercentage;
    }//end of memorySave
}//end of class
