package com.example.awake;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    private Activity context = this;
    private EditText input_acc, input_passwd, input_name;
    private TextView mesg;

    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView(){
        //取得View物件
        input_acc = (EditText) findViewById(R.id.register_account);
        input_passwd = (EditText) findViewById(R.id.register_password);
        input_name = (EditText) findViewById(R.id.register_name);
        mesg = (TextView) findViewById(R.id.alert_text);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }

    public void register(View view) {
        //用於登入系統
        showAlertText("");
        //取得EditText
        String user_acc = input_acc.getText().toString();
        String user_passwd = input_passwd.getText().toString();
        String user_name = input_name.getText().toString();

        if(TextUtils.isEmpty(user_acc) || TextUtils.isEmpty(user_passwd) || TextUtils.isEmpty(user_name)){
            showAlertText("欄位不可空白!");
            return;
        }
        mAuth.createUserWithEmailAndPassword(user_acc,user_passwd).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(context,"註冊成功",Toast.LENGTH_SHORT).show();
                    Log.v("show","register: success");
                    //writeNewUser(user_name,user_acc,user_passwd);
                    changeToLoginPage();
                }
                else{
                    if(task.getException().getMessage().equals("The email address is already in use by another account.")){
                        Toast.makeText(context,"帳號已被使用",Toast.LENGTH_SHORT).show();
                    }
                    else if(task.getException().getMessage().equals("The given password is invalid. [ Password should be at least 6 characters ]")){
                        Toast.makeText(context,"密碼至少6位",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context,"註冊失敗",Toast.LENGTH_SHORT).show();
                    }
                    Log.v("show","register: failure: "+task.getException().getMessage());
                }
            }
        });
        //存進資料庫方便存取
        Map<String,Object> user = new HashMap<>();
        user.put("name",user_name);
        db.collection("user").document(user_acc)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    private void showAlertText(String s){ //顯示錯誤訊息
        mesg.setText(s);
        mesg.setVisibility(View.VISIBLE);
    }

    public void changeToLoginPage() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}