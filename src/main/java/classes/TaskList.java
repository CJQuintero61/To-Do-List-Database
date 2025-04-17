/**
 * This class makes the list for
 * storing tasks
 *
 * @file TaskList.java
 * @author CJ Quintero
 * @date 04/17/2025
 * @version 1.0
 */
package classes;

import java.util.ArrayList;
import java.util.List;

public class TaskList
{
    // fields
    List<Task> list = null;

    /**
     * constructor - makes the array list object
     */
    public TaskList()
    {
        list = new ArrayList<Task>();
    }

    /**
     * makes a new task object then adds it to the
     * array list
     *
     * @param name - task name
     * @param date - task date
     */
    public void addTaskToList(String name, String date)
    {
        Task task = new Task(name, date);
        list.add(task);
    }

    /**
     * @return - the list object to be used in ButtonPanel.java
     */
    public List<Task> getTaskList() { return list; }

    /**
     * gets the task of a certain index in the list
     * @param index - the location in the list
     * @return - the task
     */
    public Task getSelectedTask(int index)
    {
        return list.get(index);
    }

    public void deleteSelectedTask(int index)
    {
        try
        {
            list.remove(index);
        }
        catch(Exception e)
        {
            System.out.println("Error deleting task from task list");
            System.out.println(e.getMessage());
        }
    }

} // end class
