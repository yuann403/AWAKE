package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;

public class ImagesActivity extends AppCompatActivity {
    private StorageReference sr;
    private TextView input_date,input_place;
    private ImageView input_img;
    private HashMap<String,String> data;
    private HashMap<String, Bitmap> images;
    private HashMap<String, String> text;
    private int cnt=1;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        init();
        getData();
        setData();
        downloadByteImg();
        downloadByteImg2();
        downloadByteImg3();
        seText();
    }
    private void init(){
        data = new HashMap<>();
        images = new HashMap<>();
        text = new HashMap<>();
        //取得View物件
        input_date = (TextView) findViewById(R.id.detail_date);
        input_img = (ImageView) findViewById(R.id.game_img);
        input_place = (TextView) findViewById(R.id.place);
    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        data.put("email",bundle.getString("email"));
        data.put("name",bundle.getString("name"));
        data.put("date",bundle.getString("date"));
    }

    private void setData(){
        input_date.setText(data.get("date"));
    }

    private void downloadByteImg(){
        sr = FirebaseStorage.getInstance().getReference().child("images").child(data.get("email")).child(data.get("name"));
        final long MAXBYTES = 1024 * 1024;

        sr.child("town1.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("1",bm);
                input_img.setImageBitmap(bm);
                Log.v("show","ok1");
            }
        });
        sr.child("town2.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("2",bm);
                Log.v("show","ok2");
            }
        });
        sr.child("town3.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("3",bm);
                Log.v("show","ok3");
            }
        });
    }

    private void downloadByteImg2(){
        sr = FirebaseStorage.getInstance().getReference().child("images").child(data.get("email")).child(data.get("name"));
        final long MAXBYTES = 1024 * 1024;

        sr.child("industrial1.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("4",bm);
                Log.v("show","ok4");
            }
        });
        sr.child("industrial2.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("5",bm);
                Log.v("show","ok5");
            }
        });
        sr.child("industrial3.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("6",bm);
                Log.v("show","ok6");
            }
        });
    }
    private void downloadByteImg3(){
        sr = FirebaseStorage.getInstance().getReference().child("images").child(data.get("email")).child(data.get("name"));
        final long MAXBYTES = 1024 * 1024;

        sr.child("city1.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("7",bm);
                Log.v("show","ok7");
            }
        });
        sr.child("city2.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("8",bm);
                Log.v("show","ok8");
            }
        });
        sr.child("city3.jpg").getBytes(MAXBYTES).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bm = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                images.put("9",bm);
                Log.v("show","ok9");
            }
        });
    }
    public void leftImg(View view) {
        if(cnt != 1){
            cnt--;
        }
        input_img.setImageBitmap(images.get(cnt+""));
        input_place.setText(text.get(cnt+""));
    }
    public void rightImg(View view) {
        if(cnt != 9){
            cnt++;
        }
        input_img.setImageBitmap(images.get(cnt+""));
        input_place.setText(text.get(cnt+""));
    }
    private void seText(){
        text.put("1","漁村(前)");
        text.put("2","漁村(中)");
        text.put("3","漁村(後)");
        text.put("4","工業區(前)");
        text.put("5","工業區(中)");
        text.put("6","工業區(後)");
        text.put("7","城市(前)");
        text.put("8","城市(中)");
        text.put("9","城市(後)");
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