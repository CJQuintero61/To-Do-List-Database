// ButtonPanel.java
// Developer: CJ Quintero
// Last Updated 04/02/2025
//
// This class makes the Button Panel. It has 3 buttons:
// new, edit, and delete. The respective action listeners are
// also included in this file.
package classes;


import javax.swing.*;
import java.awt.*;


public class ButtonPanel extends JPanel
{
    // fields
    private JButton newTaskButton = null;
    private JButton editTaskButton = null;
    private JButton deleteTaskButton = null;


    // constants
    public final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);


    public ButtonPanel()
    {
        // make the objects
        newTaskButton = new JButton("New Task");
        editTaskButton = new JButton("Edit Task");
        deleteTaskButton = new JButton("Delete Task");

        // set layout
        this.setLayout(new FlowLayout());
    }


    public void makeButtonPanel()
    {
        // set font
        newTaskButton.setFont(DEFAULT_FONT);
        editTaskButton.setFont(DEFAULT_FONT);
        deleteTaskButton.setFont(DEFAULT_FONT);


        // add action listeners to the buttons
        newTaskButton.addActionListener(e -> newTaskButtonClicked());
        editTaskButton.addActionListener(e -> editTaskButtonClicked());
        deleteTaskButton.addActionListener(e -> deleteTaskButtonClicked());


        // add the buttons to the panel
        this.add(newTaskButton);
        this.add(editTaskButton);
        this.add(deleteTaskButton);
    }


    public void newTaskButtonClicked()
    {
        JOptionPane.showInputDialog(null, "Enter the task name",
                "New Task", JOptionPane.PLAIN_MESSAGE);

    }


    public void editTaskButtonClicked()
    {
        System.out.println("Edit Task");
    }


    public void deleteTaskButtonClicked()
    {
        System.out.println("Delete Task");
    }

} // end class
