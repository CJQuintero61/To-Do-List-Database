/**
 * This class contains the main classes as
 * attributes to make the app
 *
 * @file App.java
 * @author CJ Quintero
 * @date 04/16/2025
 * @version 1.0
 */
package classes;

import javax.swing.*;
import java.awt.*;

public class App
{
    // fields
    JFrame frame = null;
    TablePanel tablePanel = null;
    ButtonPanel buttonPanel = null;
    TaskList taskList = null;

    /**
     * constructor - creates the panels and sets
     * frame attributes
     */
    public App()
    {
        // initialize the objects
        frame = new JFrame("To Do List"); // title
        tablePanel = new TablePanel();
        taskList = new TaskList();
        buttonPanel = new ButtonPanel(taskList, tablePanel.getTableModel(), tablePanel.getTable());

        // set some attributes
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        // add the panels
        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        // show the frame
        frame.setVisible(true);
    } // end constructor

} // end class
