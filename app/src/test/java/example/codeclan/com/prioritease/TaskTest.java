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
        task = new Task("Do shopping", "Milk, eggs, bread", TaskPriority.UNIMPORTANT_URGENT);
    }

    @Test
    public void hasTaskName(){
        assertEquals("Do shopping", task.getTaskName());
    }

    @Test
    public void canEditTaskName(){
        task.setTaskName("Saturday shopping");
        assertEquals("Saturday shopping", task.getTaskName());
    }

    @Test
    public void hasTaskDetails(){
        assertEquals("Milk, eggs, bread", task.getTaskDetails());
    }

    @Test
    public void canEditTaskDetails(){
        task.setTaskDetails("Milk, eggs, bread, sugar, cheese");
        assertEquals("Milk, eggs, bread, sugar, cheese", task.getTaskDetails());
    }

    @Test
    public void completionStatusStartsAtToDo(){
        assertEquals("Complete.TO_DO", task.getCompletionStatus());
    }

    @Test
    public void canSetCompletionStatus(){
        task.setCompletionStatus(Complete.IN_PROGRESS);
        assertEquals(Complete.IN_PROGRESS, task.getCompletionStatus());
    }

    @Test
    public void canGetCompletionStatusAsString(){
        assertEquals("To do", task.getCompletionStatusAsString());
    }


    @Test
    public void hasPriority(){
        assertEquals(TaskPriority.UNIMPORTANT_URGENT, task.getTaskPriority());
    }

    @Test
    public void canSetPriority(){
        task.setPriority(TaskPriority.UNIMPORTANT_NONURGENT);
        assertEquals(TaskPriority.UNIMPORTANT_NONURGENT, task.getTaskPriority());
    }

    @Test
    public void canGetPriorityAsString(){
        assertEquals("Unimportant/Urgent", task.getPriorityAsString());
    }


}
