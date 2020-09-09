package jp.ac.jjc.niigatashrines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MannersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manners);

        StartButtonListener StartListener = new StartButtonListener();
        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(StartListener);
    }

    private class StartButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(MannersActivity.this, GameActivity.class);
            startActivity(intent);
        }
    }
}