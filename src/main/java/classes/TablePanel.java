/*
    Developer CJ Quintero
    Last Updated 04/09/2025
    TablePanel.java

    This class makes the entire table panel for
    the app class
 */
package classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablePanel extends JPanel
{
    // fields
    JTable table = null;
    JScrollPane scrollPane = null;
    String[] tableColumnHeaders = {"Task", "Date", "Status"};
    DefaultTableModel tableModel = null;


    // constructor
    public TablePanel()
    {
        // make the table model with 3 headers and 0 initial rows
        tableModel = new DefaultTableModel(tableColumnHeaders, 0)
        {
            // stop the cells from being editable
            @Override
            public boolean isCellEditable(int row, int column)
            { return false; }
        };

        // make the table with the tableModel
        table = new JTable(tableModel);

        // set table attributes
        table.getTableHeader().setReorderingAllowed(false);
        table.setRowHeight(30);

        // make the scroll pane and add the table
        scrollPane = new JScrollPane(table);

        // add the scroll pane to the panel
        this.add(scrollPane);
    }

    // to use the tableModel reference in ButtonPanel.java
    public DefaultTableModel getTableModel() { return tableModel; }

    // to use the table reference in ButtonPanel.java
    public JTable getTable() { return table; }

} // end class
