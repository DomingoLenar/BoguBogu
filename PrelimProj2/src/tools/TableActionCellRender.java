package tools;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableActionCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        PanelAction action = new PanelAction();
        JPanel panel = action.getPanelAction();
        if (!isSelected && row % 2 == 0) {
            panel.setBackground(Color.WHITE); // row not selected
        } else {
            panel.setBackground(component.getBackground()); // row is selected
        }


        return panel;
    }
}
