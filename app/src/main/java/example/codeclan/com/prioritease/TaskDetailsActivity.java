package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TaskDetailsActivity extends MenuActivity {

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
}
