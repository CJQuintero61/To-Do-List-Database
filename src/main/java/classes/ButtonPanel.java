/*
    Developer CJ Quintero
    Last Updated 04/09/2025
    ButtonPanel.java

    This class makes the button panel for
    the app class
 */
package classes;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ButtonPanel extends JPanel
{
    // fields
    JButton newTaskButton = null;
    JButton editTaskButton = null;
    JButton deleteTaskButton = null;
    TaskList taskList = null;
    DefaultTableModel tableModel = null;
    JTable table = null;

    // constructor
    public ButtonPanel (TaskList taskList, DefaultTableModel tableModel, JTable table)
    {
        newTaskButton = new JButton("New Task");
        editTaskButton = new JButton("Edit Task");
        deleteTaskButton = new JButton("Delete Task");
        this.taskList = taskList; // reference to the task list from App
        this.tableModel = tableModel; // reference to the table model from App
        this.table = table; // reference to the JTable from App


        // add action listeners
        newTaskButton.addActionListener(e -> newTaskButtonClicked());
        editTaskButton.addActionListener(e -> editTaskButtonClicked());

        // set the layout and add the buttons
        this.setLayout(new FlowLayout());
        this.add(newTaskButton);
        this.add(editTaskButton);
        this.add(deleteTaskButton);
    }

    public void newTaskButtonClicked()
    {
        String taskName = null;
        String taskDate = null;

        // Try to get the name
        try
        {
            // get the task name
            taskName = JOptionPane.showInputDialog(null, "Enter Task Name",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            taskName = taskName.trim(); // trim white space
        }
        // occurs when cancel or the X button is clicked,
        // or for any other problem that may occur
        catch (Exception e)
        {
            // end the method if an exception is caught. This prevents
            // more input boxes from appearing if the user clicks cancel or the X
            System.out.println("ButtonPanel.java -> newTaskButtonClicked: " + e.getMessage());
            return;
        }

        // try to get the date
        try
        {
            // get the task date
            taskDate = JOptionPane.showInputDialog(null, "Enter Task Date",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            taskDate = taskDate.trim(); // trim white space
        }
        // occurs when cancel or the X button is clicked,
        // or for any other exceptions that may occur
        catch(Exception e)
        {
            // end the method if an exception is caught. This prevents
            // more input boxes from appearing if the user clicks cancel or the X
            System.out.println("ButtonPanel.java -> newTaskButtonClicked: " + e.getMessage());
            return;
        }

        // both the name and date must be filled
        if(!taskName.isEmpty() && !taskDate.isEmpty())
        {
            taskList.addTaskToList(taskName, taskDate);
            String[] row = {taskName, taskDate, "In Progress"};
            tableModel.addRow(row);
            refreshTableModel();

            System.out.println("ButtonPanel.java -> newTaskButtonClicked(): Task added and table refreshed");
        }
        // if the name is empty, and the date is filled
        else if(taskName.isEmpty() && !taskDate.isEmpty())
        {
            // tell the user that the name cannot be empty
            JOptionPane.showMessageDialog(null,
                    "Cannot make new task: Task name cannot be empty.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        // if the name is filled, but the date is empty
        else if(!taskName.isEmpty() && taskDate.isEmpty())
        {
            // tell the user that the date cannot be empty
            JOptionPane.showMessageDialog(null,
                    "Cannot make new task: Task date cannot be empty.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        // if both are empty
        else if(taskName.isEmpty() && taskDate.isEmpty())
        {
            JOptionPane.showMessageDialog(null,
                    "Cannot make new task: Task name and date cannot be empty.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        // catch any other errors that may occur
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Cannot make new task: An unknown error has occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    } // end newTaskButtonClicked

    public void editTaskButtonClicked()
    {
        int row = table.getSelectedRow();

        // validate the row before doing anything
        if(row >= 0)
        {
            JOptionPane.showMessageDialog(null, "You selected row " + row,
                    "Edit Task", JOptionPane.PLAIN_MESSAGE);
        }
        else if(row == -1) // getSelectedRow returns -1 if no row is selected
        {
            JOptionPane.showMessageDialog(null, "Select a row to edit first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        else // catch any other errors that may occur
        {
            JOptionPane.showMessageDialog(null, "An unknown error has occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    } // end editTaskButtonClicked

    // method for clearing the rows and re-adding them
    // to the table to update the display
    public void refreshTableModel()
    {
        try
        {
            // clear the table model rows
            tableModel.setRowCount(0);

            // for each item in the task list, add it back
            // to the table model
            for(Task task : taskList.getTaskList())
            {
                String[] row = {task.getTaskName(), task.getTaskDate(), task.getTaskStatus()};
                tableModel.addRow(row);
            }
        }
        catch(Exception e)
        {
            // catch any exceptions that may occur
            System.out.println("ButtonPanel.java -> refreshTableModel: " + e.getMessage());
        }

    } // end refreshTableModel

} // end class
