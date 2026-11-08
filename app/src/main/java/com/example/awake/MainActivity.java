package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    //initListView
    private ListView listView;
    private SimpleAdapter adapter;
    private final String[] from = {"title","date","link"};
    private final int[] to = {R.id.news_title,R.id.news_date,R.id.news_link};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    //isConnectNetwork
    private ConnectivityManager cmgr ;
    //NetworkReceiver
    private NetworkReceiver networkReceiver;
    //firebase
    private FirebaseAuth mAuth;
    private String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //firebase
        checkIsLogin();
        //isConnectNetwork
        cmgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //NetworkReceiver
        networkReceiver = new NetworkReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkReceiver,filter);
        //initListView
        listView = findViewById(R.id.home_list);
        initListView();

    }
    private void checkIsLogin(){
        //firebase
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user == null){
            changeToLoginPage();
            Log.v("show","change to login page");
        }else{
            email = mAuth.getCurrentUser().getEmail();
        }
    }

    private void addData(){
        String html = "https://www.google.com/search?q=sdgs&rlz=1C1CHBF_zh-TWTW920TW920&sxsrf=ALiCzsY9WGuzIVXv_"
                + "Rlt9CZkhDfYxXH_7A:1657274192863&source=lnms&tbm=nws&sa=X&ved=2ahUKEwi2jr68g-n4AhVNZt4KHY2WB90Q_"
                + "AUoA3oECAIQBQ&biw=1536&bih=754&dpr=1.25";

        Thread download = new Thread(()->{
            try {
                Document doc = Jsoup.connect(html).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36").referrer("http://www.google.com").get();

                Elements news_title = doc.getElementsByClass("mCBkyc y355M ynAwRc MBeuO nDgy9d"); //新聞名稱
                Elements news_date = doc.getElementsByClass("OSrXXb ZE0LJd YsWzw"); //日期
                Elements news_link = doc.getElementsByClass("WlydOe"); //連結

                for(int i = 0; i<news_title.size(); i++){
                    String[] title_str = news_title.get(i).toString().replace("<div class=\"mCBkyc y355M ynAwRc MBeuO nDgy9d\" aria-level=\"3\" role=\"heading\" style=\"-webkit-line-clamp:3\">\n","").split("</div>");
                    String title = title_str[0].replace("\n", "");
                    String[] date_str = news_date.get(i).toString().replace("<div class=\"OSrXXb ZE0LJd YsWzw\" style=\"bottom:0px\">\n <span>","").split("</span>\n</div>");
                    String date = date_str[0];
                    String[] link_str = news_link.get(i).toString().replace("<a jsname=\"YKoRaf\" class=\"WlydOe\" href=\"","").split("\" data-ved=\"");
                    String link = link_str[0];

                    HashMap<String,String> news_data = new HashMap<>();
                    news_data.put(from[0],title.trim());
                    news_data.put(from[1],date.trim());
                    news_data.put(from[2],link.trim());
                    data.add(news_data);
                }
                Log.v("show",data.toString());
            } catch (Exception e) {
                Log.v("show","addData error:"+e);
            }
        });
        download.start();
        try {
            download.join();
        } catch (Exception e) {
            Log.v("show","addData join error : "+e);
        }

    }
    private void initListView(){ //首頁List
        addData();
        adapter = new SimpleAdapter(this,data,R.layout.news,from,to);
        listView.setAdapter(adapter);
    }
    public void searchSDGsInternet (View view){ //爬蟲
        EditText s = view.findViewById(R.id.news_link);
        String link = s.getText().toString();
        Log.v("show", "SDGsNews: "+link);

        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
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
//    public void changeToMainPage(View view) {
//        Intent intent = new Intent(this,MainActivity.class);
//        startActivity(intent);
//    }
    public void changeToHomePage(View view) {
        Intent intent = new Intent(this,HomeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void changeToIntroducePage(View view) {
        Intent intent = new Intent(this,IntroduceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("email",email);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void logout(View view) { //登出
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this,"登出成功",Toast.LENGTH_SHORT).show();
        Log.v("show","logout");
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void changeToLoginPage() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    private class NetworkReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.v("show","isConnected = "+isConnectNetwork());
        }
    }
    private boolean isConnectNetwork(){
        NetworkInfo info = cmgr.getActiveNetworkInfo();
        boolean isConnected = info != null && info.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    public void finish() {
        unregisterReceiver(networkReceiver);
        super.finish();
    }
}