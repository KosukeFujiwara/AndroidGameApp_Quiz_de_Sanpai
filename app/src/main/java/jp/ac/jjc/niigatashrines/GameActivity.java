package jp.ac.jjc.niigatashrines;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    final String[] Qtexts = {"神社の鳥居をくぐるときにはどうする？", "鳥居をくぐって参道を歩いています。意識すべきは？", "手水舎の前につきました。ここですべきは？",
                                "手水の手順で正しいのはどれ？", "お賽銭を入れ、頭上に鈴があれば鳴らします。この際意識することは？", "さあ、礼拝です。一般的に推奨されるのはどれ？",
                                "お参りで拍手をする際、気を付けることは？"};

    final String[][] Atexts = {{"神域に入るため「失礼します」と軽く一礼する", "堂々と大手を振って入場する", "キリストへの信心深さを示すため、十字を切る"},
                                {"参道は神様の通り道なので、中央を避けて端のほうを歩く", "正々堂々、大手を振って中央を歩く", "犬の散歩ついでに、その辺にフンを置きながら歩く"},
                                {"心身の浄化をする","なんとなく、みんなやっているからやる","意味なんてあるはずがない"},
                                {"右手に柄杓を持ち左手を洗い、持ち替えて右手を、最後にまた右手に持ち替えて口を軽くゆすぐ", "適当に水を手にかけるフリをする","豪快にやった方が面白いので、頭から水をできるだけ沢山かける"},
                                {"神様を「これからお参りしますよ」とお呼びする","儀式的なもので深い意味はなさそう","無意味だからやるだけ無駄"},
                                {"二礼二拍一礼","ビジネスにおける軽い会釈程度の礼で大丈夫","神がなんぼのもんじゃ、礼など不要"},
                                {"なるべく大きく手を叩く","自信がないのであまり音をたてずそーっと叩く","静かに手を合わせ、南無阿弥陀仏を唱える"}};

    final String TitleOK = "正解！";
    final String TitleNG = "不正解…";
    final String TitleClear = "クリア！";
    final String TitleTooBad = "この罰当たりめが！";

    int i;
    boolean[] NumList = new boolean[7];
    Random random = new Random();
    AlertDialog.Builder builder;
    private int AnswerSelect = 0;
    private String RightAnswer;
    private String WrongAnswer;
    private String BadAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        for (int j = 0; j <= 6; j++) {
            NumList[j] = false;
        }

        builder = new AlertDialog.Builder(this);
        i=1;

        ButtonListener listener = new ButtonListener();
        Button AnsBtn1 = findViewById(R.id.ans1);
        AnsBtn1.setOnClickListener(listener);
        Button AnsBtn2 = findViewById(R.id.ans2);
        AnsBtn2.setOnClickListener(listener);
        Button AnsBtn3 = findViewById(R.id.ans3);
        AnsBtn3.setOnClickListener(listener);

        TextView Qnum = findViewById(R.id.questionNum);
        TextView Qtext = findViewById(R.id.questionText);

        Qnum.setText("第1問");

        int NumQ = random.nextInt(7);
        //if (NumList[NumQ] == false) {
            Qtext.setText(Qtexts[NumQ]);
            RightAnswer = Atexts[NumQ][0];
            WrongAnswer = Atexts[NumQ][1];
            BadAnswer = Atexts[NumQ][2];
            int R1 = random.nextInt(3);
            switch (R1){
                case 0:
                    AnsBtn1.setText(Atexts[NumQ][0]);
                    AnsBtn2.setText(Atexts[NumQ][1]);
                    AnsBtn3.setText(Atexts[NumQ][2]);
                break;
                case 1:
                    AnsBtn1.setText(Atexts[NumQ][1]);
                    AnsBtn2.setText(Atexts[NumQ][2]);
                    AnsBtn3.setText(Atexts[NumQ][0]);
                break;
                case 2:
                    AnsBtn1.setText(Atexts[NumQ][2]);
                    AnsBtn2.setText(Atexts[NumQ][0]);
                    AnsBtn3.setText(Atexts[NumQ][1]);
                break;
            }
            //AnsBtn1.setText(Atexts[NumQ][0]);
            //AnsBtn2.setText(Atexts[NumQ][1]);
            //AnsBtn3.setText(Atexts[NumQ][2]);
            NumList[NumQ] = true;
            //count++;
        //}
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
    /*public void checkAnswer(View view){
            Button ansBtn = findViewById(view.getId());
            String btnText = ansBtn.getText().toString();
            if(btnText.equals(RightAnswer)){
                AnswerSelect = 0;
            }else if(btnText.equals(WrongAnswer)){
                AnswerSelect = 1;
            }else if(btnText.equals(BadAnswer)){
                AnswerSelect = 2;
            }
        }*/

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //int ID = view.getId();
            Button ansBtn = findViewById(view.getId());
            String btnText = ansBtn.getText().toString();
            if(btnText.equals(RightAnswer)){
                AnswerSelect = 0;
            }else if(btnText.equals(WrongAnswer)){
                AnswerSelect = 1;
            }else if(btnText.equals(BadAnswer)){
                AnswerSelect = 2;
            }

            switch (/*ID*/AnswerSelect) {
                case /*R.id.ans1*/0:
                    if (i < Qtexts.length) {
                        builder.setTitle(TitleOK);
                        builder.setPositiveButton("次の問題へ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView Qtext = findViewById(R.id.questionText);
                                TextView Qnum = findViewById(R.id.questionNum);
                                Button AnsBtn1 = findViewById(R.id.ans1);
                                Button AnsBtn2 = findViewById(R.id.ans2);
                                Button AnsBtn3 = findViewById(R.id.ans3);
                                int NumQ = random.nextInt(7);
                                if (i <= Qtexts.length) {
                                    if (!NumList[NumQ]) {
                                        i++;
                                        String S = "第" + i + "問";
                                        Qnum.setText(S);
                                        Qtext.setText(Qtexts[NumQ]);
                                        RightAnswer = Atexts[NumQ][0];
                                        WrongAnswer = Atexts[NumQ][1];
                                        BadAnswer = Atexts[NumQ][2];
                                        int R2 = random.nextInt(3);
                                        switch (R2){
                                            case 0:
                                                AnsBtn1.setText(Atexts[NumQ][0]);
                                                AnsBtn2.setText(Atexts[NumQ][1]);
                                                AnsBtn3.setText(Atexts[NumQ][2]);
                                                break;
                                            case 1:
                                                AnsBtn1.setText(Atexts[NumQ][1]);
                                                AnsBtn2.setText(Atexts[NumQ][2]);
                                                AnsBtn3.setText(Atexts[NumQ][0]);
                                                break;
                                            case 2:
                                                AnsBtn1.setText(Atexts[NumQ][2]);
                                                AnsBtn2.setText(Atexts[NumQ][0]);
                                                AnsBtn3.setText(Atexts[NumQ][1]);
                                                break;
                                        }
                                        NumList[NumQ] = true;
                                    } else {
                                        if(i<=Qtexts.length)
                                        onClick(dialog, which);
                                    }
                                }
                            }
                        });
                        builder.show();
                    } else {
                        builder.setTitle(TitleClear);
                        builder.setPositiveButton("おめでとうございます！あなたへのおススメの神社はこちら！", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(GameActivity.this, RecommendActivity.class);
                                        startActivity(intent);
                                    }
                                }
                        );
                        builder.show();
                    }
                break;
                case /*R.id.ans2*/ 1:
                    builder.setTitle(TitleNG);
                    builder.setPositiveButton("選びなおす", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                break;
                case /*R.id.ans3*/ 2:
                    ImageView imv = new ImageView(getApplicationContext());
                    imv.setImageResource(R.drawable.kanden_gaikotsu);
                    builder.setTitle(TitleTooBad);
                    builder.setView(imv);
                    builder.setPositiveButton("修行し直す", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    });
                    builder.show();
                    //System.exit(0);
                    //finish();
                    //Process.killProcess(Process.myPid());
                break;
            }
        }
    }
}
