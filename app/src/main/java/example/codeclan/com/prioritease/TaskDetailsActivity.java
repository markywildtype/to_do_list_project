package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView taskName;
    TextView taskPriority;
    TextView taskCompletionStatus;
    TextView taskDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        Intent intent = getIntent();
        Task task = (Task) intent.getSerializableExtra("task");

        taskName = findViewById(R.id.task_details_task_name);
        taskName.setText(task.getTaskName());

        taskPriority = findViewById(R.id.task_details_priority);
        taskPriority.setText(task.getPriorityAsString());

        taskCompletionStatus = findViewById(R.id.task_details_completion_status);
        taskCompletionStatus.setText(task.getCompletionStatusString());

        taskDetails = findViewById(R.id.task_details_task_details);
        taskDetails.setText(task.getTaskDetails());
    }
}
