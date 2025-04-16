/**
 * This class makes task objects
 *
 * @file Task.java
 * @author CJ Quintero
 * @date 04/16/2025
 * @version 1.0
 */
package classes;

public class Task
{
    // fields
    String name = null;
    String date = null;
    boolean completion = false;


    /**
     * constructor
     *
     * @param name - task name
     * @param date - task date
     */
    public Task(String name, String date)
    {
        this.name = name;
        this.date = date;
        this.completion = false;
    }

    /**
     * setters
     */
    public void setTaskName(String name) { this.name = name; }
    public void setTaskDate(String date) { this.date = date; }
    public void setTaskCompletion(boolean completion) { this.completion = completion; }

    /**
     * getters
     */
    public String getTaskName() { return name; }
    public String getTaskDate() { return date; }
    public boolean getTaskCompletion() { return completion; }

    /**
     * toggle between a task being completed or in progress.
     * Flips the polarity of the bool value
     */
    public void toggleCompletion()
    {
        this.completion = !this.completion;
    }

    /**
     * @return - the status string depends on the value
     * of completion
     */
    public String getTaskStatus()
    {
        if(completion)
        {
            return "Completed";
        }
        else
        {
            return "In Progress";
        }
    }

} // end class

