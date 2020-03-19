package com.example.abdulkerimaksak.thesship;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BinaryHttpResponseHandler;

public class ResimIndir {

    Bitmap b;
    String dosyaAdresi="http://thesship.izumobil.com/user_photos/";

    public void onClickDosyaIndir(String id) {
        dosyaAdresi = dosyaAdresi + id + ".jpg";
        final AsyncHttpClient client = new AsyncHttpClient();

        client.get(dosyaAdresi, new BinaryHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] fileData) {
                try {

                    Bitmap bmp1 = BitmapFactory.decodeByteArray(fileData,0,fileData.length);
                    b=bmp1;


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
