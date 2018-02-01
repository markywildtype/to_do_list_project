package example.codeclan.com.prioritease;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends MenuActivity {

    ImageButton viewByPriorityImageButton, viewListImageButton, newTaskImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewListImageButton = findViewById(R.id.view_list_image_button);
        newTaskImageButton = findViewById(R.id.add_task_image_button);
        viewByPriorityImageButton = findViewById(R.id.view_multiple_lists_image_button);
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
