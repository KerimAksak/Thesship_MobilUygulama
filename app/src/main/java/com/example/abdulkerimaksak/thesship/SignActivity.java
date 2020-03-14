package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

    private void initialWork() {
        et_eposta = (EditText) findViewById(R.id.et_Email);
        et_parola = (EditText) findViewById(R.id.et_Parola);
        btn_kayitOl = (Button) findViewById(R.id.btn_kayitOl);
        iv_geriDonus = (ImageView) findViewById(R.id.iv_geriDonus);
    }

    private void exqListener() {
        btn_kayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

}
