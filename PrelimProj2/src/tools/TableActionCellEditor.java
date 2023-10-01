package tools;

import javax.swing.*;
import java.awt.*;

public class TableActionCellEditor extends DefaultCellEditor {

    public TableActionCellEditor(){
        super(new JCheckBox());
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction();
        JPanel panel = action.getPanelAction();
        panel.setBackground(table.getSelectionBackground());
        return panel;
    }
}
