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

    @ColumnInfo(name = "task_name")
    private String taskName;

    @ColumnInfo(name = "task_details")
    private String taskDetails;

//    @ColumnInfo(name = "completion_status")
//    private Complete completionStatus;

    @TypeConverters({CompStatConverter.class})
    private Complete completionStatus;

//    @ColumnInfo(name = "task_priority")
//    private TaskPriority taskPriority;

    @TypeConverters({TaPriConverter.class})
    private TaskPriority taskPriority;


    public Task(String taskName, String taskDetails, TaskPriority taskPriority){
        this.taskName = taskName;
        this.taskDetails = taskDetails;
        this.completionStatus = Complete.TO_DO;
        this.taskPriority = taskPriority;
    }

//TypeCoverters

    public class CompStatConverter {

        @TypeConverter
        public String enumToString(Complete completionStatus){
            return completionStatus.name();
        }

        @TypeConverter
        public Complete stringToEnum(String stringStatus){
            return Complete.valueOf(stringStatus);
        }
    }

    public class TaPriConverter {

        @TypeConverter
        public String enumToString(TaskPriority completionStatus){
            return completionStatus.name();
        }

        @TypeConverter
        public TaskPriority stringToEnum(String stringStatus){
            return TaskPriority.valueOf(stringStatus);
        }
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

//    public String getCompletionStatus(){
//        String compStat = this.completionStatus.toString();
//        return compStat;
//    }

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

    public String getCompletionStatusString(){
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
