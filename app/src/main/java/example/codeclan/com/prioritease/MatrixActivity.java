package example.codeclan.com.prioritease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MatrixActivity extends MenuActivity {

    ImageButton impUrButton, impNonUrButton, unimpUrButton, unimpNonUrButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        impUrButton = findViewById(R.id.imp_ur_button);
        impNonUrButton = findViewById(R.id.imp_nonur_button);
        unimpUrButton = findViewById(R.id.unimp_ur_button);
        unimpNonUrButton = findViewById(R.id.unimp_nonur_button);
    }

    public void onClickImpUrButton(View view){
        Intent intent = new Intent(this, ImpUrListActivity.class);
        startActivity(intent);
    }
}
