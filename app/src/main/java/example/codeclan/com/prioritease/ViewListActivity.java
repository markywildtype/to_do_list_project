package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ViewListActivity extends MenuActivity {

    ImageButton sortByStatus, sortByPriority;
    ImageView sortPriorityHeader;
    ArrayList<Task> allTasks;
    TaskListAdapter taskListAdapter;
    int sortStatus, sortPriority;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

//Placeholder data
//        allTasks = new DummyData().getTaskList();

        allTasks = new ArrayList<>();

//Sort buttons
        sortByStatus = findViewById(R.id.status_sort_image_button);
        sortByPriority = findViewById(R.id.priority_sort_image_button);

//Database
        PrioritEaseDatabase db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

//Make ViewList reusable by Priority Lists
        sortPriorityHeader = findViewById(R.id.sort_priority_header);
        Intent intent = getIntent();
        Bundle  b = intent.getExtras();


        if(b != null) {
            String matrixPos = (String) b.get("matrix pos");
            switch (matrixPos) {
                case "IU":
                    sortByPriority.setVisibility(View.INVISIBLE);
                    List<Task> allIUTasksAsList = db.taskDao().getAllImpUrTasks();
                    allTasks.addAll(new ArrayList<>(allIUTasksAsList));
                    break;
                case "IN":
                    sortByPriority.setVisibility(View.INVISIBLE);
                    List<Task> allINTasksAsList = db.taskDao().getAllImpNonUrTasks();
                    allTasks.addAll(new ArrayList<>(allINTasksAsList));
                    break;
                case "UU":
                    sortByPriority.setVisibility(View.INVISIBLE);
                    List<Task> allUUTasksAsList = db.taskDao().getAllUnimpUrTasks();
                    allTasks.addAll(new ArrayList<>(allUUTasksAsList));
                    break;
                case "UN":
                    sortByPriority.setVisibility(View.INVISIBLE);
                    List<Task> allUNTasksAsList = db.taskDao().getAllUnimpNonUrTasks();
                    allTasks.addAll(new ArrayList<>(allUNTasksAsList));
                    break;
            }
        }
        else {
            sortPriorityHeader.setVisibility(View.INVISIBLE);
            List<Task> allTasksAsList = db.taskDao().getAllTasks();
            allTasks.addAll(new ArrayList<>(allTasksAsList));
        }


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
        switch(sortPriority) {
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

}
