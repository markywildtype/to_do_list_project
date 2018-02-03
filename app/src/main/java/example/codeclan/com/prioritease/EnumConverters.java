package example.codeclan.com.prioritease;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by user on 30/01/2018.
 */

public class EnumConverters {

    @TypeConverter
    public static String fromComplete(Complete complete){
        if(complete == null){
            return null;
        }
        return complete.name();
    }

    @TypeConverter
    public static Complete toComplete(String string){
        if(string == null){
            return null;
        }
        return Complete.valueOf(string);
    }

    @TypeConverter
    public static String fromTaskPriority(TaskPriority taskPriority){
        if(taskPriority == null){
            return null;
        }
        return taskPriority.name();
    }

    @TypeConverter
    public static TaskPriority toTaskPriority(String string){
        if(string == null){
            return null;
        }
        return TaskPriority.valueOf(string);
    }
}

