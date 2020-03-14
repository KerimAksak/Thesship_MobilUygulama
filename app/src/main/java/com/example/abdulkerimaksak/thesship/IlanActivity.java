package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class IlanActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    private EditText advert,advertBaslik;
    private Button btn_gonder;
    ShredPref shredPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan);

        initialWork();
        exqListener();
    }

    //Class
    private void initialWork() {
        btn_gonder = (Button) findViewById(R.id.btn_advertSendt);
        advert = (EditText)findViewById(R.id.et_Advert);
        advertBaslik = (EditText)findViewById(R.id.et_Ilan_Basligi);
        shredPref = new ShredPref(getApplicationContext());
    }

    private void exqListener() {

        shredPref.setNameSharedPref("loginSP");
        final String ID = shredPref.getString("ID","0");

        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(advert.length() > 0 )
                    {
                        String baslik = "deneme123baslik";
                        IlanActivity.webservisArkaplan webservisArkaplan = new IlanActivity.webservisArkaplan();
                        webservisArkaplan.setMethod("ilan_ekle");
                        webservisArkaplan.setParametreler("user_id="+ID+"&ilan_baslik="+advertBaslik.getText().toString()+"&ilan_icerik="+advert.getText().toString());
                        //webservisArkaplan.setParametreler("ID="+ID+"&Advert="+advert);
                        webservisArkaplan.execute();
                    }else{
                        Toast.makeText(IlanActivity.this,"Alanlar boş bırakılamaz!", Toast.LENGTH_LONG).show();
                    }

                }catch(Exception e)
                {
                    Toast.makeText(IlanActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //Web servis
    public class webservisArkaplan extends jsonWebServis{

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            List<Dogrulama> userList = new ArrayList<Dogrulama>();
            try {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                JsonParser jsonParser = new JsonParser();
                JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();
                for(int i=0;i<jsonArray.size();i++){
                    Dogrulama deger = gson.fromJson(jsonArray.get(i),Dogrulama.class);
                    userList.add(deger);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            if(userList.get(0).deger.equals("true")){
                Toast.makeText(IlanActivity.this,"İlan Paylaşıldı", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();//mevcut activity sona erer.
                overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);//Sağa geçiş animasyonu.
            }else{
                Toast.makeText(IlanActivity.this,"İlan Paylaşılamadı!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
