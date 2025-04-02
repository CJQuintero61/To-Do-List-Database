// App.java
// Developer: CJ Quintero
// Last Updated 04/02/2024
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
        buttonPanel = new ButtonPanel();

        // set layout
        frame.setLayout(new BorderLayout());
    }


    public void runApp()
    {
        // set attributes of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);


        // make the objects
        tasksPanel.makeTasksPanel();
        buttonPanel.makeButtonPanel();


        // add the objects
        frame.add(tasksPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        // show the frame (keep last)
        frame.setVisible(true);
    }

} // end class
