package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ImpNonUrListActivity extends AppCompatActivity {
    List<Task> allTasksAsList;
    ArrayList<Task> allImpNonUrTasks;
    TaskListAdapter taskListAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_non_ur_list);

        allImpNonUrTasks = new ArrayList<>();

        //Database
        PrioritEaseDatabase db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

        allTasksAsList = db.taskDao().getAllImpNonUrTasks();
        allImpNonUrTasks.addAll(new ArrayList<>(allTasksAsList));


//ListView and Adapter
        taskListAdapter = new TaskListAdapter(this, allImpNonUrTasks);

        ListView listView = findViewById(R.id.imp_non_ur_list_view);
        listView.setAdapter(taskListAdapter);

//Floating Action Button
        fab = findViewById(R.id.fab_i_n);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ImpNonUrListActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onListItemClick(View listItem) {
        Task task = (Task) listItem.getTag();

        Intent intent = new Intent(this, TaskDetailsActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }
}