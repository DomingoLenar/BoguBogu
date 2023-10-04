package ui.TitleBar;

import javax.swing.*;

public class TitleBar extends JFrame {

    public TitleBar() {
        try {
            // Set the icon for the JFrame (logo in the title bar)
            ImageIcon logoIcon = new ImageIcon("PrelimProj2/src/resources/icons/Bogu Mail 1.jpg");
            setIconImage(logoIcon.getImage());

            // Set the title for the JFrame (text in the title bar)
            setTitle("Bogu Bogu Mail");

            // Set other frame properties
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Center the frame
            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TitleBar());
    }
}

