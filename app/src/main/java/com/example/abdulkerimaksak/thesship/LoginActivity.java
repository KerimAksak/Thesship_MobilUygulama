package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    EditText etEmail,etParola;
    Button btnGirisYap;
    ImageView ivGeriDon;
    TextView tvKayitOl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialWork();
        exqListener();

    }

    private void initialWork() {
        etEmail = (EditText) findViewById(R.id.et_Email);
        etParola = (EditText) findViewById(R.id.et_Parola);
        btnGirisYap = (Button) findViewById(R.id.btn_girisYap);
        ivGeriDon = (ImageView) findViewById(R.id.iv_geriDonus);
        tvKayitOl = (TextView) findViewById(R.id.tv_kayitOl);
    }

    private void exqListener() {
        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menu activity
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
                //finish();
                overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
            }
        });
    }

}
