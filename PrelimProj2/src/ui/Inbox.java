package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class Inbox {
    private final String[] columnTitle = {"YEAR", "SEMESTER" ,"COURSE CODE", "COMPUTER SCIENCE", "UNITS"};
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
    private DefaultTableModel model;
    private JButton buttn_active = null;

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
                displayInboxComponents();
                composeLetterPanel.setVisible(false);
            }
        });
        sentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setUpSentMailsTable();
                displaySentComponents();
            }
        });
        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
                searchFilter(searchField.getText());
            }
        });
        receivedMailsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                composeLetterPanel.setVisible(true); // display content of a mail
            }
        });
        sentMailsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });
    }

    private void searchFilter(String searchTerm) {
        DefaultTableModel filteredItems = new DefaultTableModel();

        Arrays.stream(columnTitle).forEach(item -> {
            String letter = item.toLowerCase();
            if (letter.contains(searchTerm.toLowerCase())){
                filteredItems.addColumn(item);
            }
        });

        model = filteredItems;
        receivedMailsTable.setModel(model);
    }

    private void setUpSentMailsTable() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // which set JTable non-editable
            }
        };
        model.addColumn("Test1", columnTitle);
        sentMailsTable = new JTable(model);
    }

    private void setUpReceivedMailsTable() {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // which set JTable non-editable
            }
        };
        model.addColumn("Test1", columnTitle);
        receivedMailsTable = new JTable(model);
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

    public JPanel getCardPanel() {
        return cardPanel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getSentPanel() {
        return sentPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        setUpReceivedMailsTable();
        setUpSentMailsTable();

    }
}
