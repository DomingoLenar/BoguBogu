package tools;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * The `TableActionCellRender` class is a custom cell renderer for JTable cells
 * that displays action buttons within the table.
 * It extends DefaultTableCellRenderer and provides custom rendering of table cells
 * with a PanelAction containing action buttons.
 */
public class TableActionCellRender extends DefaultTableCellRenderer {
    /**
     * Returns the component used for rendering the cell. This method is called
     * when a cell in the table is being displayed.
     *
     * @param table      The JTable that is being displayed.
     * @param value      The value of the cell being rendered.
     * @param isSelected A boolean indicating whether the cell is selected.
     * @param hasFocus   A boolean indicating whether the cell has focus.
     * @param row        The row of the cell being rendered.
     * @param column     The column of the cell being rendered.
     * @return The component used for rendering the cell, in this case, a PanelAction.
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        // Get the default component for rendering the cell
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        PanelAction action = new PanelAction(); // Create a PanelAction to represent the action buttons
        JPanel panel = action.getPanelAction();// Get the JPanel containing action buttons
        if (!isSelected && row % 2 == 0) { // Customize the background color based on selection and row number
            panel.setBackground(Color.WHITE); // row not selected
        } else {
            panel.setBackground(component.getBackground()); // row is selected
        }


        return panel; // Return the panel as the rendering component
    }
}
