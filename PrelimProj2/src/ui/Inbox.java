package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import models.Email;
import tools.TableActionCellEditor;
import tools.TableActionCellRender;
import tools.TableActionEvent;


public class Inbox {
    private final String[] columnTitle = {"NAME", "MAIL", "CUSTOM"};
    private final String[][] sampleData = {{"NAME-1", "Hi"},
    {"NAME-2", "Hey"}, {"NAME-3", "Hello"}, {"NAME-4", "Hi"}};
    private final String mainPanelID = "main_ID";

    private final String inboxID = "inbox_ID";

    private final String sentID = "sent_ID";
    private final String settingsID = "settings_ID";
    private final String replyID = "reply_ID";
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
    private JPanel sentContactsPanel;
    private JPanel settingsPanel;
    private JTable receivedMailsTable;
    private JTable sentMailsTable;
    private JTextArea letterBody;
    private JScrollPane inboxScrollPane;
    private JPanel sentPanel;
    private JPanel composeSentLetterPanel;
    private JPanel sentImgPanel;
    private JPanel sentFilePanel;
    private JPanel sentLetterPanel;
    private JScrollPane sentScrollPane;
    private JPanel replyPanel;
    private JTextArea receiver;
    private JTextArea subject;
    private JLabel receiverLabel;
    private JLabel subjectLabel;
    private JLabel bodyLabel;
    private JTextArea body;
    private JButton sentReplyButton;
    private DefaultTableModel model;

    public Inbox()
    {
        initComponents();

        setUpFrame();

        // add the card panel in the main frame
        mainPanel.add(cardPanel);

        // show the main panel
        ((CardLayout) cardPanel.getLayout()).show(cardPanel, inboxID);


    }

    private void initComponents() {
        initTables();
        initButtons();

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                searchFilter(searchField.getText()); // TODO: filter search
            }
        });

    }

    private void initButtons() {

        sentReplyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // TODO: reply to clicked mail in inbox

                if (receiver.getText() == null && subject.getText() == null && body.getText() == null){
                    // save the data
                }
            }
        });
        replyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                displayReplyComponents();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        forwardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        inboxButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                displayInboxComponents();
                composeLetterPanel.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        sentButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setUpSentMailsTable();
                displaySentComponents();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        settingsButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                displaySettingsComponents();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });
    }
    private void initTables() {

        receivedMailsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                letterBody.append("LOLOLOLOLOL"); // TODO: display content of mail
                composeLetterPanel.setVisible(true);
            }
        });

        receivedMailsTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        receivedMailsTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor());

        sentMailsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        sentMailsTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRender());
        sentMailsTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditor());

        TableActionEvent event = new TableActionEvent(){
            @Override
            public void onDelete(int row) {

            }

            @Override
            public void onView(int row) {

            }

        };

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
        boolean[] canEdit = new boolean[]{
                false, false, true
        };

        fetchSentMails();
        model = new DefaultTableModel(sampleData, columnTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column]; // set JTable column non-editable
            }
        };
        sentMailsTable = new JTable(model);

        TableColumn column = sentMailsTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(600);
    }

    private void fetchSentMails() {
    }

    private void setUpReceivedMailsTable() {
        boolean[] canEdit = new boolean[]{
                false, false, true
        };

        fetchReceivedMails();
        model = new DefaultTableModel(sampleData, columnTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column]; // set JTable column non-editable
            }
        };
        receivedMailsTable = new JTable(model);

        TableColumn column = receivedMailsTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(600);
    }

    private void fetchReceivedMails() {
        Email email = new Email();
    }

    private void setUpFrame() {
        cardPanel.add(inboxPanel, inboxID);
        cardPanel.add(sentContactsPanel, sentID);
        cardPanel.add(settingsPanel, settingsID);
        cardPanel.add(replyPanel, replyID);
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
    private void displayReplyComponents() {
        changeScreen(replyID);
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
        return sentContactsPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        setUpReceivedMailsTable();
        setUpSentMailsTable();

    }
}
