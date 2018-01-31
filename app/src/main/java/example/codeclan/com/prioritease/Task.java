package example.codeclan.com.prioritease;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by user on 27/01/2018.
 */

@Entity(tableName = "tasks")
public class Task implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String taskName;

    private String taskDetails;

    public Complete completionStatus;

    public TaskPriority taskPriority;


    public Task(String taskName, String taskDetails, TaskPriority taskPriority, Complete completionStatus){
        this.taskName = taskName;
        this.taskDetails = taskDetails;
        this.completionStatus = completionStatus;
        this.taskPriority = taskPriority;
    }

//Getters

    public int getId(){
        return this.id;
    }

    public String getTaskName(){
        return this.taskName;
    }

    public String getTaskDetails(){
        return this.taskDetails;
    }

    public Complete getCompletionStatus(){
        return this.completionStatus;
    }

    public TaskPriority getTaskPriority(){
        return this.taskPriority;
    }

//Setters

    public void setId(int id){
        this.id = id;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDetails(String taskDetails){
        this.taskDetails = taskDetails;
    }

    public void setCompletionStatus(Complete completionStatus){
        this.completionStatus = completionStatus;
    }

    public void setPriority(TaskPriority priority){
        this.taskPriority = priority;
    }

//Extra

    public static Comparator<Task> TaskStatusComparatorDesc = new Comparator<Task>() {

        public int compare(Task task1, Task task2) {
            String taskStatus1 = task1.getCompletionStatusAsString();
            String taskStatus2 = task2.getCompletionStatusAsString();

            return taskStatus1.compareTo(taskStatus2);
        }};

    public static Comparator<Task> TaskStatusComparatorAsc = new Comparator<Task>() {

        public int compare(Task task1, Task task2) {
            String taskStatus1 = task1.getCompletionStatusAsString();
            String taskStatus2 = task2.getCompletionStatusAsString();

            return taskStatus2.compareTo(taskStatus1);
        }};


    public static Comparator<Task> TaskPriorityComparatorDesc = new Comparator<Task>() {

        public int compare(Task task1, Task task2) {
            String taskPriority1 = task1.getTaskPriority().name();
            String taskPriority2 = task2.getTaskPriority().name();

            return taskPriority1.compareTo(taskPriority2);
        }};

    public static Comparator<Task> TaskPriorityComparatorAsc = new Comparator<Task>() {

        public int compare(Task task1, Task task2) {
            String taskPriority1 = task1.getTaskPriority().name();
            String taskPriority2 = task2.getTaskPriority().name();

            return taskPriority2.compareTo(taskPriority1);
        }};


    public String getCompletionStatusAsString(){
        if(completionStatus == Complete.IN_PROGRESS) {
            return "In progress";
        } else if (completionStatus == Complete.COMPLETE) {
            return "Complete";
        } else
            return "To do";
    }

    public String getPriorityAsString(){
        if(taskPriority == TaskPriority.B_IMPORTANT_NONURGENT){
            return "Important/Non-urgent";
        } else if(taskPriority == TaskPriority.C_UNIMPORTANT_URGENT) {
            return "Unimportant/Urgent";
        } else if(taskPriority == TaskPriority.D_UNIMPORTANT_NONURGENT) {
            return "Unimportant/Non-urgent";
        } else
            return "Important/Urgent";
    }


}
