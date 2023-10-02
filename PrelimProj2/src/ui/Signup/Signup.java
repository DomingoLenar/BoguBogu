package ui.Signup;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Signup {

    public static void main(String[] args) {
        // JFrame container
        JFrame frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel to hold the UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Header panel with GridBagLayout for precise control
        JPanel headerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints headerGbc = new GridBagConstraints();
        headerGbc.insets = new Insets(15, 0, 5, 0);
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // Title label to the header panel using GridBagConstraints
        headerGbc.gridx = 0;
        headerGbc.gridy = 0;
        headerPanel.add(titleLabel, headerGbc);

        // Body panel with GridBagLayout for precise control
        JPanel bodyPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 70, 10, 70);

        // Text fields for the email and password
        JTextField emailField = new JTextField("Email", 20);
        JTextField passwordField = new JTextField("Password", 20);
        emailField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        emailField.setHorizontalAlignment(JTextField.LEFT);
        passwordField.setHorizontalAlignment(JTextField.LEFT);
        emailField.setBackground(new Color(0x6dd47e));
        passwordField.setBackground(new Color(0x6dd47e));

        // FocusListeners to clear the text when clicked
        emailField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("Email")) {
                    emailField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setText("Email");
                }
            }
        });

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (passwordField.getText().equals("Password")) {
                    passwordField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getText().isEmpty()) {
                    passwordField.setText("Password");
                }
            }
        });

        // Label to set focus to initially
        JLabel initialFocusLabel = new JLabel();
        initialFocusLabel.setFocusable(true);
        initialFocusLabel.requestFocusInWindow();

        // Labels and text fields to the body panel using GridBagConstraints
        gbc.gridx = 0;
        gbc.gridy = 0;
        bodyPanel.add(initialFocusLabel, gbc); // Set initial focus to the label
        gbc.gridy = 1; // Move to the next row
        bodyPanel.add(emailField, gbc);
        gbc.gridy = 2; // Move to the next row
        bodyPanel.add(passwordField, gbc);

        // Footer panel
        JPanel footerPanel = new JPanel();
        JButton signUpButton = new JButton("Sign-Up");
        signUpButton.setBackground(new Color(0xffd55a));
        footerPanel.add(signUpButton);

        // Add the header, body, and footer panels to the main panel
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(bodyPanel, BorderLayout.CENTER);
        panel.add(footerPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel);

        // Pack the frame and make it visible
        frame.pack();
        frame.setVisible(true);

    }  // End of main method

}  // End of Signup class