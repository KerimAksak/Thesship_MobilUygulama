package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    EditText etEmail,etParola;
    Button btnGirisYap;
    ImageView ivGeriDon;
    TextView tvKayitOl;
    ShredPref shredPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialWork();
        exqListener();

    }

    //Class
    private void initialWork() {
        etEmail = (EditText) findViewById(R.id.et_Email);
        etParola = (EditText) findViewById(R.id.et_Parola);
        btnGirisYap = (Button) findViewById(R.id.btn_girisYap);
        ivGeriDon = (ImageView) findViewById(R.id.iv_geriDonus);
        tvKayitOl = (TextView) findViewById(R.id.tv_kayitOl);
        shredPref = new ShredPref(getApplicationContext());
    }

    private void exqListener() {
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            String getEmail = etEmail.getText().toString();
            String getParola = etParola.getText().toString();
            @Override
            public void onClick(View v) {
                try{
                    if(getEmail.length() > 0 && getParola.length() >0)
                    {
                        webservisArkaplan webservisArkaplan = new webservisArkaplan();
                        webservisArkaplan.setMethod("user_validate");
                        webservisArkaplan.setParametreler("mail="+getEmail+"&password="+getParola);
                        webservisArkaplan.execute();
                    }else{
                        Toast.makeText(LoginActivity.this,"Alanlar boş bırakılamaz!", Toast.LENGTH_LONG).show();
                    }

                }catch(Exception e)
                {
                    Toast.makeText(LoginActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        tvKayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SignActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
            }
        });

        ivGeriDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
            }
        });
    }

    //Web Servis
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
            //String gEmail = email.getText().toString();
            //String gPassword = password.getText().toString();
            //if(userList.get(0).userMail.equals(gEmail) && userList.get(0).userPassword.equals(gPassword)){
            if(userList.get(0).deger.equals("false")){
                Toast.makeText(LoginActivity.this,"E-mail ya da şifre hatalı!", Toast.LENGTH_LONG).show();
            }else{
                shredPref.setNameSharedPref("loginSP");
                shredPref.putString("ID",userList.get(0).deger);
                shredPref.commit();

                /*
                //Toast.makeText(LoginActivity.this,"Giriş Başarılı", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);//requestCode nedir? 2. parametre..
                finish();//mevcut activity sona erer.
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
                */
            }
        }
    }

}
