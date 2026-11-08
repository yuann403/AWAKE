package com.example.awake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.LinkedList;

public class IntroduceDetailActivity extends AppCompatActivity {
    private String email,sdgs,title;
    private ListView listView;
    private TextView detail_title;
    private SimpleAdapter adapter;
    private final String[] from = {"id","name"};
    private final int[] to = {R.id.intruduce_date,R.id.intruduce_name};
    private LinkedList<HashMap<String,String>> data = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce_detail);
        getData();
        //addData();
        try {
            Thread.sleep(1000);
            detail_title = findViewById(R.id.sdgs_title);
            detail_title.setText(title);
            listView = findViewById(R.id.intruduce_list);
            initListView();
        }catch (Exception e){

        }

    }

    private void getData(){
        Bundle bundle = getIntent().getExtras();
        email = bundle.getString("email");
        sdgs = bundle.getString("sdgs");
        title = bundle.getString("title");
    }
    private void addData(){
        switch (sdgs){
            case "01":
                addData01();
                break;
            case "02":
                addData02();
                break;
            case "03":
                addData03();
                break;
            case "04":
                addData04();
                break;
            case "051":
                addData05();
                break;
            case "06":
                addData06();
                break;
            case "07":
                addData07();
                break;
            case "08":
                addData08();
                break;
            case "09":
                addData09();
                break;
            case "10":
                addData10();
                break;
            case "11":
                addData11();
                break;
            case "12":
                addData12();
                break;
            case "13":
                addData13();
                break;
            case "14":
                addData14();
                break;
            case "15":
                addData15();
                break;
            case "16":
                addData16();
                break;
            case "17":
                addData17();
                break;
        }
    }

    private void initListView(){
        if(sdgs.equals("01"))
            addData01();
        else if(sdgs.equals("02"))
            addData02();
        else if(sdgs.equals("03"))
            addData03();
        else if(sdgs.equals("04"))
            addData04();
        else if(sdgs.equals("05"))
            addData05();
        else if(sdgs.equals("06"))
            addData06();
        else if(sdgs.equals("07"))
            addData07();
        else if(sdgs.equals("08"))
            addData08();
        else if(sdgs.equals("09"))
            addData09();
        else if(sdgs.equals("10"))
            addData10();
        else if(sdgs.equals("11"))
            addData11();
        else if(sdgs.equals("12"))
            addData12();
        else if(sdgs.equals("13"))
            addData13();
        else if(sdgs.equals("14"))
            addData14();
        else if(sdgs.equals("15"))
            addData15();
        else if(sdgs.equals("16"))
            addData16();
        else if(sdgs.equals("17"))
            addData17();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter = new SimpleAdapter(this,data,R.layout.introduce,from,to);
        listView.setAdapter(adapter);
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

    private void addData01(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"1  ");
        d0.put(from[1],"消除各地一切形式的貧窮");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"1.1");
        d1.put(from[1],"在2030年前，消除所有地方的極端貧窮，目前的定義為每日的生活費不到1.25美元");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"1.2");
        d2.put(from[1],"在2030年前，依據國家的人口統計數字，將各個年齡層的貧窮男女與兒童人數減少一半");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"1.3");
        d3.put(from[1],"對所有的人，包括底層的人，實施適合國家的社會保護制度措施，到了2030年，範圍涵蓋貧窮與弱勢族群");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"1.4");
        d4.put(from[1],"在2030年前，確保所有的男男女女，尤其是貧窮與弱勢族群，在經濟資源、基本服務、以及土地與其他形式的財產、繼承、天然資源、新科技與財務服務（包括微型貸款）都有公平的權利與取得權");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"1.5");
        d5.put(from[1],"在2030年前，讓貧窮與弱勢族群具有災後復原能力，減少他們暴露於氣候極端事件與其他社經與環境災害的頻率與受傷害的嚴重度");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"1.a");
        d6.put(from[1],"確保各個地方的資源能夠大幅動員，包括改善發展合作，為開發中國家提供妥善且可預測的方法，尤其是最低度開發國家（以下簡稱LDCs），以實施計畫與政策，全面消除它們國內的貧窮");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"1.b");
        d6.put(from[1],"依據考量到貧窮與兩性的發展策略，建立國家的、區域的與國際層級的妥善政策架構，加速消除貧窮行動");
        data.add(d7);
    }
    private void addData02(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"2  ");
        d0.put(from[1],"消除飢餓，達成糧食安全，改善營養及促進永續農業");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"2.1");
        d1.put(from[1],"在2030年前，消除飢餓，確保所有的人，尤其是貧窮與弱勢族群（包括嬰兒），都能夠終年取得安全" +
                "、營養且足夠的糧食");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"2.2");
        d2.put(from[1],"在2030年前，消除所有形式的營養不良，包括在2025年前，達成國際合意的五歲以下兒童，" +
                "並且解決青少女、孕婦、哺乳婦女以及老年人的營養需求。");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"2.3");
        d3.put(from[1],"在2030年前，使農村的生產力與小規模糧食生產者的收入增加一倍，尤其是婦女、原住民、家族式農夫、" +
                "牧民與漁夫，包括讓他們有安全及公平的土地、生產資源、知識、財務服務、市場、增值機會以及非農業就業機會的管道");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"2.4");
        d4.put(from[1],"在2030年前，確保可永續發展的糧食生產系統，並實施可災後復原的農村作法，提高產能及生產力，協助" +
                "維護生態系統，強化適應氣候變遷、極端氣候、乾旱、洪水與其他災害的能力，並漸進改善土地與土壤的品質");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"2.5");
        d5.put(from[1],"在2020年前，維持種子、栽種植物、家畜以及與他們有關的野生品種之基因多樣性，包括善用國家、國際" +
                "與區域妥善管理及多樣化的種籽與植物銀行，並確保運用基因資源與有關傳統知識所產生的好處得以依照國際" +
                "協議而公平的分享");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"2.a");
        d6.put(from[1],"提高在鄉村基礎建設、農村研究、擴大服務、科技發展、植物與家畜基因銀行上的投資，包括透過更好的國際合" +
                "作，以改善開發中國家的農業產能，尤其是最落後國家");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"2.b");
        d6.put(from[1],"矯正及預防全球農業市場的交易限制與扭曲，包括依據杜哈發展圓桌，同時消除各種形式的農業出口補助及" +
                "產生同樣影響的出口措施");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"2.c");
        d6.put(from[1],"採取措施，以確保食品與他們的衍生產品的商業市場發揮正常的功能，並如期取得市場資訊，" +
                "包括儲糧，以減少極端的糧食價格波動");
        data.add(d8);
    }
    private void addData03(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"3  ");
        d0.put(from[1],"確保健康及促進各年齡層的福祉");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"3.1");
        d1.put(from[1],"在2030年前，減少全球的死產率，讓每100,000個活產的死胎數少於70個");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"3.2");
        d2.put(from[1],"在2030年前，消除可預防的新生兒以及五歲以下兒童的死亡率");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"3.3");
        d3.put(from[1],"在2030年前，消除愛滋病、肺結核、瘧疾以及受到忽略的熱帶性疾病，並對抗肝炎，水傳染性疾病" +
                "以及其他傳染疾病");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"3.4");
        d4.put(from[1],"在2030年前，透過預防與治療，將非傳染性疾病的未成年死亡數減少三分之一，並促進心理健康");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"3.5");
        d5.put(from[1],"強化物質濫用的預防與治療，包括麻醉藥品濫用以及酗酒");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"3.6");
        d6.put(from[1],"在2020年前，讓全球因為交通事故而傷亡的人數減少一半");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"3.7");
        d6.put(from[1],"在2030年前，確保全球都有管道可取得性與生殖醫療保健服務，" +
                "包括家庭規劃、資訊與教育，並將生殖醫療保健納入國家策略與計畫之中");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"3.8");
        d6.put(from[1],"實現醫療保健涵蓋全球（以下簡稱UHC）的目標，包括財務風險保護，" +
                "取得高品質基本醫療保健服務的管道，以及所有的人都可取得安全、有效、高品質、" +
                "負擔得起的基本藥物與疫苗");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d6.put(from[0],"3.9");
        d6.put(from[1],"在2030年以前，大幅減少死於危險化學物質、空氣污染、水污染、" +
                "土壤污染以及其他污染的死亡及疾病人數");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"3.a");
        d5.put(from[1],"強化煙草管制架構公約在所有國家的實施與落實");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d6.put(from[0],"3.b");
        d6.put(from[1],"對主要影響開發中國家的傳染以及非傳染性疾病，支援疫苗以及醫藥的研發，" +
                "依據杜哈宣言提供負擔的起的基本藥物與疫苗；杜哈宣言確認開發中國家有權利使用國際專利規範-" +
                "與貿易有關之智慧財產權協定（以下簡稱TRIPS）中的所有供應品，以保護民眾健康，尤其是必" +
                "須提供醫藥管道給所有的人");
        data.add(d11);
        HashMap<String,String> d12 = new HashMap<>();
        d5.put(from[0],"3.c");
        d5.put(from[1],"大幅增加開發中國家的醫療保健的融資與借款，以及醫療保健從業人員的招募、" +
                "培訓以及留任，尤其是LDCs與SIDS");
        data.add(d12);
        HashMap<String,String> d13 = new HashMap<>();
        d6.put(from[0],"3.d");
        d6.put(from[1],"強化所有國家的早期預警、風險減少，以及國家與全球健康風險的管理能力，特別是開發中國家");
        data.add(d13);
    }
    private void addData04(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"4  ");
        d0.put(from[1],"確保有教無類、公平以及高品質的教育，及提倡終身學習");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"4.1");
        d1.put(from[1],"在2030年前，確保所有的男女學子都完成免費的、公平的以及高品質的小學與中學教育，" +
                "得到有關且有效的學習成果");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"4.2");
        d2.put(from[1],"在2030年前，確保所有的孩童都能接受高品質的早期幼兒教育、照護，以及小學前教育，" +
                "因而為小學的入學作好準備");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"4.3");
        d3.put(from[1],"在2030年前，確保所有的男女都有公平、負擔得起、高品質的技職、職業與高等教育的受教機會，包括大學");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"4.4");
        d4.put(from[1],"在2030年前，將擁有相關就業、覓得好工作與企業管理職能的年輕人與成人的人數增加x%，" +
                "包括技術與職業技能");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"4.5");
        d5.put(from[1],"在2030年前，消除教育上的兩性不平等，確保弱勢族群有接受各階級教育的管道與職業訓練，" +
                "包括身心障礙者、原住民以及弱勢孩童");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"4.6");
        d6.put(from[1],"在2030年以前，確保所有的年輕人以及至少 x%的成人，不管男女，都具備讀寫以及算術能力");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"4.7");
        d6.put(from[1],"在2030年前，確保所有的學子都習得必要的知識與技能而可以促進永續發展，包括永續發展教育、" +
                "永續生活模式、人權、性別平等、和平及非暴力提倡、全球公民、文化差異欣賞，以及文化對永續發展的貢獻");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"4.a");
        d6.put(from[1],"建立及提升適合孩童、身心障礙者以及兩性的教育設施，\n" +
                "並為所有的人提供安全的、非暴力的、有教無類的、以及有效的學習環境");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d6.put(from[0],"4.b");
        d6.put(from[1],"在2020年前，將全球開發中國家的獎學金數目增加x%，尤其是LDCs、SIDS與非洲國家，" +
                "以提高高等教育的受教率，包括已開發國家與其他開發中國家的職業訓練、資訊與通信科技（以下簡稱 ICT），" +
                "技術的、工程的，以及科學課程");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"4.c");
        d5.put(from[1],"在2030年前，將合格師資人數增加x%，包括在開發中國家進行國際師資培訓合作，尤其是LDCs與SIDS");
        data.add(d10);
    }
    private void addData05(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"5  ");
        d0.put(from[1],"實現兩性平等，並賦予所有婦女權力");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"5.1");
        d1.put(from[1],"消除所有地方對婦女的各種形式的歧視");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"5.2");
        d2.put(from[1],"消除公開及私人場合中對婦女的各種形式的暴力，包括人口走私、性侵犯，以及其他各種形式的剝削");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"5.3");
        d3.put(from[1],"消除各種有害的做法，例如童婚、未成年結婚、強迫結婚，以及女性生殖器切割");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"5.4");
        d4.put(from[1],"透過提供公共服務、基礎建設與社會保護政策承認及重視婦女無給職的家庭照護與家事操勞，" +
                "依據國情，提倡家事由家人共同分擔");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"5.5");
        d5.put(from[1],"確保婦女全面參與政經與公共決策，確保婦女有公平的機會參與各個階層的決策領導");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"5.6");
        d6.put(from[1],"依據國際人口與發展會議（以下簡稱ICPD）行動計畫、北京行動平台，以及它們的檢討成果書，" +
                "確保每個地方的人都有管道取得性與生殖醫療照護服務");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"5.a");
        d6.put(from[1],"進行改革，以提供婦女公平的經濟資源權利，以及土地與其他形式的財產、財務服務、繼承與" +
                "天然資源的所有權與掌控權");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"5.b");
        d6.put(from[1],"改善科技的使用能力，特別是 ICT，以提高婦女的能力");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d6.put(from[0],"5.c");
        d6.put(from[1],"採用及強化完善的政策以及可實行的立法，以促進兩性平等，並提高各個階層婦女的能力");
        data.add(d9);
    }
    private void addData06(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"6  ");
        d0.put(from[1],"確保所有人都能享有水及衛生及其永續管理");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"6.1");
        d1.put(from[1],"在2030年前，讓全球的每一個人都有公平的管道，可以取得安全且負擔的起的飲用水");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"6.2");
        d2.put(from[1],"在2030年前，讓每一個人都享有公平及妥善的衛生，終結露天大小便，特別注意弱勢族群中婦女的需求");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"6.3");
        d3.put(from[1],"在2030年前，改善水質，減少污染，消除垃圾傾倒，減少有毒物化學物質與危險材料的釋出，" +
                "將未經處理的廢水比例減少一半，將全球的回收與安全再使用率提高x%");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"6.4");
        d4.put(from[1],"在2030年前，大幅增加各個產業的水使用效率，確保永續的淡水供應與回收，" +
                "以解決水饑荒問題，並大幅減少因為水計畫而受苦的人數");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"6.5");
        d5.put(from[1],"在2030年前，全面實施一體化的水資源管理，包括跨界合作");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"6.6");
        d6.put(from[1],"在2020年前，保護及恢復跟水有關的生態系統，包括山脈、森林、沼澤、河流、含水層，以及湖泊");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"6.a");
        d6.put(from[1],"在2030年前，針對開發中國家的水與衛生有關活動與計畫，擴大國際合作與能力培養支援，" +
                "包括採水、去鹽、水效率、廢水處理、回收，以及再使用科技");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"6.b");
        d6.put(from[1],"支援及強化地方社區的參與，以改善水與衛生的管理");
        data.add(d8);
    }
    private void addData07(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"7  ");
        d0.put(from[1],"確保所有的人都可取得負擔的起、可靠的、永續的，以及現代的能源");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"7.1");
        d1.put(from[1],"在2030年前，確保所有的人都可取得負擔的起、可靠的，以及現代的能源服務");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"7.2");
        d2.put(from[1],"在2030年前，大幅提高全球再生能源的共享");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"7.3");
        d3.put(from[1],"在2030年前，將全球能源效率的改善度提高一倍");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"7.a");
        d4.put(from[1],"在2030年前，改善國際合作，以提高乾淨能源與科技的取得管道，包括再生能源、" +
                "能源效率、更先進及更乾淨的石化燃料科技，並促進能源基礎建設與乾淨能源科技的投資");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"7.b");
        d5.put(from[1],"在2030年前，擴大基礎建設並改善科技，以為所有開發中國家提供現代及永續的能源服務，尤其是LDCs與SIDS");
        data.add(d5);
    }
    private void addData08(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"8  ");
        d0.put(from[1],"促進包容且永續的經濟成長，達到全面且生產力的就業，讓每一個人都有一份好工作");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"8.1");
        d1.put(from[1],"依據國情維持經濟成長，尤其是開發度最低的國家，每年的國內生產毛額（以下簡稱GDP）成長率至少7%");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"8.2");
        d2.put(from[1],"透過多元化、科技升級與創新提高經濟體的產能，包括將焦點集中在高附加價值與勞動力密集的產業");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"8.3");
        d3.put(from[1],"促進以開發為導向的政策，支援生產活動、就業創造、企業管理、創意與創新，" +
                "並鼓勵微型與中小企業的正式化與成長，包括取得財務服務的管道");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"8.4");
        d4.put(from[1],"在2030年前，漸進改善全球的能源使用與生產效率，在已開發國家的帶領下，" +
                "依據十年的永續使用與生產計畫架構，努力減少經濟成長與環境惡化之間的關聯");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"8.5");
        d5.put(from[1],"在2030年前，實現全面有生產力的就業，讓所有的男女都有一份好工作，" +
                "包括年輕人與身心障礙者，並實現同工同酬的待遇");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d6.put(from[0],"8.6");
        d6.put(from[1],"在2020年前，大幅減少失業、失學或未接受訓練的年輕人");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d6.put(from[0],"8.7");
        d6.put(from[1],"採取立即且有效的措施，以禁止與消除最糟形式的童工，消除受壓迫的勞工；" +
                "在2025年以前，終結各種形式的童工，包括童兵的招募使用");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d6.put(from[0],"8.8");
        d6.put(from[1],"保護勞工的權益，促進工作環境的安全，包括遷徙性勞工，尤其是婦女以及實行危險工作的勞工");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d6.put(from[0],"8.9");
        d6.put(from[1],"在2030年前，制定及實施政策，以促進永續發展的觀光業，創造就業，促進地方文化與產品");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"8.10");
        d5.put(from[1],"強化本國金融機構的能力，為所有的人提供更寬廣的銀行、保險與金融服務");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d6.put(from[0],"8.a");
        d6.put(from[1],"提高給開發中國家的貿易協助資源，尤其是LDCs，包括為LDCs提供更好的整合架構");
        data.add(d11);
        HashMap<String,String> d12 = new HashMap<>();
        d5.put(from[0],"8.b");
        d5.put(from[1],"在2020年前，制定及實施年輕人就業全球策略，並落實全球勞工組織的全球就業協定");
        data.add(d12);
    }
    private void addData09(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"9  ");
        d0.put(from[1],"建立具有韌性的基礎建設，促進包容且永續的工業，並加速創新");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"9.1");
        d1.put(from[1],"發展高品質的、可靠的、永續的，以及具有災後復原能力的基礎設施，包括區域以及跨界基礎設施，" +
                "以支援經濟發展和人類福祉，並將焦點放在為所有的人提供負擔的起又公平的管道");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"9.2");
        d2.put(from[1],"促進包容以及永續的工業化，在2030年前，依照各國的情況大幅提高工業的就業率與GDP，尤其是" +
                "LDCs應增加一倍");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"9.3");
        d3.put(from[1],"提高小規模工商業取得金融服務的管道，尤其是開發中國家，包括負擔的起的貸款，" +
                "並將他們併入價值鏈與市場之中");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"9.4");
        d4.put(from[1],"在2030年前，升級基礎設施，改造工商業，使他們可永續發展，提高能源使用效率，" +
                "大幅採用乾淨又環保的科技與工業製程，所有的國家都應依據他們各自的能力行動");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"9.5");
        d5.put(from[1],"改善科學研究，提高五所有國家的工商業的科技能力，尤其是開發中國家，包括在2030年前，" +
                "鼓勵創新，並提高研發人員數，每百萬人增加x%，並提高公民營的研發支出");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"9.a");
        d4.put(from[1],"透過改善給非洲國家、LDCs、內陸開發中國家（以下簡稱LLDCs）與SIDS的財務、科技與技術支援，" +
                "加速開發中國家發展具有災後復原能力且永續的基礎設施");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"9.b");
        d5.put(from[1],"支援開發中國家的本國科技研發與創新，包括打造有助工商多元發展以及商品附加價值提升的政策環境");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d5.put(from[0],"9.c");
        d5.put(from[1],"大幅提高ICT的管道，在2020年前，在開發度最低的發展中國家致力提供人人都可取得且負擔的起的網際網路管道");
        data.add(d8);
    }
    private void addData10(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"10  ");
        d0.put(from[1],"減少國內及國家間不平等");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"10.1");
        d1.put(from[1],"在2030年前，以高於國家平均值的速率漸進地致使底層百分之40的人口實現所得成長");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"10.2");
        d2.put(from[1],"在2030年前，促進社經政治的融合，無論年齡、性別、身心障礙、種族、人種、祖國、宗教、經濟或其他身份地位");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"10.3");
        d3.put(from[1],"確保機會平等，減少不平等，作法包括消除歧視的法律、政策及實務作法，並促進適當的立法、政策與行動");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"10.4");
        d4.put(from[1],"採用適當的政策，尤其是財政、薪資與社會保護政策，並漸進實現進一步的平等");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"10.5");
        d5.put(from[1],"改善全球金融市場與金融機構的法規與監管，並強化這類法規的實施");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"10.6");
        d4.put(from[1],"提高發展中國家在全球經濟與金融機構中的決策發言權，以實現更有效、更可靠、更負責以及更正當的機構");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"10.7");
        d5.put(from[1],"促進有秩序的、安全的、規律的，以及負責的移民，作法包括實施規劃及管理良好的移民政策");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d5.put(from[0],"10.a");
        d5.put(from[1],"依據世界貿易組織的協定，對開發中國家實施特別且差異對待的原則，尤其是開發度最低的國家");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"10.b");
        d5.put(from[1],"依據國家計畫與方案，鼓勵官方開發援助（以下簡稱ODA）與資金流向最需要的國家，" +
                "包括外資直接投資，尤其是LDCs、非洲國家、SIDS、以及LLDCs");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"10.c");
        d5.put(from[1],"在2030年前，將遷移者的匯款手續費減少到小於3%，並消除手續費高於5%的匯款");
        data.add(d10);
    }
    private void addData11(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"11  ");
        d0.put(from[1],"促使城市與人類居住具包容、安全、韌性及永續性");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"11.1");
        d1.put(from[1],"在2030年前，確保所有的人都可取得適當的、安全的，以及負擔的起的住宅與基本服務，並改善貧民窟");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"11.2");
        d2.put(from[1],"在2030年前，為所有的人提供安全的、負擔的起、可使用的，以及可永續發展的交通運輸系統，" +
                "改善道路安全，尤其是擴大公共運輸，特別注意弱勢族群、婦女、兒童、身心障礙者以及老年人的需求");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"11.3");
        d3.put(from[1],"在2030年前，提高融合的、包容的以及可永續發展的都市化與容積，以讓所有的國家落實參與性、" +
                "一體性以及可永續發展的人類定居規劃與管理");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"11.4");
        d4.put(from[1],"在全球的文化與自然遺產的保護上，進一步努力");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"11.5");
        d5.put(from[1],"在2030年前，大幅減少災害的死亡數以及受影響的人數，並將災害所造成的GDP經濟損失減少y%，" +
                "包括跟水有關的傷害，並將焦點放在保護弱勢族群與貧窮者");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"11.6");
        d4.put(from[1],"在2030年前，減少都市對環境的有害影響，其中包括特別注意空氣品質、都市管理與廢棄物管理");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"11.7");
        d5.put(from[1],"在2030年前，為所有的人提供安全的、包容的、可使用的綠色公共空間，尤其是婦女、孩童、老年人以及身心障礙者");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d5.put(from[0],"11.a");
        d5.put(from[1],"強化國家與區域的發展規劃，促進都市、郊區與城鄉之間的社經與環境的正面連結");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"11.b");
        d5.put(from[1],"在2020年前，致使在包容、融合、資源效率、移民、氣候變遷適應、災後復原能力上落實一體政策與" +
                "計畫的都市與地點數目增加x%，依照日本兵庫縣架構管理所有階層的災害風險");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"11.c");
        d5.put(from[1],"支援開發度最低的國家，以妥善使用當地的建材，營建具有災後復原能力且可永續的建築，作法包括財務與技術上的協助");
        data.add(d10);
    }
    private void addData12(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"12  ");
        d0.put(from[1],"確保永續的消費與生產模式");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"12.1");
        d1.put(from[1],"實施永續消費與生產十年計畫架構（以下簡稱10YEP），所有的國家動起來，由已開發國家擔任帶頭角色，" +
                "考量開發中國家的發展與能力");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"12.2");
        d2.put(from[1],"在2030年前，實現自然資源的永續管理以及有效率的使用");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"12.3");
        d3.put(from[1],"在2030年前，將零售與消費者階層上的全球糧食浪費減少一半，並減少生產與供應鏈上的糧食損失，包括採收後的損失");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"12.4");
        d4.put(from[1],"在2020年前，依據議定的國際架構，在化學藥品與廢棄物的生命週期中，以符合環保的方式妥善管理" +
                "化學藥品與廢棄物，大幅減少他們釋放到空氣、水與土壤中，以減少他們對人類健康與環境的不利影響");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"12.5");
        d5.put(from[1],"在2030年前，透過預防、減量、回收與再使用大幅減少廢棄物的產生");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"12.6");
        d4.put(from[1],"鼓勵企業採取可永續發展的工商作法，尤其是大規模與跨國公司，並將永續性資訊納入他們的報告週期中");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"12.7");
        d5.put(from[1],"依據國家政策與優先要務，促進可永續發展的公共採購流程");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d5.put(from[0],"12.8");
        d5.put(from[1],"在2030年前，確保每個地方的人都有永續發展的有關資訊與意識，以及跟大自然和諧共處的生活方式");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"12.a");
        d5.put(from[1],"協助開發中國家強健它們的科學與科技能力，朝向更能永續發展的耗用與生產模式");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"12.b");
        d5.put(from[1],"制定及實施政策，以監測永續發展對創造就業，促進地方文化與產品的永續觀光的影響");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d5.put(from[0],"12.c");
        d5.put(from[1],"依據國情消除市場扭曲，改革鼓勵浪費的無效率石化燃料補助，作法包括改變課稅架構，逐步廢除這些有害的" +
                "補助，以反映他們對環境的影響，全盤思考開發中國家的需求與狀況，以可以保護貧窮與受影響社區的方式減少" +
                "它們對發展的可能影響");
        data.add(d11);
    }
    private void addData13(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"13  ");
        d0.put(from[1],"採取緊急措施以因應氣候變遷及其影響");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"13.1");
        d1.put(from[1],"強化所有國家對天災與氣候有關風險的災後復原能力與調適適應能力");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"13.2");
        d2.put(from[1],"將氣候變遷措施納入國家政策、策略與規劃之中");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"13.3");
        d3.put(from[1],"在氣候變遷的減險、適應、影響減少與早期預警上，改善教育，提升意識，增進人與機構的能力");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"13.a");
        d4.put(from[1],"在2020年前，落實UNFCCC已開發國家簽約國的承諾，目標是每年從各個來源募得美元1千億，以有" +
                "意義的減災與透明方式解決開發中國家的需求，並盡快讓綠色氣候基金透過資本化而全盤進入運作");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"13.b");
        d5.put(from[1],"提昇開發度最低國家中的有關機制，以提高能力而進行有效的氣候變遷規劃與管理，" +
                "包括將焦點放在婦女、年輕人、地方社區與邊緣化社區");
        data.add(d5);
    }
    private void addData14(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"14  ");
        d0.put(from[1],"保育及永續利用海洋與海洋資源，以確保永續發展");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"14.1");
        d1.put(from[1],"在2025年前，預防及大幅減少各式各樣的海洋污染，尤其是來自陸上活動的污染，包括海洋廢棄物以及營養污染");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"14.2");
        d2.put(from[1],"在2020年前，以可永續的方式管理及保護海洋與海岸生態，避免重大的不利影響，作法包括強健他們" +
                "的災後復原能力，並採取復原動作，以實現健康又具有生產力的海洋");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"14.3");
        d3.put(from[1],"減少並解決海洋酸化的影響，作法包括改善所有階層的科學合作");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"14.4");
        d4.put(from[1],"在2020年前，有效監管採收，消除過度漁撈，以及非法的、未報告的、未受監管的（以下簡稱IUU）、" +
                "或毀滅性魚撈作法，並實施科學管理計畫，在最短的時間內，將魚量恢復到依據它們的生物特性可產生最大永續發展的魚量");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"14.5");
        d5.put(from[1],"在2020年前，依照國家與國際法規，以及可取得的最佳科學資訊，保護至少10%的海岸與海洋區");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"14.6");
        d4.put(from[1],"在2020年前，禁止會造成過度魚撈的補助，消除會助長 IUU 魚撈的補助，禁止引入這類補助，承認" +
                "對開發中國家與開發度最低國家採取適當且有效的特別與差別待遇應是世界貿易組織漁撈補助協定的一部分");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"14.7");
        d5.put(from[1],"在2030年前，提高海洋資源永續使用對SIDS與LDCs的經濟好處，作法包括永續管理漁撈業、水產養殖業與觀光業");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d5.put(from[0],"14.a");
        d5.put(from[1],"提高科學知識，發展研究能力，轉移海洋科技，思考跨政府海洋委員會的海洋科技轉移準則，以改善海洋" +
                "的健康，促進海洋生物多樣性對開發中國家的發展貢獻，特別是SIDS與LDCs");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"14.b");
        d5.put(from[1],"提供小規模人工魚撈業者取得海洋資源與進入市場的管道");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d5.put(from[0],"14.c");
        d5.put(from[1],"確保聯合國海洋法公約（以下簡稱UNCCLOS）簽約國全面落實國際法，包括現有的區域與國際制度，" +
                "以保護及永續使用海洋及海洋資源");
        data.add(d10);
    }
    private void addData15(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"15  ");
        d0.put(from[1],"保護、維護及促進領地生態系統的永續使用，永續的管理森林，對抗沙漠化，終止" +
                "及逆轉土地劣化，並遏止生物多樣性的喪失");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"15.1");
        d1.put(from[1],"在2020年前，依照在國際協定下的義務，保護、恢復及永續使用領地與內陸淡水生態系統" +
                "與他們的服務，尤其是森林、沼澤、山脈與旱地");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"15.2");
        d2.put(from[1],"在2020年前，進一步落實各式森林的永續管理，終止毀林，恢復遭到破壞的森林，並讓全球的造林增加x%");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"15.3");
        d3.put(from[1],"在2020年前，對抗沙漠化，恢復惡化的土地與土壤，包括受到沙漠化、乾旱及洪水影響的地區，致力" +
                "實現沒有土地破壞的世界");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"15.4");
        d4.put(from[1],"在2030年前，落實山脈生態系統的保護，包括他們的生物多樣性，以改善他們提供有關永續發展的有益能力");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"15.5");
        d5.put(from[1],"採取緊急且重要的行動減少自然棲息地的破壞，終止生物多樣性的喪失，在2020年前，保護及預防瀕危物種的絕種");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"15.6");
        d4.put(from[1],"確保基因資源使用所產生的好處得到公平公正的分享，促進基因資源使用的適當管道");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"15.7");
        d5.put(from[1],"採取緊急動作終止受保護動植物遭到盜採、盜獵與非法走私，並解決非法野生生物產品的供需");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d4.put(from[0],"15.8");
        d4.put(from[1],"在2020年前，採取措施以避免侵入型外來物種入侵陸地與水生態系統，且應大幅減少他們的影響" +
                "，並控管或消除優種");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"15.9");
        d5.put(from[1],"在2020年前，將生態系統與生物多樣性價值納入國家與地方規劃、發展流程與脫貧策略中");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d4.put(from[0],"15.a");
        d4.put(from[1],"動員並大幅增加來自各個地方的財物資源，以保護及永續使用生物多樣性與生態系統");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d5.put(from[0],"15.b");
        d5.put(from[1],"大幅動員來自各個地方的各階層的資源，以用於永續森林管理，並提供適當的獎勵給開發中國家改善永續" +
                "森林管理，包括保護及造林");
        data.add(d11);
        HashMap<String,String> d12 = new HashMap<>();
        d5.put(from[0],"15.c");
        d5.put(from[1],"改善全球資源，以對抗保護物種的盜採、盜獵與走私，作法包括提高地方社區的能力，以追求永續發展的謀生機會");
        data.add(d12);
    }
    private void addData16(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"16  ");
        d0.put(from[1],"促進和平且包容的社會，以落實永續發展；提供司法管道給所有人；在所有的階層建立" +
                "有效的、負責的且包容的制度");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"16.1");
        d1.put(from[1],"大幅減少各地各種形式的暴力以及有關的死亡率");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"16.2");
        d2.put(from[1],"終結各種形式的兒童虐待、剝削、走私、暴力以及施虐");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"16.3");
        d3.put(from[1],"促進國家與國際的法則，確保每個人都有公平的司法管道");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"16.4");
        d4.put(from[1],"在2030年前，大幅減少非法的金錢與軍火流，提高失物的追回，並對抗各種形式的組織犯罪");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"16.5");
        d5.put(from[1],"大幅減少各種形式的貪污賄賂");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"16.6");
        d4.put(from[1],"在所有的階層發展有效的、負責的且透明的制度");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"16.7");
        d5.put(from[1],"確保各個階層的決策回應民意，是包容的、參與的且具有代表性");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d4.put(from[0],"16.8");
        d4.put(from[1],"擴大及強化開發中國家參與全球管理制度");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"16.9");
        d5.put(from[1],"在2030年前，為所有的人提供合法的身分，包括出生登記");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d4.put(from[0],"16.10");
        d4.put(from[1],"依據國家立法與國際協定，確保民眾可取得資訊，並保護基本自由");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d5.put(from[0],"16.a");
        d5.put(from[1],"強化有關國家制度，作法包括透過國際合作，以建立在各個階層的能力，尤其是開發中國家，以預防暴力" +
                "並對抗恐怖主義與犯罪");
        data.add(d11);
        HashMap<String,String> d12 = new HashMap<>();
        d5.put(from[0],"16.b");
        d5.put(from[1],"促進及落實沒有歧視的法律與政策，以實現永續發展");
        data.add(d12);
    }
    private void addData17(){
        HashMap<String,String> d0 = new HashMap<>();
        d0.put(from[0],"17  ");
        d0.put(from[1],"強化永續發展執行方法及活化永續發展全球夥伴關係");
        data.add(d0);
        HashMap<String,String> d1 = new HashMap<>();
        d1.put(from[0],"17.1");
        d1.put(from[1],"強化本國的資源動員，作法包括提供國際支援給開發中國家，以改善他們的稅收與其他收益取得的能力");
        data.add(d1);
        HashMap<String,String> d2 = new HashMap<>();
        d2.put(from[0],"17.2");
        d2.put(from[1],"已開發國家全面落實他們的ODA承諾，包括在ODA中提供國民所得毛額（以下簡稱GNI）的0.7%給" +
                "開發中國家，其中0.15-0.20%應提供該給LDCs");
        data.add(d2);
        HashMap<String,String> d3 = new HashMap<>();
        d3.put(from[0],"17.3");
        d3.put(from[1],"從多個來源動員其他財務支援給開發中國家");
        data.add(d3);
        HashMap<String,String> d4 = new HashMap<>();
        d4.put(from[0],"17.4");
        d4.put(from[1],"透過協調政策協助開發中國家取得長期負債清償能力，目標放在提高負債融資、負債的解除，以及負責的重整，" +
                "並解決高負債貧窮國家（以下簡稱HIPC）的外部負債，以減少負債壓力");
        data.add(d4);
        HashMap<String,String> d5 = new HashMap<>();
        d5.put(from[0],"17.5");
        d5.put(from[1],"為 LDCs 採用及實施投資促進方案");
        data.add(d5);
        HashMap<String,String> d6 = new HashMap<>();
        d4.put(from[0],"17.6");
        d4.put(from[1],"在科學、科技與創新上，提高北半球與南半球、南半球與南半球，以及三角形區域性與國際合作，並使用公認的詞語" +
                "提高知識交流，作法包括改善現有機制之間的協調，尤其是聯合國水平，以及透過合意的全球科技促進機制");
        data.add(d6);
        HashMap<String,String> d7 = new HashMap<>();
        d5.put(from[0],"17.7");
        d5.put(from[1],"使用有利的條款與條件，包括特許權與優惠條款，針對開發中國家促進環保科技的發展、轉移、流通及擴散");
        data.add(d7);
        HashMap<String,String> d8 = new HashMap<>();
        d4.put(from[0],"17.8");
        d4.put(from[1],"在2017年前，為LDCs全面啟動科技銀行以及科學、科技與創新（以下簡稱STI）能力培養機制" +
                "，並提高科技的使用度，尤其是ICT");
        data.add(d8);
        HashMap<String,String> d9 = new HashMap<>();
        d5.put(from[0],"17.9");
        d5.put(from[1],"提高國際支援，以在開發中國家實施有效且鎖定目標的能力培養，以支援國家計畫，落實所有的永續發展目標，" +
                "作法包括北半球國家與南半球國家、南半球國家與南半球國家，以及三角合作");
        data.add(d9);
        HashMap<String,String> d10 = new HashMap<>();
        d4.put(from[0],"17.10");
        d4.put(from[1],"在世界貿易組織（以下簡稱WTO）的架構內，促進全球的、遵循規則的、開放的、沒有歧視的，以及公平" +
                "的多邊貿易系統，作法包括在杜哈發展議程內簽署協定");
        data.add(d10);
        HashMap<String,String> d11 = new HashMap<>();
        d5.put(from[0],"17.11");
        d5.put(from[1],"大幅增加開發中國家的出口，尤其是在2020年以前，讓LDCs的全球出口占比增加一倍");
        data.add(d11);
        HashMap<String,String> d12 = new HashMap<>();
        d5.put(from[0],"17.12");
        d5.put(from[1],"對所有LDCs，依照WTO的決定，如期實施持續性免關稅、沒有配額的市場進入管道，包括適用LDCs" +
                "進口的原產地優惠規則必須是透明且簡單的，有助市場進入");
        data.add(d12);
        HashMap<String,String> d13 = new HashMap<>();
        d4.put(from[0],"17.13");
        d4.put(from[1],"提高全球總體經濟的穩定性，作法包括政策協調與政策連貫");
        data.add(d13);
        HashMap<String,String> d14 = new HashMap<>();
        d5.put(from[0],"17.14");
        d5.put(from[1],"提高政策的連貫性，以實現永續發展");
        data.add(d14);
        HashMap<String,String> d15 = new HashMap<>();
        d5.put(from[0],"17.15");
        d5.put(from[1],"尊敬每個國家的政策空間與領導，以建立及落實消除貧窮與永續發展的政策");
        data.add(d15);
        HashMap<String,String> d16 = new HashMap<>();
        d4.put(from[0],"17.16");
        d4.put(from[1],"透過多邊合作輔助並提高全球在永續發展上的合作，動員及分享知識、專業、科技與財務支援" +
                "，以協助所有國家實現永續發展目標，尤其是開發中國家");
        data.add(d16);
        HashMap<String,String> d17 = new HashMap<>();
        d5.put(from[0],"17.17");
        d5.put(from[1],"依據合作經驗與資源策略，鼓勵及促進有效的公民營以及公民社會的合作");
        data.add(d17);
        HashMap<String,String> d18 = new HashMap<>();
        d5.put(from[0],"17.18");
        d5.put(from[1],"在2020年前，提高對開發中國家的能力培養協助，包括LDCs與SIDS，以大幅提高收入、性別、年齡、" +
                "種族、人種、移民身分、身心障礙、地理位置，以及其他有關特色的高品質且可靠的資料數據的如期取得性");
        data.add(d18);
        HashMap<String,String> d19 = new HashMap<>();
        d5.put(from[0],"17.19");
        d5.put(from[1],"在2030年前，依據現有的方案評量跟GDP有關的永續發展的進展，並協助開發中國家的統計能力培養");
        data.add(d19);
    }
}