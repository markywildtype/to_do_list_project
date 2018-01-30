package example.codeclan.com.prioritease;

import java.util.ArrayList;

/**
 * Created by user on 27/01/2018.
 */

public class DummyData {

    private ArrayList<Task> taskList;

    public DummyData(){
        this.taskList = new ArrayList<>();
        taskList.add(new Task("Get it done", "Make the database work, then sort out your EnumConverters and save/update/delete methods", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.A_IMPORTANT_URGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.D_UNIMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.B_UNIMPORTANT_URGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
        taskList.add(new Task("test", "test", TaskPriority.C_IMPORTANT_NONURGENT, Complete.TO_DO));
    }

    public ArrayList<Task> getTaskList() {
        return this.taskList;
    }

}
