import ui.Inbox;
import ui.Login;

import javax.swing.*;

public class EmailServiceInterface extends JFrame {

    private Login login;
    private Inbox inbox;
    EmailServiceInterface()
    {
//        this.login = new Login();
        this.inbox = new Inbox();
        setContentPane(inbox.getMainPanel());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}
