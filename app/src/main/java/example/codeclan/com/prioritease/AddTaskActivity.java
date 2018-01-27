package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
    }

    public void onSubmitButtonClicked(View view){
        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        //include a Toast
    }
}
