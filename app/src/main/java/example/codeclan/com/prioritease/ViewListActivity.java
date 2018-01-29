package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {

    TextView nameHeader;
    TextView statusHeader;
    TextView priorityHeader;
    ArrayList<Task> allTasks;
//    Task[] allTasks;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);


//placeholder ArrayList
        allTasks = new ArrayList<>();
        Task task1 = new Task("Get it done", "Make the database work, then sort out your TypeConverters and save/update/delete methods", TaskPriority.IMPORTANT_NONURGENT);
        Task task2 = new Task("test", "test", TaskPriority.IMPORTANT_URGENT);
        Task task3 = new Task("test", "test", TaskPriority.UNIMPORTANT_NONURGENT);
        Task task4 = new Task("test", "test", TaskPriority.UNIMPORTANT_URGENT);
        Task task5 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task6 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task7 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task8 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task9 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        allTasks.add(task1);
        allTasks.add(task2);
        allTasks.add(task3);
        allTasks.add(task4);
        allTasks.add(task5);
        allTasks.add(task6);
        allTasks.add(task7);
        allTasks.add(task8);
        allTasks.add(task9);
        //end placeholder ArrayList


        nameHeader = findViewById(R.id.name_header);
        statusHeader = findViewById(R.id.status_header);
        priorityHeader = findViewById(R.id.priority_header);

//Database
//        PrioritEaseDatabase db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").build();
//
//        allTasks = db.taskDao().getAllTasks();

//ListtView and Adapter
        TaskListAdapter taskListAdapter = new TaskListAdapter(this, allTasks);
        ListView listView = findViewById(R.id.task_list_view);
        listView.setAdapter(taskListAdapter);

//Floating Action Button
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ViewListActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onListItemClick(View listItem){
        Task task = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskDetailsActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }



//Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.action_view_list){
            Intent intent = new Intent(this, ViewListActivity.class);
            startActivity(intent);
            return true;
        } else if(item.getItemId() == R.id.action_add_task){
            Intent intent = new Intent(this, AddTaskActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
