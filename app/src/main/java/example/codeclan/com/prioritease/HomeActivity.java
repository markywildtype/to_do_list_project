package example.codeclan.com.prioritease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button viewListButton;
    Button newTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewListButton = findViewById(R.id.view_list_button);
        newTaskButton = findViewById(R.id.new_task_button);
    }

    public void onAddTaskButtonClicked(){

    }


}
