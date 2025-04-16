/**
 * This class makes the button panel for
 * the app class
 *
 * @file ButtonPanel.java
 * @author CJ Quintero
 * @date 04/16/2025
 * @version 1.0
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

    /**
     * constructor - creates the button panel and adds
     * action listeners to the buttons
     *
     * @param taskList - reference to task list from App class
     * @param tableModel - reference to the table model from App class
     * @param table - reference to the JTable from App
     */
    public ButtonPanel (TaskList taskList, DefaultTableModel tableModel, JTable table)
    {
        newTaskButton = new JButton("New Task");
        editTaskButton = new JButton("Edit Task");
        deleteTaskButton = new JButton("Delete Task");

        // references
        this.taskList = taskList;
        this.tableModel = tableModel;
        this.table = table;


        // add action listeners
        newTaskButton.addActionListener(e -> newTaskButtonClicked());
        editTaskButton.addActionListener(e -> editTaskButtonClicked());

        // set the layout and add the buttons
        this.setLayout(new FlowLayout());
        this.add(newTaskButton);
        this.add(editTaskButton);
        this.add(deleteTaskButton);
    }

    /**
     * creates a new task, adds it to the task list, then
     * updates the table to display properly
     */
    public void newTaskButtonClicked()
    {
        String taskName = null;
        String taskDate = null;

        try
        {
            // get the task name
            taskName = JOptionPane.showInputDialog(null, "Enter Task Name",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            taskName = taskName.trim(); // trim white space
        }
        catch (Exception e)
        {
            // prevent more dialog boxes from appearing
            // and log the error to console
            System.out.println("ButtonPanel.java -> newTaskButtonClicked -> taskName exception " + e.getMessage());
            return;
        }

        try
        {
            // get the task date
            taskDate = JOptionPane.showInputDialog(null, "Enter Task Date",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            taskDate = taskDate.trim(); // trim white space
        }
        catch(Exception e)
        {
            // prevent more dialog boxes from appearing
            // and log error
            System.out.println("ButtonPanel.java -> newTaskButtonClicked -> taskDate exception " + e.getMessage());
            return;
        }

        // both the name and date must be filled
        if(!taskName.isEmpty() && !taskDate.isEmpty())
        {
            taskList.addTaskToList(taskName, taskDate);
            String[] row = {taskName, taskDate, "In Progress"};
            tableModel.addRow(row);
            refreshTableModel();
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
            // tell user of unknown error
            JOptionPane.showMessageDialog(null,
                    "Cannot make new task: An unknown error has occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);

            // log error
            System.out.println("ButtonPanel.java -> newTaskButtonClicked ->" +
                    " taskName and taskDate exception -> unknown error");
        }

    } // end newTaskButtonClicked

    /**
     * allows users to change a selected task from the table
     */
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

    /**
     * refreshes the table to show the new list after
     * adding, editing, or removing a task
     */
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
