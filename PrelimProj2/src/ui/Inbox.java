package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import tools.TableActionCellEditor;
import tools.TableActionCellRender;
import tools.TableActionEvent;


public class Inbox {
    private final String[] columnTitle = {"YEAR", "SEMESTER"};
    private final String[][] sampleData = {{"YEAR", "SEMESTER"},
    {"YEAR", "SEMESTER"}, {"YEAR", "SEMESTER"}, {"YEAR", "SEMESTER"}};
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
    private JTextArea letterBody;
    private JScrollPane scrollPane;
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
                searchFilter(searchField.getText());
            }
        });

    }

    private void initButtons() {
        replyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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

        receivedMailsTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRender());
        receivedMailsTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditor());

        sentMailsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        sentMailsTable.getColumnModel().getColumn(1).setCellRenderer(new TableActionCellRender());
        sentMailsTable.getColumnModel().getColumn(1).setCellEditor(new TableActionCellEditor());

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
                false, true
        };
        model = new DefaultTableModel(sampleData, columnTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column]; // set JTable column non-editable
            }
        };
        sentMailsTable = new JTable(model);

        TableColumn column = sentMailsTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(600);
    }

    private void setUpReceivedMailsTable() {
        boolean[] canEdit = new boolean[]{
                false, true
        };
        model = new DefaultTableModel(sampleData, columnTitle) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return canEdit[column]; // set JTable column non-editable
            }
        };
        receivedMailsTable = new JTable(model);

        TableColumn column = receivedMailsTable.getColumnModel().getColumn(0);
        column.setPreferredWidth(600);
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
