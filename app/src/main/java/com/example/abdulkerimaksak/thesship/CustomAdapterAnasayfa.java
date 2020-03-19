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

public class CustomAdapterAnasayfa extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<IlanAnasayfa> ilanList;

    public CustomAdapterAnasayfa(Activity activity, List<IlanAnasayfa> ilanList) {
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
        lineView = userInflater.inflate(R.layout.custom_layout_anasayfa, null);
        ImageView im_avatar = (ImageView) lineView.findViewById(R.id.iv_avatar);
        TextView tv_baslik = (TextView) lineView.findViewById(R.id.tv_baslik);
        TextView tv_icerik = (TextView) lineView.findViewById(R.id.tv_icerik);
        TextView tv_tarih = (TextView) lineView.findViewById(R.id.tv_IlanIcerikFull);
        TextView tv_saat = (TextView) lineView.findViewById(R.id.tv_saat);
        TextView tv_isim = (TextView) lineView.findViewById(R.id.tv_isimProfil);

        IlanAnasayfa ilan = ilanList.get(i);
        tv_baslik.setText(ilan.ilan_baslik);
        tv_icerik.setText(ilan.ilan_icerik);
        tv_tarih.setText(ilan.ilan_tarih);
        tv_saat.setText(ilan.ilan_saat);
        tv_isim.setText(ilan.user_name);//buraya userName gelmesi lazım.
        if(ilan.bitmap_is_have) {
            im_avatar.setImageBitmap(ilan.b);//userImage gelmesi lazım.
        }
        return lineView;
    }
}

