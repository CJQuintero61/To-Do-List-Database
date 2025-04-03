// App.java
// Developer: CJ Quintero
// Last Updated 04/03/2025
//
// This class is the main object that is created to run the
// whole app. It has the frame, tasks panel, and the button panel
package classes;


import javax.swing.*;
import java.awt.*;


public class App
{
    //fields
    private JFrame frame = null;
    private TasksPanel tasksPanel = null;
    private ButtonPanel buttonPanel = null;


    public App()
    {
        // make the objects
        frame = new JFrame("To Do List");
        tasksPanel = new TasksPanel();
        buttonPanel = new ButtonPanel(tasksPanel);

        // set attributes of the frame
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        // add the objects
        frame.add(tasksPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // show the frame (keep last)
        frame.setVisible(true);
    }

} // end class
