package jp.ac.jjc.niigatashrines;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final String Qtexts[] = {"神社の鳥居をくぐるときにはどうする？", "鳥居をくぐって参道を歩いています。意識すべきは？", "手水舎の前につきました。ここですべきは？",
            "手水の手順で正しいのはどれ？", "お賽銭を入れたら、頭上に鈴があれば鳴らします・この際意識することは？", "さあ、礼拝です。一般的に推奨されるのはどれ？",
            "拍手をする際、気を付けることは？"};
    /*
    final String Q1 = "神社の鳥居をくぐるときにはどうする？";
    final String Q2 = "鳥居をくぐって参道を歩いています。意識すべきは？";
    final String Q3 = "手水舎の前につきました。ここですべきは？";
    final String Q4 = "手水の手順で正しいのはどれ？";
    final String Q5 = "お賽銭を入れたら、頭上に鈴があれば鳴らします・この際意識することは？";
    final String Q6 = "さあ、礼拝です。一般的に推奨されるのはどれ？";
    final String Q7 = "拍手をする際、気を付けることは？"; */

    final String A1_1 = "神域に入るため「失礼します」と軽く一礼する。";
    final String A1_2 = "堂々と大手を振って入場する。";
    final String A1_3 = "信心深さを示すため、十字を切る。";
    final String A2_1 = "参道は神様の通り道なので、中央を避けて端のほうを歩く。";
    final String A2_2 = "正々堂々、中央を大手を振って歩く。";
    final String A2_3 = "犬の散歩ついでに、その辺にフンを置きながら歩く。";
    final String A3_1 = "";
    final String A3_2 = "";
    final String A3_3 = "";
    final String A4_1 = "";
    final String A4_2 = "";
    final String A4_3 = "";
    final String A5_1 = "";
    final String A5_2 = "";
    final String A5_3 = "";
    final String A6_1 = "";
    final String A6_2 = "";
    final String A6_3 = "";
    final String A7_1 = "";
    final String A7_2 = "";
    final String A7_3 = "";
    final String TitleOK = "正解！";
    final String TitleNG = "不正解…";

    //String[][] At = new String[7][3];
    //At[0][0] = "神域に入るため「失礼します」と軽く一礼する。";

    Random random = new Random();
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        builder = new AlertDialog.Builder(this);

        ButtonListener listener = new ButtonListener();

        Button AnsBtn1 = findViewById(R.id.ans1);
        AnsBtn1.setOnClickListener(listener);
        Button AnsBtn2 = findViewById(R.id.ans2);
        AnsBtn1.setOnClickListener(listener);
        Button AnsBtn3 = findViewById(R.id.ans3);
        AnsBtn1.setOnClickListener(listener);

        TextView Qnum = findViewById(R.id.questionNum);
        TextView Qtext = findViewById(R.id.questionText);

        Qnum.setText("第1問");

        int NumQ = random.nextInt(6);
        Qtext.setText(Qtexts[NumQ]); //NumQは配列番号なので、何か足したりせずそのままでOK！！

        int NumA = random.nextInt(2) +1;
        switch(NumA){
            case 1 : AnsBtn1.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1)); //Ansのbtn1にA〇_△の何番目を入れるか！
                int Num1 = random.nextInt(1);
                switch (Num1){
                    case 0 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(3));
                             break;
                    case 1 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(3));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));
                             break;
                        }
            break;
            case 2 : AnsBtn1.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));
                int Num2 = random.nextInt(1);
                switch (Num2){
                    case 0 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(3));
                             break;
                    case 1 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(3));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1));
                             break;
                }
            break;
            case 3 : AnsBtn1.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(3));
                int Num3 = random.nextInt(1);
                switch (Num3){
                    case 0 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));
                             break;
                    case 1 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));
                             AnsBtn3.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1));
                             break;
                }
            break;
        }
    }

    private class ButtonListener implements View.OnClickListener{
        @Override
            public void onClick(View view){

                builder.setTitle(TitleOK);



        }
    }
}