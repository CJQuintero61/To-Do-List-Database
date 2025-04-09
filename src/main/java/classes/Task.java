/*
    Developer CJ Quintero
    Last Updated 04/09/2025
    Task.java

    This class makes task objects
 */
package classes;

public class Task
{
    // fields
    String name = null;
    String date = null;
    boolean completion = false;

    // parameterized constructor
    public Task(String name, String date)
    {
        this.name = name;
        this.date = date;
        this.completion = false;
    }

    // setters
    public void setTaskName(String name) { this.name = name; }
    public void setTaskDate(String date) { this.date = date; }
    public void setTaskCompletion(boolean completion) { this.completion = completion; }

    // getters
    public String getTaskName() { return name; }
    public String getTaskDate() { return date; }
    public boolean getTaskCompletion() { return completion; }

    // toggle between task completed and in progress
    // if "true" set to "false"
    // if "false" set to "true"
    public void toggleCompletion()
    {
        this.completion = !this.completion;
    }

    // show the status depending on the completion
    // if "in progress" set to "completed"
    // if "completed" set to "in progress"
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

