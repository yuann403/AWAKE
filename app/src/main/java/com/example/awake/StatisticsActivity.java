package com.example.awake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;

public class StatisticsActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private ImageView input_environment_all,input_economic_all,input_social_all;
    private ImageView input_environment_user,input_economic_user,input_social_user;
    private String email;
    public static int cnt=0,environment_all=0,economic_all=0,social_all=0;
    private int environment_color,economic_color,social_color;
    private HashMap<String, String> user_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        init();
        getData();
        addData();
    }
    private void init(){
        db = FirebaseFirestore.getInstance();
        user_data = new HashMap<>();
        input_environment_all = (ImageView) findViewById(R.id.environment_all);
        input_economic_all = (ImageView)  findViewById(R.id.economic_all);
        input_social_all = (ImageView)  findViewById(R.id.social_all);
        input_environment_user = (ImageView) findViewById(R.id.environment_user);
        input_economic_user = (ImageView)  findViewById(R.id.economic_user);
        input_social_user = (ImageView)  findViewById(R.id.social_user);
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
    }

    private void addData(){
        Thread download_all = new Thread(()->{
            try{
                db.collection("user").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                environment_all += Integer.valueOf(document.get("avg_environment").toString());
                                economic_all += Integer.valueOf(document.get("avg_economic").toString());
                                social_all += Integer.valueOf(document.get("avg_social").toString());
                                cnt++;
                            }
                        }
                        else{
                            Log.v("show","statistics: "+ task.getException().getMessage());
                        }
                        setData_all();
                        Log.v("show","cnt:"+cnt);
                        Log.v("show","environment_all:"+environment_all);
                        Log.v("show","economic_all:"+economic_all);
                        Log.v("show","social_all:"+social_all);
                    }
                });
            }catch (Exception e){}
        });
        Thread download_user = new Thread(()->{
            try{
                db.collection("user").document(email)
                        .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if(task.isSuccessful()){
                                    DocumentSnapshot document = task.getResult();
                                    user_data.put("user_environment",document.get("avg_environment").toString());
                                    user_data.put("user_economic",document.get("avg_economic").toString());
                                    user_data.put("user_social",document.get("avg_social").toString());
                                }
                                else{
                                    Log.v("show","statistics: "+ task.getException().getMessage());
                                }
                                Log.v("show",user_data.toString());
                                setData_user();
                            }
                        });
            }catch(Exception e){
            }
        });
        download_all.start();
        download_user.start();
        try {
            download_all.join();
            download_user.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void setData_user(){
        input_environment_user.setImageResource(setEnvironmentColor(Integer.valueOf(user_data.get("user_environment"))));
        input_economic_user.setImageResource(setEconomicColor(Integer.valueOf(user_data.get("user_economic"))));
        input_social_user.setImageResource(setSocialColor(Integer.valueOf(user_data.get("user_social"))));
    }
    private void setData_all(){
        economic_all = economic_all/cnt;
        environment_all = environment_all/cnt;
        social_all = social_all/cnt;
        input_environment_all.setImageResource(setEnvironmentColor(environment_all));
        input_economic_all.setImageResource(setEconomicColor(economic_all));
        input_social_all.setImageResource(setSocialColor(social_all));
    }
    private int setEnvironmentColor(int c){
        if(c>=-90&&c<=-71){
            environment_color = R.drawable.face7;
        }
        else if(c>=-70&&c<=-31){
            environment_color = R.drawable.face6;
        }
        else if(c>=-30&&c<=9){
            environment_color = R.drawable.face5;
        }
        else if(c>=10&&c<=29){
            environment_color = R.drawable.face4;
        }
        else if(c>=30&&c<=69){
            environment_color = R.drawable.face3;
        }
        else if(c>=70&&c<=109){
            environment_color = R.drawable.face2;
        }
        else if(c>=110&&c<=125){
            environment_color = R.drawable.face1;
        }
        else{
            environment_color = R.drawable.face_error;
        }
        return environment_color;
    }

    @NonNull
    private int setEconomicColor(int c){
        if(c>=-20&&c<=-1){
            economic_color = R.drawable.face7;
        }
        else if(c>=0&&c<=39){
            economic_color = R.drawable.face6;
        }
        else if(c>=40&&c<=79){
            economic_color = R.drawable.face5;
        }
        else if(c>=80&&c<=99){
            economic_color = R.drawable.face4;
        }
        else if(c>=100&&c<=139){
            economic_color = R.drawable.face3;
        }
        else if(c>=140&&c<=179){
            economic_color = R.drawable.face2;
        }
        else if(c>=180&&c<=195){
            economic_color = R.drawable.face1;
        }
        else{
            economic_color = R.drawable.face_error;
        }
        return economic_color;
    }

    @NonNull
    private int setSocialColor(int c){
        if(c>=-25&&c<=-6){
            social_color = R.drawable.face7;
        }
        else if(c>=-5&&c<=29){
            social_color = R.drawable.face6;
        }
        else if(c>=30&&c<=64){
            social_color = R.drawable.face5;
        }
        else if(c>=65&&c<=84){
            social_color = R.drawable.face4;
        }
        else if(c>=85&&c<=119){
            social_color = R.drawable.face3;
        }
        else if(c>=120&&c<=154){
            social_color = R.drawable.face2;
        }
        else if(c>=155&&c<=170){
            social_color = R.drawable.face1;
        }
        else{
            social_color = R.drawable.face_error;
        }
        return social_color;
    }

    public void changeToStudyPage(View view) { //換頁
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