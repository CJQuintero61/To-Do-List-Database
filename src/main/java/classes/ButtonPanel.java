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

        // prompts for taskName and validates it
        taskName = validateTaskName();

        if(taskName == null)
        {
            // stop more input boxes from showing
            return;
        }


        // get input and validate it
        taskDate = validateTaskDate();

        if(taskDate == null)
        {
            // stop more input boxes from showing
            return;
        }

        try
        {
            // add the task to the list and refresh table
            taskList.addTaskToList(taskName, taskDate);
            String[] row = {taskName, taskDate, "In Progress"};
            tableModel.addRow(row);
            refreshTableModel();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "An unknown error has occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);

            System.out.println(e.getMessage());
        }


    } // end newTaskButtonClicked

    /**
     * allows users to change a selected task from the table
     */
    public void editTaskButtonClicked()
    {
        int row = table.getSelectedRow();

        // validate the row first
        if(row >= 0)
        {
            // proceeds with the rest of the code
        }
        else if(row == -1) // no row selected
        {
            JOptionPane.showMessageDialog(null, "Select a row to edit first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else // catch any other errors that may occur
        {
            JOptionPane.showMessageDialog(null, "An unknown error has occurred.",
                    "Error", JOptionPane.ERROR_MESSAGE);

            System.out.println("Unknown Error validating selected row");
            return;
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
            System.out.println("Error refreshing table " + e.getMessage());
        }

    } // end refreshTableModel

    /**
     * gets user input for the task name and validates it
     *
     * @return - if
     */
    public String validateTaskName()
    {
        String taskName = null;

        try
        {
            // get the task name
            taskName = JOptionPane.showInputDialog(null, "Enter Task Name",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            // trim white space
            taskName = taskName.trim();

            // if valid return it
            if(!taskName.isEmpty())
            {
                return taskName;
            }
            else
            {
                // tell the user that the name cannot be empty
                JOptionPane.showMessageDialog(null,
                        "Cannot make new task: Task name cannot be empty.",
                        "Error", JOptionPane.ERROR_MESSAGE);

                return null;
            }

        } // end try
        catch (Exception e)
        {
            // catch any unknown errors
            // also catches when user cancels dialog box
            return null;
        } // end catch

    } // end validateTaskName

    /**
     * prompts user for task date and validates it
     * @return - the taskDate string if valid or null if empty
     */
    public String validateTaskDate()
    {
        String taskDate = null;

        try
        {
            // get the task date
            taskDate = JOptionPane.showInputDialog(null, "Enter Task Date",
                    "New Task", JOptionPane.PLAIN_MESSAGE);

            // trim white space
            taskDate = taskDate.trim();

            // if valid return it
            if(!taskDate.isEmpty())
            {
                return taskDate;
            }
            else
            {
                // tell the user that the date cannot be empty
                JOptionPane.showMessageDialog(null,
                        "Cannot make new task: Task date cannot be empty.",
                        "Error", JOptionPane.ERROR_MESSAGE);

                return null;
            }

        } // end try
        catch(Exception e)
        {
            // catch any unknown errors
            // also catches when user cancels dialog box
            return null;
        }

    } // end validateTaskDate


} // end class
