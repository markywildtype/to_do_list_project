package example.codeclan.com.prioritease;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 27/01/2018.
 */

public class TaskListTest {

    TaskList taskList;
    Task task;
    Task task2;
    Task task3;

    @Before
    public void before(){
        task = new Task("Shopping", "Eggs, milk, bread");
        task2 = new Task("Dinner", "Lasagne, Pizza, Omelette");
        task3 = new Task("Gym", "Weights, Cardio, HIIT");
        taskList = new TaskList();
    }

    @Test
    public void canAddToTaskList(){
        taskList.addTask(task);
        assertEquals(1, taskList.countTasks());
    }

}