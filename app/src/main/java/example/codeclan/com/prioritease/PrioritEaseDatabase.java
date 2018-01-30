package example.codeclan.com.prioritease;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

/**
 * Created by user on 29/01/2018.
 */

@Database(entities = {Task.class}, version = 1)
@TypeConverters({EnumConverters.class})
public abstract class PrioritEaseDatabase extends RoomDatabase{
    public abstract TaskDao taskDao();
}
