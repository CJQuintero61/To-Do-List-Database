// ButtonPanel.java
// Developer: CJ Quintero
// Last Updated 04/03/2025
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
    private TasksPanel tasksPanel = null;

    // constants
    public final Font DEFAULT_FONT = new Font("Arial", Font.PLAIN, 16);


    public ButtonPanel(TasksPanel tasksPanel)
    {
        // reference to the tasksPanel object
        this.tasksPanel = tasksPanel;

        // make the buttons
        newTaskButton = new JButton("New Task");
        editTaskButton = new JButton("Edit Task");
        deleteTaskButton = new JButton("Delete Task");

        // set layout
        this.setLayout(new FlowLayout());

        // set the font
        newTaskButton.setFont(DEFAULT_FONT);
        editTaskButton.setFont(DEFAULT_FONT);
        deleteTaskButton.setFont(DEFAULT_FONT);

        // add action listeners
        newTaskButton.addActionListener(e -> newTaskButtonClicked());
        editTaskButton.addActionListener(e -> editTaskButtonClicked());
        deleteTaskButton.addActionListener(e -> deleteTaskButtonClicked());

        // add buttons to the panel
        this.add(newTaskButton);
        this.add(editTaskButton);
        this.add(deleteTaskButton);
    }

    public void newTaskButtonClicked()
    {
        // show dialog boxes to get the task name and date
        String taskName = JOptionPane.showInputDialog(null, "Enter Task Name:",
                "Enter Task Name", JOptionPane.QUESTION_MESSAGE);
        String taskDate = JOptionPane.showInputDialog(null, "Enter Task Date:",
                "Enter Task Date", JOptionPane.QUESTION_MESSAGE);


        // task name validation. This stops the user from entering only
        // spaces and trims spaces out of the string
        if(taskName != null && !taskName.trim().isEmpty())
        {
            // create the new task
            Task newTask = new Task(taskName, taskDate);

            // add the task to the list
            tasksPanel.addTask(newTask);
        }
    }


    public void editTaskButtonClicked()
    {
        Task selectedTask = tasksPanel.getSelectedTask();

        // if no task is selected, show an error
        if(selectedTask == null)
        {
            JOptionPane.showMessageDialog(null, "Please select a task first",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // show dialog boxes to get the task name and date
        String taskName = JOptionPane.showInputDialog(null, "Edit Task Name:",
                "Edit Task Name", JOptionPane.QUESTION_MESSAGE, null,
                null, selectedTask.getTaskName()).toString();

        String taskDate = JOptionPane.showInputDialog(null, "Edit Task Date:",
                "Edit Task Date", JOptionPane.QUESTION_MESSAGE, null,
                null, selectedTask.getTaskDate()).toString();

        // validate the task name
        if(taskName != null && !taskName.trim().isEmpty())
        {
            // update the task name and date
            selectedTask.editTask(taskName, taskDate);

            // refresh the list
            tasksPanel.refreshList();
        }
    }


    public void deleteTaskButtonClicked()
    {
        // get the selected task and a variable to hold the
        // selection value
        Task selectedTask = tasksPanel.getSelectedTask();
        int confirmSelection = 0;

        // if no task is selected, show an error
        if(selectedTask == null)
        {
            JOptionPane.showMessageDialog(null, "Please select a task first",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ask user if they want to delete the task
        confirmSelection = JOptionPane.showConfirmDialog(null,
                "Are you sure you'd like to delete this task?",
                "Delete Task", JOptionPane.YES_NO_OPTION);

        if(confirmSelection == JOptionPane.YES_OPTION)
        {
            tasksPanel.deleteTask(selectedTask);
        }
    }

} // end class
