package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JButton signUpButton;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JCheckBox rememberMeCheckBox;
    private JPanel cardPanel;
    private JPanel mainPanel;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Login()
    {
        CardLayout cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        initPanel();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "lol");
                displaySignUpComponent();

            }
        });

        setUpFrame();
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

}
