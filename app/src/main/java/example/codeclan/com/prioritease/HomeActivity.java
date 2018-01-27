package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
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

    //Menu unnecessary on this page?
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.activity_main, menu);
//        return true;
//    }

    public void onAddTaskButtonClicked(View button){
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    public void onViewListButtonClicked(View button){
        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
    }


}
