package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class IntroduceActivity extends AppCompatActivity {

    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
        getData();
    }
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
    }

    public void searchToSDGs (View view){
        String link = "https://sdgs.un.org";
        Log.v("show", "SDGsNews: "+link);

        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }

    public void changeToStudyPage(View view) {
        Intent intent = new Intent(this,StudyActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);;
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToStatisticsPage(View view) { //換頁
        Intent intent = new Intent(this,StatisticsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);;
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToMainPage(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void changeToHomePage(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void changeToIntroduceDetailPage01(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","01");
        bundle.putString("title","SDGs1 終結貧窮");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage02(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","02");
        bundle.putString("title","SDGs2 消除飢餓");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage03(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","03");
        bundle.putString("title","SDGs3 健康與福祉");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage04(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","04");
        bundle.putString("title","SDGs4 優質教育");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage05(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","05");
        bundle.putString("title","SDGs5 性別平權");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage06(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","06");
        bundle.putString("title","SDGs6 淨水及衛生");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage07(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","07");
        bundle.putString("title","SDGs7 可負擔的潔淨能源");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage08(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","08");
        bundle.putString("title","SDGs8 合適的工作及經濟成長");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage09(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","09");
        bundle.putString("title","SDGs9 工業化、創新及基礎建設");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage10(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","10");
        bundle.putString("title","SDGs10 減少不平等");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage11(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","11");
        bundle.putString("title","SDGs11 永續城鄉");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage12(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","12");
        bundle.putString("title","SDGs12 責任消費及生產");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage13(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","13");
        bundle.putString("title","SDGs13 氣候行動");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage14(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","14");
        bundle.putString("title","SDGs14 保育海洋生態");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage15(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","15");
        bundle.putString("title","SDGs15 保育陸域生態");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage16(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","16");
        bundle.putString("title","SDGs16 和平、正義及健全制度");
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToIntroduceDetailPage17(View view) {
        Intent intent = new Intent(this,IntroduceDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("sdgs","17");
        bundle.putString("title","SDGs17 多元夥伴關係");
        intent.putExtras(bundle);
        startActivity(intent);
    }
}