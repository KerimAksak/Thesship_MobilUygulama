package com.example.abdulkerimaksak.thesship;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class IlanlarimActivity extends AppCompatActivity {
    private static final int REQUEST_SIGNUP = 0;
    ListView listView;
    final List<Ilanlarim> ilanlarim = new ArrayList<Ilanlarim>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilanlarim);

        exqListener();
    }

    private void exqListener() {
        ilanlarim.add(new Ilanlarim("ilan ID", "user_id", "ilan_baslik", "ilan_icerik", "ilan_tarih"));
        CustomAdapterIlanlarim adapter = new CustomAdapterIlanlarim(this, ilanlarim);
        listView.setAdapter(adapter);
    }
}
