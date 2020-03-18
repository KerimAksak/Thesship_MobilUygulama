package com.example.abdulkerimaksak.thesship;

public class Ilanlarim {
    public String ilan_id;
    public String user_id;
    public String ilan_baslik;
    public String ilan_icerik;
    public String ilan_tarih;

    public Ilanlarim(String ilan_id, String user_id, String ilan_baslik, String ilan_icerik, String ilan_tarih) {
        this.ilan_id = ilan_id;
        this.user_id = user_id;
        this.ilan_baslik = ilan_baslik;
        this.ilan_icerik = ilan_icerik;
        this.ilan_tarih = ilan_tarih;
    }

    public String getIlan_id() {
        return ilan_id;
    }

    public void setIlan_id(String ilan_id) {
        this.ilan_id = ilan_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getIlan_baslik() {
        return ilan_baslik;
    }

    public void setIlan_baslik(String ilan_baslik) {
        this.ilan_baslik = ilan_baslik;
    }

    public String getIlan_icerik() {
        return ilan_icerik;
    }

    public void setIlan_icerik(String ilan_icerik) {
        this.ilan_icerik = ilan_icerik;
    }

    public String getIlan_tarih() {
        return ilan_tarih;
    }

    public void setIlan_tarih(String ilan_tarih) {
        this.ilan_tarih = ilan_tarih;
    }
}
