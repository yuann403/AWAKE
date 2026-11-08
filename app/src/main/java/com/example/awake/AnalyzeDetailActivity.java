package com.example.awake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.LinkedList;

public class AnalyzeDetailActivity extends AppCompatActivity {
    private Context context = this;
    private FirebaseFirestore db;
    //initListView
    private ListView listView;
    private SimpleAdapter adapter;
    private final String[] from = {"que","effect","cnt"};
    private final int[] to = {R.id.question,R.id.number,R.id.detail_id};
    private final String[] from1 = {"loading"};
    private final int[] to1 = {R.id.question};
    private LinkedList<HashMap<String,String>> loading = new LinkedList<>();
    private LinkedList<HashMap<String,String>> mData = new LinkedList<>();

    private TextView input_date,input_title;
    private ImageView input_btn;
    //private GradientDrawable background;
    private HashMap<String,String> data;
    private String email;
    private int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze_detail);
        init();
        initView();
        getData();
        add();
        addData();
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        setData();
        //initListView();
    }

    private void init(){
        //firebase
        db = FirebaseFirestore.getInstance();
    }

    private void initView(){
        data = new HashMap<>();
        //取得View物件
        input_date = (TextView) findViewById(R.id.detail_date);
        input_btn = (ImageView) findViewById(R.id.detail_btn);
        //background = (GradientDrawable) input_btn.getBackground();
        input_title = (TextView) findViewById(R.id.detail_title);
        //initListView
        listView = findViewById(R.id.detail_list);
    }
    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        data.put("email",bundle.getString("email"));
        data.put("name",bundle.getString("name"));
        data.put("date",bundle.getString("date"));
        data.put("title",bundle.getString("title"));
        data.put("score",bundle.getString("score"));
        //data.put("color",bundle.getString("color"));
        color = bundle.getInt("color");
    }
    private void setData(){
        input_date.setText(data.get("date"));
        //background.setColor(Color.parseColor(data.get("color")));
        //input_btn.setText(data.get("score"));
        input_btn.setImageResource(color);
        if(data.get("title").equals("environment"))
            input_title.setText("環境保護     ");
        else if(data.get("title").equals("economic"))
            input_title.setText("經濟成長     ");
        else if(data.get("title").equals("social"))
            input_title.setText("社會進步     ");
    }

    private void add(){
        HashMap<String, String> d = new HashMap<>();
        d.put("loading","Loading . . . ");
        loading.add(d);
        adapter = new SimpleAdapter(context,loading,R.layout.analyze_detail,from1,to1);
        listView.setAdapter(adapter);
    }

    private void addData(){
        Thread download1 = new Thread(()->{
            try{
                db.collection("question").whereEqualTo(data.get("title"),true)
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    int cnt=0;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        HashMap<String, String> d = new HashMap<>();
                                        d.put("cnt",""+cnt++);
                                        d.put("id",document.get("id").toString());
                                        d.put("que",document.get("que").toString());
                                        d.put("sdgs",document.get("sdgs").toString());
                                        d.put("explanation",document.get("explanation").toString());
                                        mData.add(d);
                                    }
                                }
                                else{
                                    Log.v("show","study: "+ task.getException().getMessage());
                                }
                                //Log.v("show","d1:"+mData.toString());
                            }
                        });
            }catch(Exception e){
                Log.v("show","down1:"+e.toString());
            }
        });

        Thread download2 = new Thread(()->{
            try{
                db.collection("user").document(data.get("email")).collection("games").document(data.get("name")).collection("score")
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    int cnt = 0;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        try{
                                            String id = mData.get(cnt).get("id");
                                            if(id.equals(document.get("id").toString())){
                                                String num = document.get(data.get("title")).toString();
                                                mData.get(cnt).put("num",num);
                                                String effect="";
                                                if(num.equals("20")||num.equals("15")){
                                                    effect="影響極佳";
                                                }else if(num.equals("10")){
                                                    effect="影響良好";
                                                }else if(num.equals("5")){
                                                    effect="影響不錯";
                                                }else if(num.equals("0")){
                                                    effect="沒有影響";
                                                }else if(num.equals("-5")){
                                                    effect="影響差";
                                                }else if(num.equals("-10")){
                                                    effect="影響極差";
                                                }
                                                mData.get(cnt++).put("effect",effect);
                                            }
                                        }catch(Exception e){

                                        }
                                    }
                                }
                                else{
                                    Log.v("show","study: "+ task.getException().getMessage());
                                }
                                //Log.v("show","d2:"+mData.toString());
                                initListView();
                            }
                        });
            }catch(Exception e){
                Log.v("show","down2:"+e.toString());
            }
        });
        try {
            download1.start();
            download1.join();
            Thread.sleep(400);
            download2.start();
            download2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } //Detail資料載入

    private void initListView(){ //List
        //Log.v("show",mData.toString());
        adapter = new SimpleAdapter(this,mData,R.layout.analyze_detail,from,to);
        listView.setAdapter(adapter);
    }

    public void changeToQuePage(View view) {
        TextView s = view.findViewById(R.id.detail_id);
        int id = Integer.valueOf(s.getText().toString());
        Intent intent = new Intent(this,QueActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("date",data.get("date"));
        bundle.putString("id",mData.get(id).get("id"));
        bundle.putString("sdgs",mData.get(id).get("sdgs"));
        bundle.putString("que",mData.get(id).get("que"));
        bundle.putString("explanation",mData.get(id).get("explanation"));
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