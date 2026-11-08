package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.HashMap;
import java.util.LinkedList;

public class HomeActivity extends AppCompatActivity {
    private String email;
    private TextView gmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getData();
        gmail = findViewById(R.id.gmail);
        gmail.setText(email);
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
    }

    public void logout(View view) { //登出
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this,"登出成功",Toast.LENGTH_SHORT).show();
        Log.v("show","logout");
        Intent intent = new Intent(this,LoginActivity.class);
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