// TasksPanel.java
// Developer: CJ Quintero
// Last Updated 04/02/2024
//
// This class makes the Tasks panel.
// This is where you can see the tasks from the array
// shown. By using border layout in this panel and only adding 1 element,
// the list properly scales with frame resizing and takes up
// all the space it can, which is what I want.
package classes;


import javax.swing.*;
import java.awt.*;


public class TasksPanel extends JPanel
{
    // fields
    private String[] tasksArray = null;
    private JList<String> list = null;
    private JScrollPane scrollPane = null;


    // constants
    public final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);
    public final int ARRAY_SIZE = 3;


    public TasksPanel()
    {
        // make the objects
        tasksArray = new String[ARRAY_SIZE];
        list = new JList<>(tasksArray);
        scrollPane = new JScrollPane(list);

        // set layout
        setLayout(new BorderLayout());
    }


    public void makeTasksPanel()
    {
        // scroll bar only shows up when needed in the scroll pane
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // add some example tasks
        tasksArray[0] = "Task 1";
        tasksArray[1] = "Task 2";
        tasksArray[2] = "Task 3";

        // add the scroll pane (with the list) to the panel
        this.add(scrollPane, BorderLayout.CENTER);
    }


} // end class
