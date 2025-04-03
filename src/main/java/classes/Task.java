// Task.java
// Developer: CJ Quintero
// Last Updated 04/03/2025
//
// This class creates a task object. Each task
// has a name, date, and checkbox. There is a method
// to edit the task, and to get the task string.
package classes;

import javax.swing.*;

public class Task
{
    // fields
    private String taskName = null;
    private String date = null;

    // constructor
    public Task(String taskName, String date)
    {
        this.taskName = taskName;
        this.date = date;
    }

    // edit task details
    public void editTask(String taskName , String date)
    {
        this.taskName = taskName;
        this.date = date;
    }

    // getter for task name
    public String getTaskName()
    {
        return taskName;
    }

    // getter for date
    public String getTaskDate()
    {
        return date;
    }

    // needed to avoid the list showing garbage
    @Override
    public String toString()
    {
        return taskName + " " + date;
    }

} // end class
