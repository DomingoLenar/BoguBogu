package ui.Forgot;
import ui.TitleBar.TitleBar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Forgot extends TitleBar {

    public Forgot() throws IOException, FontFormatException {
        super(); // Call the constructor of the TitleBar class

        // Load the custom font
        Font customFont = loadCustomFont("PrelimProj2/src/font/JosefinSans-Regular.ttf");

        // Panel to hold the UI components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Header panel with GridBagLayout for precise control
        JPanel headerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints headerGbc = new GridBagConstraints();
        headerGbc.insets = new Insets(15, 0, 5, 0);

        // Logo
        JLabel imageLabel = new JLabel();
        try {
            BufferedImage image = ImageIO.read(new File("PrelimProj2/src/resources/icons/Bogu Mail 1.jpg"));
            Image resizedImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(resizedImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        headerGbc.gridx = 0;
        headerGbc.gridy = 0;
        headerPanel.add(imageLabel, headerGbc);

        JLabel titleLabel = new JLabel("Forgot your password?");
        titleLabel.setFont(customFont.deriveFont(Font.BOLD, 24f));

        // Title label to the header panel using GridBagConstraints
        headerGbc.gridx = 0;
        headerGbc.gridy = 1;
        headerPanel.add(titleLabel, headerGbc);

        // Body panel with GridBagLayout for precise control
        JPanel bodyPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 70, 10, 70);

        // Text field for the phone number
        JTextField phoneNumber = new JTextField("Phone Number", 20);
        phoneNumber.setFont(customFont.deriveFont(Font.PLAIN, 18));
        phoneNumber.setHorizontalAlignment(JTextField.LEFT);
        phoneNumber.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        phoneNumber.setOpaque(false);

        // FocusListener to clear the text when clicked
        phoneNumber.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (phoneNumber.getText().equals("Phone Number")) {
                    phoneNumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (phoneNumber.getText().isEmpty()) {
                    phoneNumber.setText("Phone Number");
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
        bodyPanel.add(phoneNumber, gbc);

        // Footer panel
        JPanel footerPanel = new JPanel();
        JButton recoverButton = new JButton("Recover");
        recoverButton.setFont(customFont.deriveFont(Font.PLAIN, 18));
        recoverButton.setBackground(new Color(0xffd55a));
        footerPanel.add(recoverButton);

        // Add the header, body, and footer panels to the main panel
        panel.add(headerPanel, BorderLayout.NORTH);
        panel.add(bodyPanel, BorderLayout.CENTER);
        panel.add(footerPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        add(panel);

        // Pack the frame and make it visible
        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);

    } // End of main method

    // Load a custom font from a file
    private static Font loadCustomFont(String fontPath) throws IOException, FontFormatException {
        File fontFile = new File(fontPath);
        return Font.createFont(Font.TRUETYPE_FONT, fontFile);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new ui.Forgot.Forgot(); // Create an instance of Signup with the custom title bar
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }
        });
    }  // End of main method

} // End of Forgot class