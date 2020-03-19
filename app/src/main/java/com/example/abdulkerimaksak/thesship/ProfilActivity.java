package com.example.abdulkerimaksak.thesship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProfilActivity extends AppCompatActivity {
    EditText et_Isım, et_UniAdi, et_Bolum;
    TextView tv_Isim, tv_UniAdi, tv_Bolum;
    ImageView iv_Profil;
    Button btn_Guncelle;
    ShredPref spa ;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initialWorkMain();
        exqListenerMain();
    }

    private void initialWorkMain() {
        et_Isım = (EditText) findViewById(R.id.et_isimProfil);
        et_UniAdi = (EditText) findViewById(R.id.et_uniAdiProfil);
        et_Bolum = (EditText) findViewById(R.id.et_bolumProfil);
        tv_Isim = (TextView) findViewById(R.id.tv_isimProfil);
        tv_UniAdi = (TextView) findViewById(R.id.tv_uniAdiProfil);
        tv_Bolum = (TextView) findViewById(R.id.tv_bolumProfil);
        iv_Profil = (ImageView) findViewById(R.id.iv_Profil);
        btn_Guncelle = (Button) findViewById(R.id.btn_guncelleProfil);

        spa = new ShredPref(getApplicationContext());

        spa.setNameSharedPref("loginSP");
        id = spa.getString("ID","false");

        WSA wsa = new WSA();
        wsa.setMethod("user_getir");
        wsa.setParametreler("user_id="+id);
        wsa.execute();
    }

    private void exqListenerMain() {
        btn_Guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public class WSA extends jsonWebServis{

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            List<User> userList = Listele(User.class);


            if(!userList.get(0).user_id.isEmpty()) {
                User u = userList.get(0);
                tv_Isim.setText(u.user_name);
                tv_Bolum.setText(u.bolum_name);
                tv_UniAdi.setText(u.uni_name);

                et_Isım.setText(u.user_name);
                et_Bolum.setText(u.bolum_name);
                et_UniAdi.setText(u.uni_name);
            }
        }
    }

}
