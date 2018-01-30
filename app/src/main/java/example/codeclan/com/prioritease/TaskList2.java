package example.codeclan.com.prioritease;

import java.util.ArrayList;

/**
 * Created by user on 27/01/2018.
 */

public class TaskList2 {

    private ArrayList<Task> taskList;

    public TaskList2(){
        this.taskList = new ArrayList<>();
        taskList.add(new Task("Get it done", "Make the database work, then sort out your EnumConverters and save/update/delete methods", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_URGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.UNIMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.UNIMPORTANT_URGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT, Complete.TO_DO));
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

}
