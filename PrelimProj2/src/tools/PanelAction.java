package tools;

import javax.swing.*;

public class PanelAction{
    private JPanel panelAction;

    public PanelAction(){
        ActionButton actionButton = new ActionButton();
        getPanelAction().add(actionButton);
    }

    public JPanel getPanelAction() {
        return panelAction;
    }
}
