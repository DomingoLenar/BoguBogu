package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Inbox extends JLayeredPane {
    // instantiate field variables
    JList inboxList;
    JButton settings, inboxMenu;


    public Inbox(JFrame frame){
        int width = frame.getWidth();
        int height = frame.getHeight();

        setLayout(null);
        setVisible(true);

    }


}
