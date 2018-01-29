package example.codeclan.com.prioritease;

import android.arch.persistence.room.Query;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Update;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 29/01/2018.
 */

@Dao
public interface TaskDao {

//Doesn't work with ArrayList?
//    @Query("SELECT * FROM tasks")
//    public ArrayList<Task> getAllTasks();

    @Query("SELECT * FROM tasks")
    public Task[] getAllTasks();

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void addTask(Task task);

    @Update
    public void updateTask(Task task);

    @Delete
    public void deleteTask(Task task);

    @Delete
    public void deleteMultipleTasks(Task... task);

    @Query("DELETE FROM tasks")
    public void deleteAllTasks();

}
