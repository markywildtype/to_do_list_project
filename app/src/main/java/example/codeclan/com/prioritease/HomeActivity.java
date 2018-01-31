package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button viewByPriorityButton, viewListButton, newTaskButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewListButton = findViewById(R.id.view_list_button);
        newTaskButton = findViewById(R.id.new_task_button);
        viewByPriorityButton = findViewById((R.id.view_multiple_lists_button));
    }

    public void onAddTaskButtonClicked(View button){
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    public void onViewListButtonClicked(View button){
        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
    }

    public void onViewByPriorityButtonClicked(View view){
        Intent intent = new Intent(this, MatrixActivity.class);
        startActivity(intent);
    }


}
