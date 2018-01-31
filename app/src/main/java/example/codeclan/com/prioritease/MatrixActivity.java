package example.codeclan.com.prioritease;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

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

//        iNCount.setText(db.taskDao().getAllUnimpNonUrTasks().size());
//        iUCount.setText(db.taskDao().getAllImpUrTasks().size());
//        uNCount.setText(db.taskDao().getAllUnimpNonUrTasks().size());
//        uUCount.setText(db.taskDao().getAllUnimpUrTasks().size());
    }

    public void onClickImpUrButton(View view){
        Intent intent = new Intent(this, ImpUrListActivity.class);
        startActivity(intent);
    }

    public void onClickImpNonUrButton(View view){
        Intent intent = new Intent(this, ImpNonUrListActivity.class);
        startActivity(intent);
    }

    public void onClickUnimpUrButton(View view){
        Intent intent = new Intent(this, UnimpUrListActivity.class);
        startActivity(intent);
    }

    public void onClickUnimpNonUrButton(View view){
        Intent intent = new Intent(this, UnimpNonUrListActivity.class);
        startActivity(intent);
    }
}
