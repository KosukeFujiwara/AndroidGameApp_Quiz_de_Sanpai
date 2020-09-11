package jp.ac.jjc.niigatashrines;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final String[] Qtexts = {"神社の鳥居をくぐるときにはどうする？", "鳥居をくぐって参道を歩いています。意識すべきは？", "手水舎の前につきました。ここですべきは？",
            "手水の手順で正しいのはどれ？", "お賽銭を入れたら、頭上に鈴があれば鳴らします・この際意識することは？", "さあ、礼拝です。一般的に推奨されるのはどれ？",
            "拍手をする際、気を付けることは？"};

    final String[][] Atexts = {{"神域に入るため「失礼します」と軽く一礼する。", "堂々と大手を振って入場する。", "キリストへの信心深さを示すため、十字を切る。"},
            {"参道は神様の通り道なので、中央を避けて端のほうを歩く。", "正々堂々、中央を大手を振って歩く。", "犬の散歩ついでに、その辺にフンを置きながら歩く。"},
            {"心身の浄化をする。","なんとなく、みんなやっているからやる。","意味なんてない。"},
            {"右手に柄杓を持ち、左手→持ち替えて右手を洗い、最後に口を軽くゆすぐ。", "適当に水を手にかけるフリをする。","身を清めるため、頭から水をできるだけ沢山かける。"},
            {"神様を「これからお参りしますよ」とお呼びする。","儀式的なもので深い意味はなさそう。","無意味だからやるだけ無駄。"},
            {"二礼二拍一礼","ビジネスにおける軽い会釈程度の例で大丈夫","神がなんぼのもんじゃ、礼など不要"},
            {"なるべく大きく手を叩く","自信がないのであまり音をたてずそーっと叩く","静かに手を合わせ、南無阿弥陀仏を唱える"}};

    final String TitleOK = "正解！";
    final String TitleNG = "不正解…";
    final String TitleClear = "クリア！";
    final String TitleTooBad = "この不届き者が！";

    int i = 1;
    boolean NumList[];
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

        ImageView imageView = findViewById(R.id.imV);

        for (int j = 0; j <= 6; j++) {
            NumList[j] = false;
        }

        Qnum.setText("第1問");
        //int count = 0;
        //while (count < Qtexts.length) {
        int NumQ = random.nextInt(6);
        if (NumList[NumQ] == false) {
            Qtext.setText(Qtexts[NumQ]); //NumQは配列番号なので、何か足したりせずそのままでOK！！
            AnsBtn1.setText(Atexts[NumQ][1]);
            AnsBtn2.setText(Atexts[NumQ][2]);
            AnsBtn3.setText(Atexts[NumQ][3]);
            NumList[NumQ] = true;
            //count++;
        }
    }
        /*
        int NumA = random.nextInt(2) +1;
        switch(NumA){
            case 1 : AnsBtn1.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(1)); //Ansのbtn1にA〇_△の何番目を入れるか！
                int Num1 = random.nextInt(1);
                switch (Num1){
                    case 0 : AnsBtn2.setText("A" + String.valueOf(NumQ) + "_" + String.valueOf(2));   //AnsBtn2.setText(A1_2);
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
        }*/

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int ID = view.getId();
            ImageView imV = findViewById(R.id.imV);

            switch (ID) {
                case R.id.ans1:
                    if (i < 7) {
                        builder.setTitle(TitleOK);
                        builder.setPositiveButton("次の問題へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int count = 1;
                                TextView Qtext = findViewById(R.id.questionText);
                                TextView Qnum = findViewById(R.id.questionNum);
                                Button AnsBtn1 = findViewById(R.id.ans1);
                                Button AnsBtn2 = findViewById(R.id.ans2);
                                Button AnsBtn3 = findViewById(R.id.ans3);
                                while (count < Qtexts.length) {
                                    Qnum.setText("第" + i + "問");
                                    int NumQ = random.nextInt(6);
                                    if (NumList[NumQ] == false) {
                                        Qtext.setText(Qtexts[NumQ]);
                                        AnsBtn1.setText(Atexts[NumQ][1]);
                                        AnsBtn2.setText(Atexts[NumQ][2]);
                                        AnsBtn3.setText(Atexts[NumQ][3]);
                                        NumList[NumQ] = true;
                                        count++;
                                        i++;
                                    }
                                }
                            }
                        });
                    } else {
                        builder.setTitle(TitleClear);
                        builder.setPositiveButton("おめでとうございます！あなたにおススメの神社はこちら！", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(GameActivity.this, RecommendActivity.class);
                                        startActivity(intent);
                                    }
                                }

                        );
                    }
                case R.id.ans2:
                    builder.setTitle(TitleNG);
                    builder.setPositiveButton("選びなおす", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                case R.id.ans3:
                    builder.setTitle(TitleTooBad);
                    imV.setImageResource(R.drawable.kanden_gaikotsu);
                    //System.exit(0);
                    finish();
            }
        }
    }
}
