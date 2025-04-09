/*
    Developer CJ Quintero
    Last Updated 04/09/2025
    TaskList.java

    This class makes the list for storing tasks
 */
package classes;

import java.util.ArrayList;
import java.util.List;

public class TaskList
{
    // fields
    List<Task> list = null;

    public TaskList()
    {
        list = new ArrayList<Task>();
    }

    public void addTaskToList(String name, String date)
    {
        Task task = new Task(name, date);
        list.add(task);
    }

    public List<Task> getTaskList() { return list; }
}
