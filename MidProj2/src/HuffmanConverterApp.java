import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HuffmanConverterApp {
    private JFrame frame;
    private JPanel mainPanel;
    private JButton huffmanToTextButton;
    private JButton textToHuffmanButton;
    private JButton exitButton;

    public HuffmanConverterApp() {
        frame = new JFrame("Huffman Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        huffmanToTextButton = new JButton("Huffman to Text Converter");
        textToHuffmanButton = new JButton("Text to Huffman Converter");
        exitButton = new JButton("Exit");

        mainPanel.add(huffmanToTextButton);
        mainPanel.add(textToHuffmanButton);
        mainPanel.add(exitButton);

        frame.add(mainPanel, BorderLayout.CENTER);

        huffmanToTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayHuffmanToTextConverter();
            }
        });

        textToHuffmanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayTextToHuffmanConverter();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    private void displayHuffmanToTextConverter() {
        JFrame huffmanToTextFrame = new JFrame("Huffman to Text Converter");
        huffmanToTextFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        huffmanToTextFrame.setSize(400, 150);
        huffmanToTextFrame.setLayout(new BorderLayout());

        JPanel huffmanToTextPanel = new JPanel();
        huffmanToTextPanel.setLayout(new GridLayout(2, 1));

        JTextField huffmanCodeInput = new JTextField();
        JButton convertButton = new JButton("Convert");

        huffmanToTextPanel.add(huffmanCodeInput);
        huffmanToTextPanel.add(convertButton);

        huffmanToTextFrame.add(huffmanToTextPanel, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String huffmanCode = huffmanCodeInput.getText();
                String decodedText = decodeHuffman(huffmanCode);
                JOptionPane.showMessageDialog(huffmanToTextFrame, "Decoded Text: " + decodedText);
            }
        });

        huffmanToTextFrame.setVisible(true);
    }

    private void displayTextToHuffmanConverter() {
        JFrame textToHuffmanFrame = new JFrame("Text to Huffman Converter");
        textToHuffmanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        textToHuffmanFrame.setSize(400, 200); // Increased the frame height
        textToHuffmanFrame.setLayout(new BorderLayout());

        JPanel textToHuffmanPanel = new JPanel();
        textToHuffmanPanel.setLayout(new GridLayout(3, 1)); // Added one more row

        JTextField textInput = new JTextField();
        JButton convertButton = new JButton("Convert");
        JButton checkHuffmanButton = new JButton("Check Huffman Representation"); // New button

        textToHuffmanPanel.add(textInput);
        textToHuffmanPanel.add(convertButton);
        textToHuffmanPanel.add(checkHuffmanButton); // Added the new button

        textToHuffmanFrame.add(textToHuffmanPanel, BorderLayout.CENTER);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textInput.getText();
                String huffmanCode = encodeHuffman(text);
                JOptionPane.showMessageDialog(textToHuffmanFrame, "Huffman Code: " + huffmanCode);
            }
        });

        checkHuffmanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your logic to check the Huffman tree representation here
                JOptionPane.showMessageDialog(textToHuffmanFrame, "Checking Huffman Tree Representation...");
            }
        });

        textToHuffmanFrame.setVisible(true);
    }

    // Huffman encoding function
    private String encodeHuffman(String text) {
        // Add Huffman encoding logic here
        // build a Huffman tree and generate the Huffman codes for the characters in the input text.
        return "Encoded Huffman Code"; // Replace with actual code
    }

    // Huffman decoding function
    private String decodeHuffman(String huffmanCode) {
        // Add Huffman decoding logic here
        // use the Huffman tree to decode the Huffman code back to the original text.
        return "Decoded Text"; // Replace with actual code
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HuffmanConverterApp();
            }
        });
    }
}