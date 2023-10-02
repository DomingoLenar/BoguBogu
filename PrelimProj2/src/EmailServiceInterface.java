import ui.Inbox;
import ui.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class EmailServiceInterface extends JFrame {
    private final String loginID = "login_id";
    private final String mainID = "main_id";
    private final String sentID = "sent_id";
    private final String forgotPassID = "forgot_pass_id";
    private final String signUpID = "sign_up_id";
    private Login login;
    private Inbox inbox;
    private JPanel cardPanel;

    EmailServiceInterface() throws IOException, FontFormatException {
        this.login = new Login();
        JButton login_buttn = login.getLogin_buttn();
        initButton(login_buttn);
        login_buttn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // validation processing
                setUpSubFrame();
                changeScreen(mainID);
            }
        });

        this.inbox = new Inbox();


        CardLayout cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        setUpMainFrame();

        // add card panel in frame
        add(cardPanel);

        // show login panel as main view
        ((CardLayout)cardPanel.getLayout()).show(cardPanel, loginID);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void displayInboxComponents() {
        changeScreen(mainID);
    }

    private void changeScreen(String screen) {
        ((CardLayout)cardPanel.getLayout()).show(cardPanel, screen); // -> show the appropriate panel
        // The arguments are the "parent panel" and the "id" of a child panel in a parent panel, respectively.
    }

    private void setUpMainFrame() {
        cardPanel.add(loginID, login.getMainPanel());
    }

    private void setUpSubFrame() {
        cardPanel.add(mainID, inbox.getMainPanel());

    }

    private void initButton(JButton button) {

    }
}
