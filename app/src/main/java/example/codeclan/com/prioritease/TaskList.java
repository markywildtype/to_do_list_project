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
}
