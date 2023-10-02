package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class Login {
    private JButton sign_up_buttn;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JCheckBox rememberMeCheckBox;
    private JPanel cardPanel;
    private JPanel mainPanel;
    private JButton login_buttn;
    private JLabel icon;
    private JLabel welcome;
    private JLabel bogu;
    private JLabel login;
    private JLabel forgot;
    private JLabel log;

    public Login() throws IOException, FontFormatException {

        // Load the custom font
        Font customFont = loadCustomFont("PrelimProj2/src/font/JosefinSans-Regular.ttf");

        welcome.setFont(customFont.deriveFont(Font.BOLD, 24f));
        bogu.setFont(customFont.deriveFont(Font.BOLD, 24f));
        login.setFont(customFont.deriveFont(Font.BOLD, 24f));
        forgot.setFont(customFont.deriveFont(Font.BOLD, 24f));
        log.setFont(customFont.deriveFont(Font.BOLD, 24f));

        CardLayout cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        initPanel();

        sign_up_buttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "lol");
                displaySignUpComponent();

            }
        });

        setUpFrame();
        login_buttn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);



            }
        });
    }

    private void displaySignUpComponent() {
        // change screen

    }

    private void setUpFrame() {

    }

    private void initPanel() {
    }

    private void changeScreen() {
    }

    public JButton getLogin_buttn() {
        return login_buttn;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private static Font loadCustomFont(String fontPath) throws IOException, FontFormatException {
        File fontFile = new File(fontPath);
        return Font.createFont(Font.TRUETYPE_FONT, fontFile);
    }

}
