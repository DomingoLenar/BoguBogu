package tools;

import javax.swing.*;

/**
 * The `PanelAction` class represents a panel containing user action buttons
 * within a graphical user interface (GUI).
 * It provides a convenient way to add action buttons to a panel.
 */
public class PanelAction{
     /** The JPanel to which action buttons are added. */
    private JPanel panelAction;

    /**
     * Constructs a new `PanelAction` instance.
     * Initializes the panel and adds an action button to it.
     */
    public PanelAction(){
        ActionButton actionButton = new ActionButton();
        getPanelAction().add(actionButton);
    }

    /**
     * Retrieves the JPanel containing action buttons.
     *
     * @return The JPanel for action buttons.
     */
    public JPanel getPanelAction() {
        return panelAction;
    }
}
