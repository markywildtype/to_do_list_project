package example.codeclan.com.prioritease;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 27/01/2018.
 */

public class TaskTest {

    Task task;

    @Before
    public void before(){
        task = new Task("Do shopping", "Milk, eggs, bread");
    }

    @Test
    public void hasTaskName(){
        assertEquals("Do shopping", task.getTaskName());
    }

    @Test
    public void hasTaskDetails(){
        assertEquals("Milk, eggs, bread", task.getTaskDetails());
    }

    @Test
    public void completionStatusStartsAtToDo(){
        assertEquals(Complete.TO_DO, task.getCompletionStatus());
    }

    @Test
    public void canSetCompletionStatus(){
        task.setCompletionStatus(Complete.IN_PROGRESS);
        assertEquals(Complete.IN_PROGRESS, task.getCompletionStatus());
    }
}
