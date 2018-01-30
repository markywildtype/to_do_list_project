package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ViewListActivity extends AppCompatActivity {

    TextView nameHeader, statusHeader, priorityHeader;
    Button sortByStatus, sortByPriority;
    ArrayList<Task> allTasks;
    TaskListAdapter taskListAdapter;
    int sortStatus, sortPriority;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);


//Placeholder data
        allTasks = new DummyData().getTaskList();

        nameHeader = findViewById(R.id.name_header);
        statusHeader = findViewById(R.id.status_header);
        priorityHeader = findViewById(R.id.priority_header);

        sortByStatus = findViewById(R.id.sort_status_button);
        sortByPriority = findViewById(R.id.sort_priority_button);

//Database
        PrioritEaseDatabase db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

        List<Task> allTasksAsList = db.taskDao().getAllTasks();
        allTasks.addAll(new ArrayList<>(allTasksAsList));

//Sorting variables
        sortStatus = 0;
        sortPriority = 0;

//ListView and Adapter
        taskListAdapter = new TaskListAdapter(this, allTasks);
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

//Sorting methods
    public void onSortStatusClick(View view){
        switch(sortStatus){
            case 0:
                Collections.sort(allTasks, Task.TaskStatusComparatorDesc);
                sortStatus = 1;
                taskListAdapter.notifyDataSetChanged();
                break;
            case 1:
                Collections.sort(allTasks, Task.TaskStatusComparatorAsc);
                sortStatus = 0;
                taskListAdapter.notifyDataSetChanged();
                break;
        }

    }

    public void onSortPriorityClick(View view) {
        switch (sortPriority) {
            case 0:
                Collections.sort(allTasks, Task.TaskPriorityComparatorDesc);
                sortPriority = 1;
                taskListAdapter.notifyDataSetChanged();
                break;
            case 1:
                Collections.sort(allTasks, Task.TaskPriorityComparatorAsc);
                sortPriority = 0;
                taskListAdapter.notifyDataSetChanged();
                break;
        }
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
        switch(item.getItemId()){
            case R.id.action_view_list:
                Intent intent1 = new Intent(this, ViewListActivity.class);
                startActivity(intent1);
                break;
            case R.id.action_add_task:
                Intent intent2 = new Intent(this, AddTaskActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
