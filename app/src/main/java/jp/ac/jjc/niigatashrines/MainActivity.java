package jp.ac.jjc.niigatashrines;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonListener listener = new ButtonListener();

        Button JoetsuB = findViewById(R.id.btnJoetsu);
        JoetsuB.setOnClickListener(listener);
        Button ChuetsuB = findViewById(R.id.btnChuetsu);
        ChuetsuB.setOnClickListener(listener);
        Button KaetsuB = findViewById(R.id.btnKaetsu);
        KaetsuB.setOnClickListener(listener);

        Button MannersB = findViewById(R.id.btnManners);
        MannersB.setOnClickListener(listener);
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = getIntent();
            int Id = view.getId();
            switch (Id){
                case R.id.btnJoetsu:
                    intent = new Intent(MainActivity.this, JoetsuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnChuetsu:
                    intent = new Intent(MainActivity.this, ChuetsuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnKaetsu:
                    intent = new Intent(MainActivity.this, KaetsuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btnManners:
                    intent = new Intent(MainActivity.this, MannersActivity.class);
                    startActivity(intent);
                    break;
            }

        }
    }
}
