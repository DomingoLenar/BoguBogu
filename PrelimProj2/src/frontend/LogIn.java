package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JLayeredPane{

    JTextField username, password;
    JButton signUp, forgetPass;


    public LogIn(JFrame frame){
        int width = frame.getWidth(), height = frame.getHeight();

        setLayout(null);
        setVisible(true);
        setSize(600, 600);

        username = new JTextField();
        password.setBounds(4, 10, 60, 20);
        username.setText("Username");

        password = new JTextField();
        password.setBounds(4, 40, 60, 20);
        password.setText("Password");

        add(username);
        add(password);


    }

}
