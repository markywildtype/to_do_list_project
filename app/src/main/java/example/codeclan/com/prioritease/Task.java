package example.codeclan.com.prioritease;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.renderscript.RenderScript;

import java.io.Serializable;

/**
 * Created by user on 27/01/2018.
 */

@Entity(tableName = "tasks")
public class Task implements Serializable{

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String taskName;

    private String taskDetails;

    private Complete completionStatus;

    private TaskPriority taskPriority;


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

    public String getCompletionStatusAsString(){
        if(completionStatus == Complete.IN_PROGRESS) {
            return "In progress";
        } else if (completionStatus == Complete.COMPLETE) {
            return "Complete";
        } else
            return "To do";
    }

    public String getPriorityAsString(){
        if(taskPriority == TaskPriority.IMPORTANT_NONURGENT){
            return "Important/Non-urgent";
        } else if(taskPriority == TaskPriority.UNIMPORTANT_URGENT) {
            return "Unimportant/Urgent";
        } else if(taskPriority == TaskPriority.UNIMPORTANT_NONURGENT) {
            return "Unimportant/Non-urgent";
        } else
            return "Important/Urgent";
    }


}
