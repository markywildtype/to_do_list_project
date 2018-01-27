package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
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
        Intent intent = new Intent(this, ViewListActivity.class);
        startActivity(intent);
        Toast.makeText(AddTaskActivity.this, "New task added!" , Toast.LENGTH_SHORT).show();
    }
}
