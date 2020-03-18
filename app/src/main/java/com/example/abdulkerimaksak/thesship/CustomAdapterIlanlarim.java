package com.example.abdulkerimaksak.thesship;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapterIlanlarim extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<Ilanlarim> ilanList;

    public CustomAdapterIlanlarim(Activity activity, List<Ilanlarim> ilanList) {
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
        lineView = userInflater.inflate(R.layout.custom_layout_ilanlarim, null);
        TextView tv_baslik = (TextView) lineView.findViewById(R.id.tv_ilanBaslik);
        TextView tv_icerik = (TextView) lineView.findViewById(R.id.tv_IlanIcerikIlanlarim);
        TextView tv_tarih = (TextView) lineView.findViewById(R.id.tv_ilanTarih);

        Ilanlarim ilan = ilanList.get(i);
        tv_baslik.setText(ilan.getIlan_baslik());
        tv_icerik.setText(ilan.getIlan_icerik());
        tv_tarih.setText(ilan.getIlan_tarih());

        return lineView;
    }
}
