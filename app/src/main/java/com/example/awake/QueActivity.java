package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class QueActivity extends AppCompatActivity {
    private HashMap<String,String> data;
    private TextView input_date,input_time,input_title,input_detail;
    private ImageView input_img;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_que);
        initView();
        getData();
        setData();
        Log.v("show",data.toString());
    }
    private void initView(){
        data = new HashMap<>();
        //取得View物件
        input_date = (TextView) findViewById(R.id.detail_date);
//        input_time = (TextView) findViewById(R.id.detail_time);
        input_title = (TextView) findViewById(R.id.que_title);
        input_detail = (TextView) findViewById(R.id.que_detail);
        input_img = (ImageView) findViewById(R.id.sdgs_btn);
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        data.put("date",bundle.getString("date"));
//        data.put("time",bundle.getString("time"));
        data.put("que",bundle.getString("que"));
        data.put("sdgs",bundle.getString("sdgs"));
        data.put("id",bundle.getString("id"));
        data.put("explanation",bundle.getString("explanation"));

    }

    private void setData(){
        input_date.setText(data.get("date"));
//        input_time.setText(data.get("time"));
        input_title.setText(data.get("que"));
        input_detail.setText(data.get("explanation"));
        String url = "@drawable/sdgs" + data.get("sdgs");
        input_img.setImageResource(getResources().getIdentifier(url,null,getPackageName()));
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
}