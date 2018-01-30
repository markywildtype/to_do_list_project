package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddTaskActivity extends MenuActivity {

    EditText taskName, taskDetails;
    RadioGroup priority;
    RadioButton important_urgent, important_nonurgent, unimportant_urgent, unimportant_nonurgent;
    Button submitNewTask;
    PrioritEaseDatabase db;

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
        submitNewTask = findViewById(R.id.submit_new_task_button);

        db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

    }

    public TaskPriority getPriorityFromRadioButton(){
        if(important_urgent.isChecked()){
            return TaskPriority.A_IMPORTANT_URGENT;
        } else if(important_nonurgent.isChecked()){
            return TaskPriority.C_IMPORTANT_NONURGENT;
        } else if(unimportant_urgent.isChecked()){
            return TaskPriority.B_UNIMPORTANT_URGENT;
        } else if(unimportant_nonurgent.isChecked()){
            return TaskPriority.D_UNIMPORTANT_NONURGENT;
        } else
            return null;
    }

    public void onSubmitButtonClicked(View view){
        String newTask = taskName.getText().toString();
        String details = taskDetails.getText().toString();
        TaskPriority taskPriority = getPriorityFromRadioButton();
        Task task = new Task(newTask, details, taskPriority, Complete.TO_DO);

        db.taskDao().addTask(task);

        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(AddTaskActivity.this, "New task added!" , Toast.LENGTH_SHORT).show();
    }
}
