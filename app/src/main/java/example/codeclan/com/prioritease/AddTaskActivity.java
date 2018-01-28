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
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    EditText taskName;
    EditText taskDetails;
    RadioGroup priority;
//    Button submitNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        taskName = findViewById(R.id.task_name);
        taskDetails = findViewById(R.id.task_details);
        priority = findViewById(R.id.priority);
//        submitNewTask = findViewById(R.id.submit_new_task_button);

//        submitNewTask.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }

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

    public void onSubmitButtonClicked(View view){
        //TODO save to database
        Log.d(getClass().toString(), taskName.getText().toString());
        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(AddTaskActivity.this, "New task added!" , Toast.LENGTH_SHORT).show();
    }
}
