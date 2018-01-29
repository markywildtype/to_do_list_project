package example.codeclan.com.prioritease;

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

import java.util.ArrayList;

public class ViewListActivity extends AppCompatActivity {

//    RecyclerView recyclerView;
//    RecyclerView.Adapter adapter;

    //placeholder data
    ArrayList<Task> dummyTasks;
    //end placeholder data

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

//        recyclerView = findViewById(R.id.recycler_view);

        //placeholder ArrayList
        dummyTasks = new ArrayList<>();
        Task task1 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task2 = new Task("test", "test", TaskPriority.IMPORTANT_URGENT);
        Task task3 = new Task("test", "test", TaskPriority.UNIMPORTANT_NONURGENT);
        Task task4 = new Task("test", "test", TaskPriority.UNIMPORTANT_URGENT);
        Task task5 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task6 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task7 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task8 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        Task task9 = new Task("test", "test", TaskPriority.IMPORTANT_NONURGENT);
        dummyTasks.add(task1);
        dummyTasks.add(task2);
        dummyTasks.add(task3);
        dummyTasks.add(task4);
        dummyTasks.add(task5);
        dummyTasks.add(task6);
        dummyTasks.add(task7);
        dummyTasks.add(task8);
        dummyTasks.add(task9);
        //end placeholder ArrayList

        TaskListAdapter taskListAdapter = new TaskListAdapter(this, dummyTasks);
        ListView listView = findViewById(R.id.task_list_view);
        listView.setAdapter(taskListAdapter);
        
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new TaskListRecyclerAdapter(dummyTasks);  //passing in placeholder data
//        recyclerView.setAdapter(adapter);

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
