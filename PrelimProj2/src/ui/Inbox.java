package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Inbox {
    private final String mainPanelID = "main_ID";

    private final String inboxID = "inbox_ID";

    private final String sentID = "sent_ID";
    private final String settingsID = "settings_ID";
    private JPanel mainPanel;
    private JButton inboxButton;
    private JButton sentButton;
    private JButton settingsButton;
    private JButton replyButton;
    private JButton forwardButton;
    private JPanel leftPanel;
    private JPanel inboxPanel;
    private JPanel contactsPanel;
    private JPanel composeLetterPanel;
    private JPanel cardPanel;
    private JPanel letterPanel;
    private JPanel attachImgPanel;
    private JPanel attachFilePanel;
    private JTextField searchField;
    private JPanel sentPanel;
    private JPanel settingsPanel;
    private JTable receivedMailsTable;
    private JTable sentMailsTable;

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getSentPanel() {
        return sentPanel;
    }

    public Inbox()
    {
        replyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        forwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        inboxButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // display inbox panel
                displayInboxComponents();
            }
        });

        sentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // display the sent panel
                displaySentComponents();
            }
        });
        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                // display the settings panel
                displaySettingsComponents();
            }
        });
        
        setUpFrame();

        // add the card panel in the main frame
        mainPanel.add(cardPanel);

        // show the main panel
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, inboxID);

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    private void setUpFrame() {
        cardPanel.add(inboxPanel, inboxID);
        cardPanel.add(sentPanel, sentID);
        cardPanel.add(settingsPanel, settingsID);
    }
    private void displaySettingsComponents() {
        changeScreen(settingsID);
    }
    private void displayInboxComponents() {
        changeScreen(inboxID);
    }
    private void displaySentComponents() {
        changeScreen(sentID);
    }

    private void changeScreen(String screen) {
        ((CardLayout)cardPanel.getLayout()).show(cardPanel, screen); // -> show the appropriate panel
        // The arguments are the "parent panel" and the "id" of a child panel in a parent panel, respectively.
    }

    public JButton getInboxButton() {
        return inboxButton;
    }

    public JButton getSentButton() {
        return sentButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
