package tools;

import javax.swing.*;
import java.awt.*;

/**
 * The `TableActionCellEditor` class is a custom cell editor for JTable cells
 * that displays action buttons within the table.
 * It extends the DefaultCellEditor and provides the ability to edit table cells
 * with a PanelAction containing action buttons.
 */
public class TableActionCellEditor extends DefaultCellEditor {

    /**
     * Constructs a new `TableActionCellEditor` instance.
     * Initializes the cell editor with a JCheckBox as the editor component.
     */
    public TableActionCellEditor(){
        super(new JCheckBox());
    }
        /**
     * Returns the component used for editing the cell. This method is called
     * when a cell in the table is edited.
     *
     * @param table      The JTable that is being edited.
     * @param value      The value of the cell being edited.
     * @param isSelected A boolean indicating whether the cell is selected.
     * @param row        The row of the cell being edited.
     * @param column     The column of the cell being edited.
     * @return The component used for editing the cell, in this case, a PanelAction.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction action = new PanelAction(); // Create a PanelAction to represent the action buttons
        JPanel panel = action.getPanelAction(); // Get the JPanel containing action buttons
        panel.setBackground(table.getSelectionBackground()); // Set the background color of the panel based on selection
        return panel; // Return the panel as the editing component
    }
}
