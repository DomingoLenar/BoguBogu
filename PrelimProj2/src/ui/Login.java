package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    private JButton sign_up_buttn;
    private JTextField usernameTextField;
    private JPasswordField passwordPasswordField;
    private JCheckBox rememberMeCheckBox;
    private JPanel cardPanel;
    private JPanel mainPanel;
    private JButton login_buttn;

    public Login()
    {
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
    public String getUsernameFieldString(){
        return usernameTextField.getText();
    }
    public String getPasswordFieldString(){
        char[] passwordChar = passwordPasswordField.getPassword();
        StringBuilder passwordString = new StringBuilder();
        for(int x = 0; x < passwordChar.length; x++){
            passwordString.append(passwordChar[x]);
        }
        return passwordString.toString();
    }

}
