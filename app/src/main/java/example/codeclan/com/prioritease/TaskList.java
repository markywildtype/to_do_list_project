package example.codeclan.com.prioritease;

import java.util.ArrayList;

/**
 * Created by user on 27/01/2018.
 */

public class TaskList {

    private ArrayList<Task> taskList;

    public TaskList(){
        taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public int countTasks() {
        return this.taskList.size();
    }

    public ArrayList<Task> getTaskList() {
        return new ArrayList<>(this.taskList);
    }

    public Task removeTask(Task task) {
        this.taskList.remove(task);
        return task;
    }
}
