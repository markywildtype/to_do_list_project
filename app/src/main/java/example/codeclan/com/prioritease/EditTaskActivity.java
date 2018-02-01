package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class EditTaskActivity extends MenuActivity implements AdapterView.OnItemSelectedListener{

    EditText editTaskName;
    EditText editTaskDetails;
    Spinner editPrioritySpinner;
    RadioButton to_do, in_progress, complete;
    ImageButton saveChangesButton;
    Task task;
    PrioritEaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        editPrioritySpinner = findViewById(R.id.edit_priority_spinner);

        ArrayAdapter<CharSequence> editSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.edit_priorities_array, android.R.layout.simple_spinner_item);
        editSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editPrioritySpinner.setAdapter(editSpinnerAdapter);

        db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();


        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");

        editTaskName = findViewById(R.id.edit_task_name);
        editTaskName.setText(task.getTaskName());

        editTaskDetails = findViewById(R.id.edit_task_details);
        editTaskDetails.setText(task.getTaskDetails());

        to_do = findViewById(R.id.to_do);
        in_progress = findViewById(R.id.in_progress);
        complete = findViewById(R.id.complete);

        saveChangesButton = findViewById(R.id.save_changes_image_button);
    }


    public Complete getCompletionStatusFromRadioButton(){
        if(to_do.isChecked()){
            return Complete.TO_DO;
        } else if(in_progress.isChecked()){
            return Complete.IN_PROGRESS;
        } else if(complete.isChecked()){
            return Complete.COMPLETE;
        } else
            return null;
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
        String selectedPriority = editPrioritySpinner.getSelectedItem().toString();
        switch(selectedPriority) {
            case "-----------Select-----------":
                return null;
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

    public void onSaveChangesClick(View view){
        task.setTaskName(editTaskName.getText().toString());
        task.setTaskDetails(editTaskDetails.getText().toString());
        if(getPriorityFromSpinner() != null){
            task.setPriority(getPriorityFromSpinner());
        }
        if(getCompletionStatusFromRadioButton() != null){
            task.setCompletionStatus(getCompletionStatusFromRadioButton());
        }

        db.taskDao().updateTask(task);

        Intent intent = new Intent(EditTaskActivity.this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(EditTaskActivity.this, "Task updated!" , Toast.LENGTH_SHORT).show();
    }
}
