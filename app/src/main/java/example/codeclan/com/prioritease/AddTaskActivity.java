package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    EditText taskName;
    EditText taskDetails;
    RadioGroup priority;
    RadioButton important_urgent, important_nonurgent, unimportant_urgent, unimportant_nonurgent;
    Button submitNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskName = findViewById(R.id.task_name);
        taskDetails = findViewById(R.id.task_details);
        priority = findViewById(R.id.priority);
        important_urgent = findViewById(R.id.important_urgent_button);
        important_nonurgent = findViewById(R.id.important_nonurgent_button);
        unimportant_urgent = findViewById(R.id.unimportant_urgent_button);
        unimportant_nonurgent = findViewById(R.id.unimportant_nonurgent_button);
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

    public void onSubmitButtonClicked(View view){
        //TODO save to database
        String newTask = taskName.getText().toString();
        String details = taskDetails.getText().toString();
        TaskPriority taskPriority = getPriorityFromRadioButton();
        Task task = new Task(newTask, details, taskPriority);

        Log.d(getClass().toString(), task.getTaskName());
        Log.d(getClass().toString(), task.getTaskDetails());
        Log.d(getClass().toString(), task.getTaskPriority().name());

        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(AddTaskActivity.this, "New task added!" , Toast.LENGTH_SHORT).show();
    }
}
