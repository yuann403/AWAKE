package com.example.awake;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    public static String user_acc;
    private Activity context = this;
    private EditText input_acc, input_passwd;
    private TextView mesg;
    private Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView(){
        //取得View物件
        input_acc = (EditText) findViewById(R.id.login_account);
        input_passwd = (EditText) findViewById(R.id.login_password);
        mesg = (TextView) findViewById(R.id.alert_text);
        login = (Button) findViewById(R.id.login_button);

        //firebase
        mAuth = FirebaseAuth.getInstance();
    }

    public void login(View view){ //post
        //取得EditText
        user_acc = input_acc.getText().toString();
        String user_passwd = input_passwd.getText().toString();

        mesg.setVisibility(View.INVISIBLE);

        if(TextUtils.isEmpty(user_acc) || TextUtils.isEmpty(user_passwd)){
            showAlertText("欄位不可空白!");
            return;
        }
        mAuth.signInWithEmailAndPassword(user_acc, user_passwd).addOnCompleteListener(context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    Toast.makeText(context,"登入成功",Toast.LENGTH_SHORT).show();
                    Log.v("show","login: success");
                    changeToMainPage();
                }
                else{
                    if(task.getException().getMessage().equals("There is no user record corresponding to this identifier. The user may have been deleted.")){
                        Toast.makeText(context,"帳號尚未註冊",Toast.LENGTH_SHORT).show();
                    }
                    else if(task.getException().getMessage().equals("The password is invalid or the user does not have a password.")){
                        Toast.makeText(context,"密碼錯誤",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context,"登入失敗",Toast.LENGTH_SHORT).show();
                    }
                    Log.v("show","register: failure: "+task.getException().getMessage());
                }
            }
        });
    }

    private void showAlertText(String s){ //顯示錯誤訊息
        mesg.setText(s);
        mesg.setVisibility(View.VISIBLE);
    }

    public void changeToMainPage() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void changeToRegisterPage(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}