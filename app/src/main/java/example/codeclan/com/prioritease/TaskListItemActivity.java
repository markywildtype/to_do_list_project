package example.codeclan.com.prioritease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TaskListItemActivity extends AppCompatActivity {

    TextView listItemTaskName, listItemCompletionStatus, listItemPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list_item);

        listItemTaskName = findViewById(R.id.list_item_task_name);
        listItemCompletionStatus = findViewById(R.id.list_item_task_completion_status);
        listItemPriority = findViewById(R.id.list_item_priority);
    }
}
