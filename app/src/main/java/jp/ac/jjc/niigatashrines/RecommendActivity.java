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
    final String[] recommend = {"彌彦神社（弥彦村）", "白山神社（新潟市）", "湊稲荷神社（新潟市）", "新潟縣護国神社（新潟市）", "春日山神社（上越市）",
                            "居多神社（上越市）", "天津神社・奴奈川神社（糸魚川市）", "能生白山神社（糸魚川市）", "戸隠神社（燕市）", "御嶽山神社（柏崎市）",
                                "胞姫神社（柏崎市）", "春日神社（上越市）", "石動神社（小千谷市）","度津神社（佐渡市羽茂）","宝徳山稲荷大社（長岡市）"};
    final String[] recommendText = {"越後国一宮の一つで、初詣の参拝者数は県内トップ。御祭神は天照大神の曾孫の天香山命（あめのかごやまのみこと）で、創建は紀元前という、古くて格式高い神社。万葉集にも登場。弥彦山山頂には奥宮もある。",
                "新潟総鎮守として知られ、初詣の参拝者数は県内二位。加賀の霊峰白山頂上に祀られる菊理媛大神（白山大神）を勧請。縁結びにご利益。敷地内裏のほうにも色々な神社が…？",
                "享保元年より300余年の歴史を持ち、回る狛犬「願懸の高麗犬」で知られる。昔、花街の女性達が港から船乗りが出て行かないよう、高麗犬の向きを変え、荒天祈願をしていたが、いつしか様々な願いを持った人々が訪れるようになったという。",
                "新潟県関係の殉国の英霊を祀る。初詣の参拝者数は県内三位。マリンピア日本海のすぐ近くにある。",
                "米沢市の上杉神社より分霊、上杉謙信公を祀る。それゆえ勝負事の祈願に訪れる人も多い。本殿近くで書置きの御朱印が貰えるが、受付のおばさんの愛想が悪いと評判。駐車場からの階段がキツい。時間があれば春日山城跡の散策もアリか。",
                "越後国一宮の一つ。かつて親鸞聖人も訪れたといい、それにまつわる越後七不思議の第一番「片葉葦」が群生していることでも知られているう。市内の某有名企業も新店舗の地鎮祭はここにお願いしているとかなんとか。個性的な筆跡の御朱印が印象的。",
                "天津神社は越後国一宮で、春の大祭にて奉納される舞楽は、国の重要無形民俗文化財に指定されている。奴奈川神社は境内社。",
                "本殿は室町時代の特色を残す国指定重要文化財で、春季大祭では国指定重要無形民俗文化財の舞楽が奉納される。海沿いの弁天岩（糸魚川ジオパークのジオサイト）には末社の厳島神社もあり。",
                "信州戸隠神社より分霊。かつて祠を守るように燕が群れていたため、付近が燕の村と呼ばれるようになった（現在の燕市の名前の由来）との説がある。境内には、全国でも珍しいお菓子の神様を祀る「菓祖社」も。",
                "御嶽大神を祀る。素焼きのお皿（100円）を購入して、三回息を吹きかけてから石に投げつけて皿を割り、厄を祓うという「厄割り石」が有名。",
                "「胞」とは胞衣（えな：胎児を包む膜や胎盤のこと）を意味し、安産・子授けの神として知られる。伝承では、奥州に逃れる途中で寄った源義経の嫡男出産が、当神社の縁起の起こりであるという。国道8号沿いのすごいところにある。",
                "奈良の春日大社より分霊され、春日大社の記録では全国の春日神社の中で最初に出てくる。当初は春日山山頂に創建されるが、春日山城築城の際に城の鬼門の位置に遷座、現在に至る。2020年4月、約200年ぶりに建て替えられて綺麗に。",
                "読みは「いするぎじんじゃ」。錦鯉と牛の角突きの天井画がある。オリジナル御朱印長が特徴的。現在の外見はあまり神社っぽくなく、一軒家と一体化したような形態となっている。",
                "読みは「わたつじんじゃ」。佐渡一ノ宮を称する。五十猛命を御祭神に、陸上海上の守護神として信仰を集める、古来より格式高い神社。しかし古文書が洪水で流失しており、創建年代などは明らかでないという。",
                "その由緒は縄文時代にまで遡り、持統天皇の御代には越国総鎮守一ノ宮を賜ったという。現在の社殿は大変立派で圧巻のスケールを持ち、目の前にするとお金の匂いを感じずにはいられないが、そのようなこと決して口にしてはいけない。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        TextView txV = findViewById(R.id.recommendShrine);
        TextView txV2 = findViewById(R.id.recommendText);
        Button btn = findViewById(R.id.btnToTop);
        ToHomeListener listener = new ToHomeListener();
        btn.setOnClickListener(listener);

        i = random.nextInt(15);
        txV.setText(recommend[i]);
        txV2.setText(recommendText[i]);
    }

    private class ToHomeListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent intent = new Intent(RecommendActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}