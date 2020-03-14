package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class SignActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    EditText et_eposta,et_parola;
    Button btn_kayitOl;
    ImageView iv_geriDonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        initialWork();
        exqListener();

    }

    //Class
    private void initialWork() {
        et_eposta = (EditText) findViewById(R.id.et_EmailSign);
        et_parola = (EditText) findViewById(R.id.et_ParolaSign);
        btn_kayitOl = (Button) findViewById(R.id.btn_kayitOl);
        iv_geriDonus = (ImageView) findViewById(R.id.iv_geriDonus);
    }

    private void exqListener() {
        btn_kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(et_eposta.getText().toString().length() > 0 && et_parola.getText().toString().length() >0)
                    {
                        SignActivity.webservisArkaplan webservisArkaplan = new SignActivity.webservisArkaplan();
                        webservisArkaplan.setMethod("kayit_ol");
                        webservisArkaplan.setParametreler("userMail="+et_eposta.getText().toString()+"&userPassword="+et_parola.getText().toString());
                        webservisArkaplan.execute();
                    }else{
                        Toast.makeText(SignActivity.this,"Alanlar boş bırakılamaz!", Toast.LENGTH_LONG).show();
                    }

                }catch(Exception e)
                {
                    Toast.makeText(SignActivity.this,e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        iv_geriDonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //finish();
                overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
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
                Toast.makeText(SignActivity.this,"Kayıt Başarılı", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(SignActivity.this,"E-mail daha önce kayıt edilmiş!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
