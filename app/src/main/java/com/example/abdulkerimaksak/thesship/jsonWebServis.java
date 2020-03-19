package com.example.abdulkerimaksak.thesship;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class jsonWebServis extends AsyncTask <String, String, String>{
    public String webServiceAddress = "---------";//web servis url
    public String method=null;
    public String parametreler = "?";
    public String json = "";

    public void setMethod(String a){
        method=a;
    }
    public void setParametreler(String a){
        parametreler+=a;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            if(!method.equals(null)){
                webServiceAddress+=method;
            }
            if(!parametreler.equals("?")){
                webServiceAddress+=parametreler;
            }
            URL url = new URL(webServiceAddress);
            json = getStringFromInputStream(url.openStream());
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        return  json;
    }

    @Override
    protected void onPostExecute(String s) {
        //doingbackground işlemi bittikten sonra çalışır
        /*
        try {

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            JsonParser jsonParser= new JsonParser();
            JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    private String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public <T> List<T> Listele(Class<T> classOfT)   {
        //public <T> void Listele( Class<T> classOfT)   {
        List list = new ArrayList();
        list.add(classOfT);

        List<T> tList = new ArrayList<T>();

        try {
            //http://varmigelen.izumobil.com/altdeneme/varmigelenWS.asmx/jasonLogin?mail=muazdervent@gmail.com&pass=123


            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            JsonParser jsonParser= new JsonParser();
            JsonArray jsonArray = jsonParser.parse(json).getAsJsonArray();
            for (int i = 0; i < jsonArray.size(); i++) {

                tList.add(gson.fromJson(jsonArray.get(i), classOfT));
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return tList;
    }


}


