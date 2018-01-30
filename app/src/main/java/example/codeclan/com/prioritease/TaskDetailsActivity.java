package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView taskName;
    TextView taskPriority;
    TextView taskCompletionStatus;
    TextView taskDetails;
    Button editButton;
    Button deleteButton;
    Task task;
    PrioritEaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");

        taskName = findViewById(R.id.task_details_task_name);
        taskName.setText(task.getTaskName());

        taskPriority = findViewById(R.id.task_details_priority);
        taskPriority.setText(task.getPriorityAsString());

        taskCompletionStatus = findViewById(R.id.task_details_completion_status);
        taskCompletionStatus.setText(task.getCompletionStatusAsString());

        taskDetails = findViewById(R.id.task_details_task_details);
        taskDetails.setText(task.getTaskDetails());

        editButton = findViewById(R.id.task_details_edit_button);
        deleteButton = findViewById(R.id.task_details_delete_button);
    }

    public void onEditButtonClick(View view){
        Intent intent = new Intent(this, EditTaskActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    public void onDeleteClick(View view){
        db.taskDao().deleteTask(task);

        Intent intent = new Intent(TaskDetailsActivity.this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(TaskDetailsActivity.this, "Task deleted!" , Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main, menu);
        return true;
    }

//Menu
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
