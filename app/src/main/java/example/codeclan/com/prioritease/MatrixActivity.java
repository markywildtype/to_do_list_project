package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MatrixActivity extends MenuActivity {

    ImageButton impUrButton, impNonUrButton, unimpUrButton, unimpNonUrButton;
    TextView iNCount, iUCount, uNCount, uUCount;
//    PrioritEaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        impUrButton = findViewById(R.id.imp_ur_button);
        impNonUrButton = findViewById(R.id.imp_nonur_button);
        unimpUrButton = findViewById(R.id.unimp_ur_button);
        unimpNonUrButton = findViewById(R.id.unimp_nonur_button);
        iNCount = findViewById(R.id.i_n_count);
        iUCount = findViewById(R.id.i_u_count);
        uNCount = findViewById(R.id.u_n_count);
        uUCount = findViewById(R.id.u_u_count);

        PrioritEaseDatabase db = Room.databaseBuilder(getApplicationContext(), PrioritEaseDatabase.class, "prioritease database").allowMainThreadQueries().build();

        String iN = Integer.toString(db.taskDao().getAllImpNonUrTasks().size());
        String iU = Integer.toString(db.taskDao().getAllImpUrTasks().size());
        String uN = Integer.toString(db.taskDao().getAllUnimpNonUrTasks().size());
        String uU = Integer.toString(db.taskDao().getAllUnimpUrTasks().size());

        iNCount.setText("Tasks: " + iN);
        iUCount.setText("Tasks: " + iU);
        uNCount.setText("Tasks: " + uN);
        uUCount.setText("Tasks: " + uU);

    }

    public void onClickImpUrButton(View view){
        Intent intent = new Intent(this, ViewListActivity.class);
        intent.putExtra("matrix pos", "IU");
        startActivity(intent);
    }

    public void onClickImpNonUrButton(View view){
        Intent intent = new Intent(this, ViewListActivity.class);
        intent.putExtra("matrix pos", "IN");
        startActivity(intent);
    }

    public void onClickUnimpUrButton(View view){
        Intent intent = new Intent(this, ViewListActivity.class);
        intent.putExtra("matrix pos", "UU");
        startActivity(intent);
    }

    public void onClickUnimpNonUrButton(View view){
        Intent intent = new Intent(this, ViewListActivity.class);
        intent.putExtra("matrix pos", "UN");
        startActivity(intent);
    }
}
