import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class ExpressionConverterUI extends JFrame {
    private JTextField inputField;
    private JTextArea outputArea;
    private InfixToPostfixConverter converter = new InfixToPostfixConverter();

    public ExpressionConverterUI() {
        setTitle("BoguBogu Expression Converter");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create a menu
        JMenu optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);

        // Create menu items
        JMenuItem convertToPostfixItem = new JMenuItem("Convert to Postfix");
        JMenuItem evaluatePostfixItem = new JMenuItem("Evaluate Postfix Expression");

        // Add menu items to the menu
        optionsMenu.add(convertToPostfixItem);
        optionsMenu.add(evaluatePostfixItem);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel inputLabel = new JLabel("Enter Infix Expression:");
        inputField = new JTextField(20);
        JButton performAction = new JButton("Convert to Postfix");
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        panel.add(inputLabel);
        panel.add(inputField);
        panel.add(performAction);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        convertToPostfixItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputLabel.setText("Enter Infix Expression:");
                performAction.setText("Convert to Postfix");
            }
        });

        evaluatePostfixItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String outputExp = outputArea.getText();
                if(!(outputExp.equals(null))){
                    inputField.setText(outputExp);
                    outputArea.setText("");
                }
                inputLabel.setText("Enter Postfix Expression:");
                performAction.setText("Evaluate Postfix Expression");
            }
        });

        performAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputExpression = inputField.getText();
                if (performAction.getText().equals("Convert to Postfix")) {
                    String postfixExpression = null;
                    try {
                        postfixExpression = converter.convert(inputExpression);
                    } catch (StackUnderflowException ex) {
                        throw new RuntimeException(ex);
                    }
                    outputArea.setText(postfixExpression);
                } else {
                    double result = evaluatePostfix(inputExpression);
                    outputArea.setText("Result: " + result);
                }
            }
        });
    }

    private double evaluatePostfix(String inputExpression) {
        return 0;
    }

    private String infixToPostfix(String inputExpression) {
        return inputExpression;
    }

    // Implement infixToPostfix and evaluatePostfix methods here

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExpressionConverterUI converter = new ExpressionConverterUI();
                converter.setVisible(true);
            }
        });
    }
}