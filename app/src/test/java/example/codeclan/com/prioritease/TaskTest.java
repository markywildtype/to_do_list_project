package example.codeclan.com.prioritease;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 27/01/2018.
 */

public class TaskTest {

    Task task, task2, task3, task4;

    @Before
    public void before(){
        task = new Task("Do shopping", "Milk, eggs, bread", TaskPriority.C_UNIMPORTANT_URGENT, Complete.TO_DO);
        task2 = new Task("Eat Dinner", "Milk, eggs, bread", TaskPriority.C_UNIMPORTANT_URGENT, Complete.IN_PROGRESS);
        task3 = new Task("Do shopping", "Milk, eggs, bread", TaskPriority.C_UNIMPORTANT_URGENT, Complete.COMPLETE);
        task4 = new Task("Do shopping", "Milk, eggs, bread", TaskPriority.C_UNIMPORTANT_URGENT, Complete.TO_DO);
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
//Obsolete test
//    @Test
//    public void completionStatusStartsAtToDo(){
//        assertEquals("Complete.TO_DO", task.getCompletionStatus());
//    }

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
        assertEquals(TaskPriority.C_UNIMPORTANT_URGENT, task.getTaskPriority());
    }

    @Test
    public void canSetPriority(){
        task.setPriority(TaskPriority.D_UNIMPORTANT_NONURGENT);
        assertEquals(TaskPriority.D_UNIMPORTANT_NONURGENT, task.getTaskPriority());
    }

    @Test
    public void canGetPriorityAsString(){
        assertEquals("Unimportant/Urgent", task.getPriorityAsString());
    }

    @Test
    public void canSortTaskArrayListByStatus(){
        ArrayList<Task> testArray = new ArrayList<>();
        ArrayList<Task> expectedArray = new ArrayList<>();
        testArray.add(task);
        testArray.add(task2);
        testArray.add(task3);
        testArray.add(task4);
        expectedArray.add(task3);
        expectedArray.add(task2);
        expectedArray.add(task);
        expectedArray.add(task4);
        Collections.sort(testArray, Task.TaskStatusComparatorDesc);
        assertEquals(expectedArray.toString(), testArray.toString());
    }


}
