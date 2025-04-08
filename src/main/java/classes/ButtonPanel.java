/*
    Developer CJ Quintero
    Last Updated 04/08/2025
    ButtonPanel.java

    This class makes the button panel for
    the app class
 */
package classes;

import java.awt.*;
import javax.swing.*;

public class ButtonPanel extends JPanel
{
    // fields
    JButton newTaskButton = null;
    JButton editTaskButton = null;
    JButton deleteTaskButton = null;

    // constructor
    public ButtonPanel()
    {
        newTaskButton = new JButton("New Task");
        editTaskButton = new JButton("Edit Task");
        deleteTaskButton = new JButton("Delete Task");

        // set the layout and add the buttons
        this.setLayout(new FlowLayout());
        this.add(newTaskButton);
        this.add(editTaskButton);
        this.add(deleteTaskButton);
    }

} // end class
