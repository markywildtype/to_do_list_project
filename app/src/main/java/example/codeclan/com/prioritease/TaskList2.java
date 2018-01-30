package example.codeclan.com.prioritease;

import java.util.ArrayList;

/**
 * Created by user on 27/01/2018.
 */

public class TaskList2 {

    private Task[] taskList;

    public TaskList2(){
        Task task1 = new Task("Get it done", "Make the database work, then sort out your TypeConverters and save/update/delete methods", TaskPriority.IMPORTANT_NONURGENT);
        Task task2 = new Task("test", "test", TaskPriority.IMPORTANT_URGENT);
        Task task3 = new Task("test", "test", TaskPriority.UNIMPORTANT_NONURGENT);
        Task task4 = new Task("test", "test", TaskPriority.UNIMPORTANT_URGENT);
        Task task5 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task6 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task7 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task8 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task9 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        taskList = new Task[]{task1, task2, task3, task4, task5, task6, task7, task8, task9};
    }



    public Task[] getTaskList() {
        return this.taskList;
    }

}
