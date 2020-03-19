package com.example.abdulkerimaksak.thesship;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ShredPref spa;
    String id;
    private static final int REQUEST_SIGNUP = 0;
    ListView listView;
    final List<IlanAnasayfa> ilanlar = new ArrayList<IlanAnasayfa>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initialWork();
        exqListener();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.ilanYaz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getApplicationContext(),IlanActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //finish();
                overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void initialWork() {
        listView = (ListView) findViewById(R.id.listView);
        spa = new ShredPref(getApplicationContext());
        spa.setNameSharedPref("loginSP");
        id = spa.getString("ID","false");

        //sunucu koptuğu için alttaki hariç wsa ları aç
        //ilanlar.add(new IlanAnasayfa("ilan ID", "user_id","user_name","ilan_baslik", "ilan_icerik", "ilan_tarih","ilan_saat"));

/*
        WSA wsa = new WSA();
        wsa.setMethod("ilan_liste_user_veya_hepsi");
        wsa.setParametreler("user_id=hepsi");
        wsa.execute();
*/
    }

    private void exqListener() {
        ilanlar.add(new IlanAnasayfa("ilan ID", "1", "user-name","ilan_baslik", "ilan_icerik", "ilan_tarih","ilan_saat"));
        ilanlar.add(new IlanAnasayfa("ilan ID", "2", "kerimaksak","ilan_baslik", "ilan_icerik", "ilan_tarih","ilan_saat"));
        ilanlar.add(new IlanAnasayfa("ilan ID", "3", "user-name","ilan_baslik", "ilan_icerik", "ilan_tarih","ilan_saat"));
        CustomAdapterAnasayfa adapter = new CustomAdapterAnasayfa(this, ilanlar);
        listView.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "buraya girdi.", Toast.LENGTH_LONG).show();
        for (int i =0;i<ilanlar.size();i++) {
            onClickDosyaIndir(ilanlar.get(i).user_id, i);
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profil) {
            Intent intent = new Intent(getApplicationContext(),ProfilActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
        } else if (id == R.id.Ilanlarım) {
            Intent intent = new Intent(getApplicationContext(),IlanlarimActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
            overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);//Sağa geçiş animasyonu.
        } else if (id == R.id.kayitliIlan) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class WSA extends jsonWebServis{

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);

            List<IlanAnasayfa> ilanList = Listele(IlanAnasayfa.class);
            for (IlanAnasayfa i:ilanList) {
                ilanlar.add(i);
            }
            ilanlar.add(new IlanAnasayfa("ilan ID", "1","user_name","ilan_baslik", "ilan_icerik", "ilan_tarih","ilan_saat"));
            CustomAdapterAnasayfa adapter = new CustomAdapterAnasayfa(MenuActivity.this, ilanlar);
            listView.setAdapter(adapter);
            Toast.makeText(getApplicationContext(), "buraya girdi.", Toast.LENGTH_LONG).show();
            for(int i=0; i< ilanlar.size();i++){
                onClickDosyaIndir(ilanlar.get(i).user_id,i);
            }
        }
    }

    /*
    public class ria extends AsyncTask <String, String, String>{
        @Override
        protected void onPreExecute(){

        }

        @Override
        protected String doInBackground(String... strings) {


            return  "";
        }

        @Override
        protected void onPostExecute(String s) {

        }





    }*/

    public void onClickDosyaIndir( final String id,final int i) {
        String dosyaAdresi="http://thesship.izumobil.com/user_photos/";
        dosyaAdresi = dosyaAdresi + id + "_1.jpg";
        final AsyncHttpClient client = new AsyncHttpClient();

        client.get(dosyaAdresi, new BinaryHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] fileData) {
                try {

                    Bitmap bmp1 = BitmapFactory.decodeByteArray(fileData,0,fileData.length);
                    ilanlar.get(i).b=bmp1;
                    ilanlar.get(i).bitmap_is_have=true;
                    CustomAdapterAnasayfa adapter = new CustomAdapterAnasayfa(MenuActivity.this, ilanlar);
                    listView.setAdapter(adapter);
                    Toast.makeText(getApplicationContext(), "buraya da girdi.", Toast.LENGTH_LONG).show();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] binaryData, Throwable error) {

            }

        });
    }



}
