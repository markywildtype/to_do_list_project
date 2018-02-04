package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TaskDetailsActivity extends MenuActivity {

    TextView taskName;
    TextView taskPriority;
    TextView taskCompletionStatus;
    TextView taskDetails;
    ImageButton editButton, deleteButton;
    Task task;
    PrioritEaseDatabase db;
    String parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");
        Bundle b = intent.getExtras();
        parent = (String) b.get("origin");

        taskName = findViewById(R.id.task_details_task_name);
        taskName.setText("Task Name: " + task.getTaskName());

        taskPriority = findViewById(R.id.task_details_priority);
        taskPriority.setText("Priority: " + task.getPriorityAsString());

        taskCompletionStatus = findViewById(R.id.task_details_completion_status);
        taskCompletionStatus.setText("Status: " + task.getCompletionStatusAsString());

        taskDetails = findViewById(R.id.task_details_task_details);
//        taskDetails.setMovementMethod(new ScrollingMovementMethod());
        taskDetails.setText(task.getTaskDetails());


        editButton = findViewById(R.id.edit_image_button);
        deleteButton = findViewById(R.id.delete_image_button);
    }

    public void onEditButtonClick(View view){
        Intent intent = new Intent(this, EditTaskActivity.class);
        intent.putExtra("task", task);
        intent.putExtra("origin", "details");
        startActivity(intent);
    }

    public void onDeleteClick(View view){
        db.taskDao().deleteTask(task);

        Intent intent = new Intent(TaskDetailsActivity.this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(TaskDetailsActivity.this, "Task deleted!" , Toast.LENGTH_SHORT).show();
    }

    //Custom Up button/parent activity
    @Override
    public Intent getSupportParentActivityIntent(){
        return getParentActivityIntentImpl();
    }

    @Override
    public Intent getParentActivityIntent(){
        return getParentActivityIntentImpl();
    }

    private Intent getParentActivityIntentImpl() {
        Intent i = null;
        if (parent != null) {
            i = new Intent(this, ViewListActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        }
        return i;
    }

}
