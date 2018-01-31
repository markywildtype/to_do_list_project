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
    public List<Task> getAllTasks();

    @Insert(onConflict = OnConflictStrategy.ABORT)
    public void addTask(Task... task);

    @Update
    public void updateTask(Task... task);

    @Delete
    public void deleteTask(Task task);

    @Delete
    public void deleteMultipleTasks(Task... task);

    @Query("DELETE FROM tasks")
    public void deleteAllTasks();

    @Query("SELECT * FROM tasks WHERE taskPriority = 'A_IMPORTANT_URGENT'")
    public List<Task> getAllImpUrTasks();

    @Query("SELECT * FROM tasks WHERE taskPriority = 'B_IMPORTANT_NONURGENT'")
    public List<Task> getAllImpNonUrTasks();

    @Query("SELECT * FROM tasks WHERE taskPriority = 'C_UNIMPORTANT_URGENT'")
    public List<Task> getAllUnimpUrTasks();

    @Query("SELECT * FROM tasks WHERE taskPriority = 'D_UNIMPORTANT_NONURGENT'")
    public List<Task> getAllUnimpNonUrTasks();
}

//    WHERE taskPriority = 'A_IMPORTANT_URGENT'