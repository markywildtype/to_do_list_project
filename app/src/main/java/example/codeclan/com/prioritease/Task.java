package example.codeclan.com.prioritease;

import java.io.Serializable;

/**
 * Created by user on 27/01/2018.
 */

public class Task implements Serializable{

    private String taskName;
    private String taskDetails;
    private Complete completionStatus;
    private TaskPriority taskPriority;


    public Task(String taskName, String taskDetails, TaskPriority taskPriority){
        this.taskName = taskName;
        this.taskDetails = taskDetails;
        this.completionStatus = Complete.TO_DO;
        this.taskPriority = taskPriority;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTaskDetails() {
        return this.taskDetails;
    }

    public Complete getCompletionStatus() {
        return this.completionStatus;
    }

    public void setCompletionStatus(Complete completionStatus) {
        this.completionStatus = completionStatus;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }

    public TaskPriority getTaskPriority() {
        return this.taskPriority;
    }
}
