package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JLayeredPane{

    JTextField username, password;
    JButton signUp, forgetPass;

    JLabel header;


    public LogIn(JFrame frame){
        int width = frame.getWidth(), height = frame.getHeight();

        setLayout(null);
        setVisible(true);
        setSize(width, height);

        header = new JLabel();
        header.setBounds(4,10, 50,50);
        header.setText("Log In");

        username = new JTextField();
        username.setBounds(400, 10, 100, 20);
        username.setText("Username");

        password = new JTextField();
        password.setBounds(400, 50, 100, 20);
        password.setText("Password");

        add(header);
        add(username);
        add(password);

        validate();
        repaint();


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(600,600);
        frame.setResizable(false);

        LogIn panel = new LogIn(frame);
        frame.add(panel);

        frame.revalidate();
        frame.repaint();
    }

}
