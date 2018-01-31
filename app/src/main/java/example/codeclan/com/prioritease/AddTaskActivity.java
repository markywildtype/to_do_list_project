package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddTaskActivity extends MenuActivity implements AdapterView.OnItemSelectedListener{

    EditText taskName, taskDetails;
    RadioGroup priority;
    Spinner prioritySpinner;
    Button submitNewTask;
    PrioritEaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskName = findViewById(R.id.task_name);
        taskDetails = findViewById(R.id.task_details);
        priority = findViewById(R.id.priority);
        prioritySpinner = findViewById(R.id.priority_spinner);
        submitNewTask = findViewById(R.id.submit_new_task_button);


        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.priorities_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prioritySpinner.setAdapter(spinnerAdapter);

        db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

    }

    //Spinner methods
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String priority = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public TaskPriority getPriorityFromSpinner(){
        String selectedPriority = prioritySpinner.getSelectedItem().toString();
        switch(selectedPriority) {
            case "Important/Urgent":
                return TaskPriority.A_IMPORTANT_URGENT;
            case "Important/Non-urgent":
                return TaskPriority.B_IMPORTANT_NONURGENT;
            case "Unimportant/Urgent":
                return TaskPriority.C_UNIMPORTANT_URGENT;
            case "Unimportant/Non-urgent":
                return TaskPriority.D_UNIMPORTANT_NONURGENT;
        }
        return null;
    }

    public void onSubmitButtonClicked(View view){
        String newTask = taskName.getText().toString();
        String details = taskDetails.getText().toString();
        TaskPriority taskPriority = getPriorityFromSpinner();

        Task task = new Task(newTask, details, taskPriority, Complete.TO_DO);

        db.taskDao().addTask(task);

        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(AddTaskActivity.this, "New task added!" , Toast.LENGTH_SHORT).show();
    }
}
