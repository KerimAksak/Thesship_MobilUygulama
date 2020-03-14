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
    private List<denemeVeri> userList;

    public CustomAdapter(Activity activity, List<denemeVeri> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
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

        denemeVeri denemeVeri = userList.get(i);
        tv_baslik.setText(denemeVeri.getBaslik());
        tv_icerik.setText(denemeVeri.getIcerik());
        tv_tarih.setText(denemeVeri.getTarih());
        tv_saat.setText(denemeVeri.getSaat());
        tv_isim.setText(denemeVeri.getIsim());
        im_avatar.setImageResource(R.drawable.back);

        return lineView;
    }
}

