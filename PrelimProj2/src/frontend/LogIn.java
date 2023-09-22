package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogIn extends JLayeredPane{

    JTextField username, password;
    JButton signUp, forgetPass, logIn;
    JLabel header, boguBogu;


    public LogIn(JFrame frame){
        int width = frame.getWidth(), height = frame.getHeight();

        setLayout(null);
        setVisible(true);
        setSize(width, height);

        header = new JLabel();
        header.setBounds(1000,240, 443,54);
        header.setText("Log In to Continue");
        header.setFont(new Font(null, Font.BOLD, 20));

        boguBogu = new JLabel();
        boguBogu.setBounds(40, 50, 600, 70);
        boguBogu.setText("Bogu-Bogu Mail");
        boguBogu.setFont(new Font(null,Font.BOLD, 64));

        username = new JTextField();
        username.setBounds(1000, 300, 550, 90);
        username.setText("Username");

        password = new JTextField();
        password.setBounds(1000, 443, 550, 90);
        password.setText("Password");

        logIn = new JButton();
        logIn.setText("Log-in");


        add(boguBogu);
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
        frame.setSize(1920,1005);
        frame.setResizable(false);

        LogIn panel = new LogIn(frame);
        frame.add(panel);

        frame.revalidate();
        frame.repaint();
    }

}
