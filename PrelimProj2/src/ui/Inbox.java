package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import datastruc.SingleLinkedList;
import datastruc.SingleNode;
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
    private final String forwardID = "forward_ID";
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
    private JTextArea subjectReply;
    private JLabel replyToLabel;
    private JLabel subjectReplyLabel;
    private JLabel replyToBodyLabel;
    private JTextArea replyToBody;
    private JButton sentReplyButton;
    private JPanel forwardPanel;
    private JTextField forwardTo;
    private JTextArea forwardToBody;
    private JButton sentForwardButton;
    private DefaultTableModel model;
    private SingleLinkedList<SingleLinkedList<Email>> inboxMails, sentMails;

    public Inbox(SingleLinkedList<SingleLinkedList<Email>> inboxMails, SingleLinkedList<SingleLinkedList<Email>> sentMails)
    {
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
        displayReceivedMails();
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

                if (replyTo.getText() == null && subjectReply.getText() == null && replyToBody.getText() == null){
                    // error message
                } else {
                    // save the data
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

//        fetchSentMails(sentMails);
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

    private void fetchSentMails(SingleLinkedList<SingleLinkedList<Email>> sentMails) {
        SingleNode<SingleLinkedList<Email>> currentNode = sentMails.getHead(); // outer first pointer

        while (currentNode != null) {
            SingleLinkedList<Email> emailSingleLinkedList = currentNode.getData();
            SingleNode<Email> emailSingleNode = emailSingleLinkedList.getHead();
            while (emailSingleNode != null) {
                Email email = emailSingleNode.getData();
                model.addRow(new Object[]{email.getSubject(), email.getSender()});
                emailSingleNode = emailSingleNode.getLink();
            }
            currentNode = currentNode.getLink();
        }

    }

    private void setUpReceivedMailsTable() {
        boolean[] canEdit = new boolean[]{
                false, false, true
        };

//        fetchReceivedMails(inboxMails);

        // DefaultTableModel with column names
        model = new DefaultTableModel(sampleData, columnTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column]; // set JTable column non-editable
            }
        };
        //         SingleLinkedList<SingleLinkedList<Email>> linkedListOfLists = new SingleLinkedList<>();


        receivedMailsTable = new JTable(model);

        TableColumn column = receivedMailsTable.getColumnModel().getColumn(1);
        column.setPreferredWidth(600);
    }

    private void displayReceivedMails(SingleLinkedList<SingleLinkedList<Email>> inboxMail) {
        SingleNode<SingleLinkedList<Email>> currentNode = inboxMail.getHead(); // outer first pointer

        while (currentNode != null) {
           SingleLinkedList<Email> emailSingleLinkedList = currentNode.getData();
           SingleNode<Email> emailSingleNode = emailSingleLinkedList.getHead();
           while (emailSingleNode != null) {
               Email email = emailSingleNode.getData();
               model.addRow(new Object[]{email.getSubject(), email.getSender()});
               emailSingleNode = emailSingleNode.getLink();
           }
           currentNode = currentNode.getLink();
        }

//        while (currentList != null){
//            SingleNode<Email> currentNode = currentList.ge;
//            while (currentNode != null){
//                Email email = currentNode.getData();
//                model.addRow(new Object[]{email.getSubject(), email.getBody()});
//            }
//        }

    }

    private void setUpFrame() {
        cardPanel.add(inboxPanel, inboxID);
        cardPanel.add(sentContactsPanel, sentID);
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
        displayReceivedMails(this.inboxMails);
        setUpReceivedMailsTable();
        setUpSentMailsTable();

    }
}
