package com.example.ws;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class MyApp extends Application {
    private final List<testValute> valutes = new ArrayList<>();
    private final List<Flag>flagList=new ArrayList<>();
    private static final int id1 = 460;
    private static final int id2 = 644;
    public MyApp() {
        super();
        flagList.add(new Flag("AUD","au"));
        flagList.add(new Flag("AZN","az"));
        flagList.add(new Flag("GBP","uk"));
        flagList.add(new Flag("AMD","am"));
        flagList.add(new Flag("BYN","by"));
        flagList.add(new Flag("BGN","bg"));
        flagList.add(new Flag("BRL","br"));
        flagList.add(new Flag("HUF","hu"));
        flagList.add(new Flag("HKD","hk"));
        flagList.add(new Flag("DKK","dk"));
        flagList.add(new Flag("USD","us"));

        flagList.add(new Flag("EUR","eu"));
        flagList.add(new Flag("INR","in"));
        flagList.add(new Flag("KZT","kz"));
        flagList.add(new Flag("CAD","ca"));
        flagList.add(new Flag("KGS","kg"));
        flagList.add(new Flag("CNY","cn"));
        flagList.add(new Flag("MDL","md"));
        flagList.add(new Flag("NOK","no"));
        flagList.add(new Flag("PLN","pl"));
        flagList.add(new Flag("RON","ro"));

        flagList.add(new Flag("SGD","sg"));
        flagList.add(new Flag("TJS","tj"));
        flagList.add(new Flag("TRY","tr"));
        flagList.add(new Flag("TMT","tm"));
        flagList.add(new Flag("UZS","uz"));
        flagList.add(new Flag("UAH","ua"));
        flagList.add(new Flag("CZK","cz"));
        flagList.add(new Flag("SEK","se"));
        flagList.add(new Flag("CHF","ch"));
        flagList.add(new Flag("ZAR","za"));
        flagList.add(new Flag("KRW","kr"));
        flagList.add(new Flag("JPY","jp"));

    }

    public List<testValute> getValutes() {
        return valutes;
    }

    public void addValute(testValute s){
        valutes.add(s);
    }

    public void setValute(testValute c, int i){
        valutes.set(i, c);
    }

    public List<Flag> getFlagList(){
        return flagList;
    }

}
