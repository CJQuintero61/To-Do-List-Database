// TasksPanel.java
// Developer: CJ Quintero
// Last Updated 04/03/2025
//
// This class makes the Tasks panel.
// This is where you can see the tasks from the array
// shown. By using border layout in this panel and only adding 1 element,
// the list properly scales with frame resizing and takes up
// all the space it can, which is what I want.
package classes;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TasksPanel extends JPanel
{
    // fields
    private ArrayList<Task> taskArrayList = null;
    private DefaultListModel<Task> taskListModel = null;
    private JList<Task> taskList = null;
    private JScrollPane scrollPane = null;

    // constants
    public final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);

    public TasksPanel()
    {
        // make the objects
        taskArrayList = new ArrayList<>();
        taskListModel = new DefaultListModel<>();
        taskList = new JList(taskListModel);
        scrollPane = new JScrollPane(taskList);

        // set layout
        this.setLayout(new BorderLayout());

        // set some attributes of the list
        taskList.setFont(DEFAULT_FONT);
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // set location in the main panel
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    // add tasks dynamically
    public void addTask(Task task)
    {
        // add the new task to the array list
        taskArrayList.add(task);

        // then add the task to the list model to update the list
        taskListModel.addElement(task);
    }

    // remove tasks dynamically
    public void deleteTask(Task task)
    {
        // remove from array list
        taskArrayList.remove(task);

        // remove from list model to update list
        taskListModel.removeElement(task);
    }

    // getter for the array list
    public ArrayList<Task> getArrayList()
    {
        return taskArrayList;
    }

    // getter for the selected task
    public Task getSelectedTask()
    {
        return taskList.getSelectedValue();
    }

    // refreshes the display
    public void refreshList()
    {
        taskList.repaint();
    }

} // end class
