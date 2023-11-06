// Main class of the proj2
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HuffmanTest huffmanTest = new HuffmanTest();

        System.out.println("Welcome to Huffman Coding Scheme.");
        System.out.println("Choose an option:");
        System.out.println("1. Huffman to Text");
        System.out.println("2. Text to Huffman");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        switch (choice) {
            case 1:
                // Huffman to Text
                System.out.println("Enter a Huffman Code:");
                String user_input_code = scanner.nextLine();
                //System.out.println("Text: " + huffmanTest.decodeHuffmanCode(user_input_code));
                break;
            case 2:
                // Text to Huffman
                System.out.println("Enter a text:");
                String user_input_string = scanner.nextLine();
                //huffmanTest.runHuffmanEncoding(user_input_string);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
        }
    }
}

