package jp.ac.jjc.niigatashrines;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextDirectionHeuristic;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RecommendActivity extends AppCompatActivity {

    Random random = new Random();
    int i;
    String[] recommend = {"弥彦神社（弥彦村）", "白山神社（新潟市）", "湊稲荷神社（新潟市）", "新潟縣護国神社（新潟市）", "春日山神社（上越市）",
                            "居多神社（上越市）", "天津神社・奴奈川神社（糸魚川市）", "能生白山神社（糸魚川市）", "戸隠神社（燕市）", "御嶽山神社（柏崎市）",
                                "胞姫神社（柏崎市）", "春日神社（上越市）", "石動神社（小千谷市）"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        TextView txV = findViewById(R.id.recommendShrine);
        Button btn = findViewById(R.id.btnToTop);
        ToHomeListener listener = new ToHomeListener();
        btn.setOnClickListener(listener);

        i = random.nextInt(13);
        txV.setText(recommend[i]);
    }

    private class ToHomeListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(RecommendActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}