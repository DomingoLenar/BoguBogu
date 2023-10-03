package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Objects;

import datastruc.SingleLinkedList;
import datastruc.SingleNode;
import models.*;
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
    private final String forwardID = "forward_ID";
    private final String composeID = "compose_ID";
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
    private JTextArea replyTo;
    private JTextArea replySubject;
    private JLabel replyToLabel;
    private JLabel subjectReplyLabel;
    private JLabel replyToBodyLabel;
    private JTextArea replyToBody;
    private JButton sentReplyButton;
    private JPanel forwardPanel;
    private JTextField forwardTo;
    private JTextArea forwardToBody;
    private JButton sentForwardButton;
    private JButton composeButton;
    private JPanel composePanel;
    private JTextField composeTo;
    private JTextField composeSubject;
    private JTextArea composeBody;
    private JButton sendComposeButton;
    private JLabel composeToLabel;
    private JLabel composeSubjectLabel;
    private JLabel composeBodyLabel;
    private DefaultTableModel model;
    private SingleLinkedList<SingleLinkedList<Email>> inboxMails, sentMails;
    private User user;

    public Inbox(SingleLinkedList<SingleLinkedList<Email>> inboxMails, SingleLinkedList<SingleLinkedList<Email>> sentMails, User user)
    {
        this.user = user;
        this.inboxMails = inboxMails;
        this.sentMails = sentMails;

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

                if (replyTo.getText() == null && replySubject.getText() == null && replyToBody.getText() == null){
                    // error message
                    JOptionPane.showMessageDialog(null, "");
                } else {
                    Email reply = new Email(user.getUsername(), replyTo.getText(), replySubject.getText(), replyToBody.getText());
                    SingleLinkedList<Email> thread = new SingleLinkedList<>();
                    SingleNode<SingleLinkedList<Email>> pointer = inboxMails.getHead();
                    if (pointer.getLink() == null) {
                        thread = pointer.getData();
                        thread.add(reply);
                        user.updateThreadOfReceiver(thread, replyTo.getText());
                        user.saveRuntimeMails(inboxMails, "inbox",user.getUsername());
                    } else {
                        while (pointer.getLink().getLink() != null) {
                            if (pointer.getData().getHead().getData().getSubject().equals(replySubject.getText())) {
                                thread = pointer.getData();
                                thread.add(reply);
                                break;
                            } else {
                                pointer = pointer.getLink();
                            }
                        }
                        user.updateThreadOfReceiver(thread, replyTo.getText());
                        user.saveRuntimeMails(inboxMails,"inbox",user.getUsername());
                    }
                }
            }
        });

        sentForwardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (forwardTo.getText() == null && forwardToBody.getText() == null){
                    // error message
                } else {
                    // save the data
                }
            }
        });


        replyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = receivedMailsTable.getSelectedRow();
                replyTo.setText(receivedMailsTable.getValueAt(row, 0).toString());
                replySubject.setText(receivedMailsTable.getValueAt(row, 2).toString());

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
                displayForwardComponents();
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
                displaySentComponents();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }
        });

        composeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                displayComposeComponents();
            }
        });

        sendComposeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(composeTo.getText() == null && composeSubject.getText() == null && composeBody.getText() == null){
                    // display error
                }else{
                    Email newMail = new Email(user.getUsername(), composeTo.getText(), composeSubject.getText(), composeBody.getText());
                    SingleLinkedList<Email> newThread = new SingleLinkedList<>();
                    newThread.add(newMail);
                    sentMails.addAtHead(newThread);
                    user.updateThreadOfReceiver(newThread,composeTo.getText());
                }
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
                int row = receivedMailsTable.getSelectedRow();

                if (Objects.equals(letterBody.getText(), "")) {
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        letterBody.append((String) receivedMailsTable.getValueAt(row, i)); // TODO: display content of mail
                    }
                } else {
                    letterBody.setText("");
                }
                composeLetterPanel.setVisible(true);
            }
        });

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
        model.fireTableDataChanged();
        receivedMailsTable.setModel(model);
    }

    private void setUpSentMailsTable(SingleLinkedList<SingleLinkedList<Email>> sentMails) {

        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Sender");
        model.addColumn("Receiver");
        model.addColumn("Subject");
        model.addColumn("Body");
        sentMailsTable = new JTable(model);
        displaySentMails(sentMails); // Populate the table with data

//        TableColumn column = sentMailsTable.getColumnModel().getColumn(1);
//        column.setPreferredWidth(600);
    }


    private void displaySentMails(SingleLinkedList<SingleLinkedList<Email>> sentMails) {
        SingleNode<SingleLinkedList<Email>> currentNode = sentMails.getHead(); // outer first pointer

        while (currentNode != null) {
            SingleLinkedList<Email> emailSingleLinkedList = currentNode.getData();
            SingleNode<Email> emailSingleNode = emailSingleLinkedList.getHead();
            while (emailSingleNode != null) {
                Email email = emailSingleNode.getData();
                model.addRow(new Object[]{email.getSender(), email.getReceiver(), email.getSubject(), email.getBody()});
                emailSingleNode = emailSingleNode.getLink();
            }
            currentNode = currentNode.getLink();
        }

    }

    private void setUpReceivedMailsTable(SingleLinkedList<SingleLinkedList<Email>> inboxMails) {

        // DefaultTableModel with column names
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        model.addColumn("Sender");
        model.addColumn("Receiver");
        model.addColumn("Subject");
        model.addColumn("Body");
        receivedMailsTable = new JTable(model);

        displayReceivedMails(inboxMails); // Populate the table with data

//        TableColumn column = receivedMailsTable.getColumnModel().getColumn(1);
//        column.setPreferredWidth(600);

    }

    private void displayReceivedMails(SingleLinkedList<SingleLinkedList<Email>> inboxMail) {
        SingleNode<SingleLinkedList<Email>> currentNode = inboxMail.getHead(); // outer first pointer

        while (currentNode != null) {
           SingleLinkedList<Email> emailSingleLinkedList = currentNode.getData();
           SingleNode<Email> emailSingleNode = emailSingleLinkedList.getHead();
           while (emailSingleNode != null) {
               Email email = emailSingleNode.getData();
               model.addRow(new Object[]{email.getSender(), email.getReceiver(), email.getSubject(), email.getBody()});
               emailSingleNode = emailSingleNode.getLink();
           }
           currentNode = currentNode.getLink();
        }

    }

    private void setUpFrame() {
        cardPanel.add(inboxPanel, inboxID);
        cardPanel.add(sentContactsPanel, sentID);
        cardPanel.add(composePanel, composeID);
        cardPanel.add(settingsPanel, settingsID);
        cardPanel.add(replyPanel, replyID);
        cardPanel.add(forwardPanel, forwardID);
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
    private void displayForwardComponents() {

        changeScreen(forwardID);
    }
    private void displayComposeComponents() {
        changeScreen(composeID);
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
        setUpReceivedMailsTable(this.inboxMails);
        setUpSentMailsTable(this.sentMails);

    }
}
