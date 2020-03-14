package com.example.abdulkerimaksak.thesship;

public class denemeVeri {
    private String baslik;
    private String icerik;
    private String tarih;
    private String saat;
    private String isim;

    public denemeVeri(String baslik, String icerik, String tarih, String saat, String isim) {
        this.baslik = baslik;
        this.icerik = icerik;
        this.tarih = tarih;
        this.saat = saat;
        this.isim = isim;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}
