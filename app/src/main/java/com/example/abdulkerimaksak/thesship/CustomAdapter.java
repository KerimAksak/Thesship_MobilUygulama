package com.example.abdulkerimaksak.thesship;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<Ilan> ilanList;

    public CustomAdapter(Activity activity, List<Ilan> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.ilanList = ilanList;
    }

    @Override
    public int getCount() {
        return ilanList.size();
    }

    @Override
    public Object getItem(int i) {
        return ilanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.custom_layout, null);
        ImageView im_avatar = (ImageView) lineView.findViewById(R.id.iv_avatar);
        TextView tv_baslik = (TextView) lineView.findViewById(R.id.tv_baslik);
        TextView tv_icerik = (TextView) lineView.findViewById(R.id.tv_icerik);
        TextView tv_tarih = (TextView) lineView.findViewById(R.id.tv_tarih);
        TextView tv_saat = (TextView) lineView.findViewById(R.id.tv_saat);
        TextView tv_isim = (TextView) lineView.findViewById(R.id.tv_isim);

        Ilan ilan = ilanList.get(i);
        tv_baslik.setText(ilan.getIlan_baslik());
        tv_icerik.setText(ilan.getIlan_icerik());
        tv_tarih.setText(ilan.getIlan_tarih());
        tv_saat.setText(ilan.getIlan_saat());
        tv_isim.setText(ilan.getUser_id());//buraya userName gelmesi lazım.
        im_avatar.setImageResource(R.drawable.back);//userImage gelmesi lazım.

        return lineView;
    }
}

