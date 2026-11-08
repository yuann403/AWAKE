package com.example.awake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.util.concurrent.atomic.AtomicBoolean;

public class StudyActivity extends AppCompatActivity {
    private Context context = this;
    //initListView
    private ListView listView;
    private SimpleAdapter adapter;
    private final String[] from = {"id","date","name"};
    private final int[] to = {R.id.history_id,R.id.history_date,R.id.history_name};
    private final String[] from1 = {"loading"};
    private final int[] to1 = {R.id.history_name};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    private LinkedList<HashMap<String,String>> loading = new LinkedList<>();
    //firebase
    private FirebaseFirestore db;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        //firebase
        init();
        getData();
        //initListView
        listView = findViewById(R.id.history_list);
        addData();
    }
    private void init(){
        db = FirebaseFirestore.getInstance();
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
    }

    private void add(){
        HashMap<String, String> d = new HashMap<>();
        d.put("loading","Loading . . . ");
        loading.add(d);
        adapter = new SimpleAdapter(context,loading,R.layout.history,from1,to1);
        listView.setAdapter(adapter);
    }

    private void addData(){
        add();
        Thread download = new Thread(()->{
            runOnUiThread(()->{
                db.collection("user").document(email).collection("games")
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    int cnt = 0;
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        HashMap<String, String> d = new HashMap<>();
                                        d.put("id",""+cnt++);
                                        d.put("date",document.get("date").toString());
                                        d.put("name",document.get("name").toString());
                                        d.put("environment",document.get("environment").toString());
                                        d.put("economic",document.get("economic").toString());
                                        d.put("social",document.get("social").toString());
                                        data.add(d);
                                    }
                                }
                                else{
                                    Log.v("show","study: "+ task.getException().getMessage());
                                }
                                Log.v("show","study data: "+ data.toString());
                                Log.v("show","study listview: start");
                                adapter = new SimpleAdapter(context,data,R.layout.history,from,to);
                                listView.setAdapter(adapter);
                            }
                        });
            });
        });

        download.start();
        try {
            download.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } //學習歷程List資料載入

    public void changeToAnalyzePage(View view) {
        try{
            TextView s = view.findViewById(R.id.history_id);
            int id = Integer.valueOf(s.getText().toString());
            Intent intent = new Intent(this,AnalyzeActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("email",email);
            bundle.putString("date",data.get(id).get("date"));
            bundle.putString("name",data.get(id).get("name"));
            bundle.putString("environment",data.get(id).get("environment"));
            bundle.putString("economic",data.get(id).get("economic"));
            bundle.putString("social",data.get(id).get("social"));
            intent.putExtras(bundle);
            startActivity(intent);
        }
        catch(Exception e){

        }
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