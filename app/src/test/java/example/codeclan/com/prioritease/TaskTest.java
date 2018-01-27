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
        task = new Task("Do shopping");
    }

    @Test
    public void hasTaskName(){
        assertEquals("Do shopping", task.getTaskName());
    }
}
