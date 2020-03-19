package com.example.abdulkerimaksak.thesship;

import android.graphics.Bitmap;

public class IlanAnasayfa {
    public String ilan_id;
    public String user_id;
    public String user_name;
    public String ilan_baslik;
    public String ilan_icerik;
    public String ilan_tarih;
    public String ilan_saat;
    public Bitmap b;
    public boolean bitmap_is_have = false;

    public IlanAnasayfa(String ilan_id, String user_id, String user_name, String ilan_baslik, String ilan_icerik, String ilan_tarih, String ilan_saat) {
        this.ilan_id = ilan_id;
        this.user_id = user_id;
        this.user_name = user_name;
        this.ilan_baslik = ilan_baslik;
        this.ilan_icerik = ilan_icerik;
        this.ilan_tarih = ilan_tarih;
        this.ilan_saat = ilan_saat;
    }
    public void setBitmap(Bitmap b){
        this.b=b;
        bitmap_is_have=true;
    }
}
