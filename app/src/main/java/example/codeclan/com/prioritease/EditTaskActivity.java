package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EditTaskActivity extends AppCompatActivity {

    EditText editTaskName;
    EditText editTaskDetails;
    RadioButton important_urgent, important_nonurgent, unimportant_urgent, unimportant_nonurgent;
    Button saveChangesButton;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");

        editTaskName = findViewById(R.id.edit_task_name);
        editTaskName.setText(task.getTaskName());

        editTaskDetails = findViewById(R.id.edit_task_details);
        editTaskDetails.setText(task.getTaskDetails());

        important_urgent = findViewById(R.id.edit_important_urgent_button);
        important_nonurgent = findViewById(R.id.edit_important_nonurgent_button);
        unimportant_urgent = findViewById(R.id.edit_unimportant_urgent_button);
        unimportant_nonurgent = findViewById(R.id.edit_unimportant_nonurgent_button);

        saveChangesButton = findViewById(R.id.save_changes_button);
    }

    public TaskPriority getPriorityFromRadioButton(){
        if(important_urgent.isChecked()){
            return TaskPriority.IMPORTANT_URGENT;
        } else if(important_nonurgent.isChecked()){
            return TaskPriority.IMPORTANT_NONURGENT;
        } else if(unimportant_urgent.isChecked()){
            return TaskPriority.UNIMPORTANT_URGENT;
        } else if(unimportant_nonurgent.isChecked()){
            return TaskPriority.UNIMPORTANT_NONURGENT;
        } else
            return null;
    }

    public void onSaveChangesClick(View view){
        //TODO update database
//        String taskName = editTaskName.getText().toString();
//        String taskDetails = editTaskDetails.getText().toString();
//        TaskPriority taskPriority = getPriorityFromRadioButton();

        task.setTaskName(editTaskName.getText().toString());
        task.setTaskDetails(editTaskDetails.getText().toString());
        task.setPriority(getPriorityFromRadioButton());

        Intent intent = new Intent(EditTaskActivity.this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(EditTaskActivity.this, "Task updated!" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu){
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
