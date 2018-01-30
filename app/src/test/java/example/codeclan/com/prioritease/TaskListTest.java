//package example.codeclan.com.prioritease;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
///**
// * Created by user on 27/01/2018.
// */
//
//public class TaskListTest {
//
//    TaskList taskList;
//    Task task;
//    Task task2;
//    Task task3;
//
//    @Before
//    public void before(){
//        task = new Task("Shopping", "Eggs, milk, bread", TaskPriority.IMPORTANT_NONURGENT);
//        task2 = new Task("Dinner", "Lasagne, Pizza, Omelette", TaskPriority.UNIMPORTANT_URGENT);
//        task3 = new Task("Gym", "Weights, Cardio, HIIT", TaskPriority.IMPORTANT_NONURGENT);
//        taskList = new TaskList();
//    }
//
//    @Test
//    public void canAddToTaskList(){
//        taskList.addTask(task);
//        assertEquals(1, taskList.countTasks());
//    }
//
//    @Test
//    public void canRemoveFromTaskList(){
//        taskList.addTask(task);
//        taskList.addTask(task2);
//        taskList.addTask(task3);
//        assertEquals(3, taskList.countTasks());
//        taskList.removeTask(task2);
//        assertEquals(2, taskList.countTasks());
//    }
//
//    @Test
//    public void canGetTaskList(){
//        taskList.addTask(task);
//        assertEquals(1, taskList.getTaskList().size());
//    }
//
//}
