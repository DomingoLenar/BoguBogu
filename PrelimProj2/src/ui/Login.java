package ui;

import ui.Signup.Signup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public Login()
    {
        CardLayout cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        
        initPanel();

        sign_up_buttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Signup signup = new Signup();
                try {
                    signup.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (FontFormatException ex) {
                    ex.printStackTrace();
                }

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
