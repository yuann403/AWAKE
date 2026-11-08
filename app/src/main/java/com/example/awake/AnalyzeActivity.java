package com.example.awake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnalyzeActivity extends AppCompatActivity {
    private TextView input_date,input_time;
    private ImageView input_environment,input_economic,input_social;
    //private GradientDrawable environment_background,economic_background,social_background;
    private String email,name,date;
    private int environment,economic,social;
    private int environment_color,economic_color,social_color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);
        initView();
        getData();
        setData();
    }

    private void initView(){
        //取得View物件
        input_date = (TextView) findViewById(R.id.game_history);
        input_time = (TextView) findViewById(R.id.history_video_time);
        input_environment = (ImageView) findViewById(R.id.environment_btn);
        input_economic = (ImageView)  findViewById(R.id.economic_btn);
        input_social = (ImageView)  findViewById(R.id.social_btn);
//        environment_background = (GradientDrawable) input_environment.getBackground();
//        economic_background = (GradientDrawable) input_economic.getBackground();
//        social_background = (GradientDrawable) input_social.getBackground();
    }
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        name = bundle.getString("name");
        date = bundle.getString("date");
        environment = Integer.valueOf(bundle.getString("environment"));
        economic = Integer.valueOf(bundle.getString("economic"));
        social = Integer.valueOf(bundle.getString("social"));
    }
    private void setData(){
        input_environment.setImageResource(setEnvironmentColor(environment));
        input_economic.setImageResource(setEconomicColor(economic));
        input_social.setImageResource(setSocialColor(social));
//        environment_color = setEnvironmentColor(environment);
//        economic_color = setEconomicColor(economic);
//        social_color = setSocialColor(social);
//        environment_background.setColor(Color.parseColor(environment_color));
//        economic_background.setColor(Color.parseColor(economic_color));
//        social_background.setColor(Color.parseColor(social_color));

        input_date.setText(date);
//        input_environment.setText(environment+"");
//        input_economic.setText(economic+"");
//        input_social.setText(social+"");
    }
    @NonNull
    private int setEnvironmentColor(int c){
        if(c>=-90&&c<=-75){
            //return "#FF4325";
            environment_color = R.drawable.face7;
        }
        else if(c>=-70&&c<=-35){
            //return "#FF7A39";
            environment_color = R.drawable.face6;
        }
        else if(c>=-30&&c<=5){
            //return "#FFB44E";
            environment_color = R.drawable.face5;
        }
        else if(c>=10&&c<=25){
            //return "#FFE660";
            environment_color = R.drawable.face4;
        }
        else if(c>=30&&c<=65){
            //return "#D5EF4D";
            environment_color = R.drawable.face3;
        }
        else if(c>=70&&c<=105){
            //return "#ADF83B";
            environment_color = R.drawable.face2;
        }
        else if(c>=110&&c<=125){
            //return "#8EFF2D";
            environment_color = R.drawable.face1;
        }
        else{
            environment_color = R.drawable.face_error;
        }
//        return "#000000";
        return environment_color;
    }

    @NonNull
    private int setEconomicColor(int c){
        if(c>=-20&&c<=-5){
            //return "#FF4325";
            economic_color = R.drawable.face7;
        }
        else if(c>=0&&c<=35){
            //return "#FF7A39";
            economic_color = R.drawable.face6;
        }
        else if(c>=40&&c<=75){
            //return "#FFB44E";
            economic_color = R.drawable.face5;
        }
        else if(c>=80&&c<=95){
            //return "#FFE660";
            economic_color = R.drawable.face4;
        }
        else if(c>=100&&c<=135){
            //return "#D5EF4D";
            economic_color = R.drawable.face3;
        }
        else if(c>=140&&c<=175){
            //return "#ADF83B";
            economic_color = R.drawable.face2;
        }
        else if(c>=180&&c<=195){
            //return "#8EFF2D";
            economic_color = R.drawable.face1;
        }
        else{
            economic_color = R.drawable.face_error;
        }
        //return "#000000";
        return economic_color;
    }

    @NonNull
    private int setSocialColor(int c){
        if(c>=-25&&c<=-10){
            //return "#FF4325";
            social_color = R.drawable.face7;
        }
        else if(c>=-5&&c<=25){
            //return "#FF7A39";
            social_color = R.drawable.face6;
        }
        else if(c>=30&&c<=60){
            //return "#FFB44E";
            social_color = R.drawable.face5;
        }
        else if(c>=65&&c<=80){
            //return "#FFE660";
            social_color = R.drawable.face4;
        }
        else if(c>=85&&c<=115){
            //return "#D5EF4D";
            social_color = R.drawable.face3;
        }
        else if(c>=120&&c<=150){
            //return "#ADF83B";
            social_color = R.drawable.face2;
        }
        else if(c>=155&&c<=170){
            //return "#8EFF2D";
            social_color = R.drawable.face1;
        }
        else{
            social_color = R.drawable.face_error;
        }
        //return "#000000";
        return social_color;
    }

    public void changeToEnvironmentDetailPage(View view) {
        Intent intent = new Intent(this,AnalyzeDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("name",name);
        bundle.putString("date",date);
        bundle.putString("title","environment");
        bundle.putString("score",environment+"");
        bundle.putInt("color",environment_color);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToEconomicDetailPage(View view) {
        Intent intent = new Intent(this,AnalyzeDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("name",name);
        bundle.putString("date",date);
        bundle.putString("title","economic");
        bundle.putString("score",economic+"");
        bundle.putInt("color",economic_color);

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void changeToSocialDetailPage(View view) {
        Intent intent = new Intent(this,AnalyzeDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("name",name);
        bundle.putString("date",date);
        bundle.putString("title","social");
        bundle.putString("score",social+"");
        bundle.putInt("color",social_color);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void changeToImgPage(View view) {
        Intent intent = new Intent(this, ImagesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        bundle.putString("name",name);
        bundle.putString("date",date);
        intent.putExtras(bundle);
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
}