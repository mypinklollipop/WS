package com.example.ws;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.Random;

public class MyAdapter extends BaseAdapter {
    Context context;
    protected MyApp myApp;
    List<testValute> valutes;
    List<Flag> flagList;

    public MyAdapter(Context context){
        this.context = context.getApplicationContext();
        myApp = (MyApp) context.getApplicationContext();
        valutes = myApp.getValutes();
        flagList = myApp.getFlagList();
    }

    @Override
    public int getCount() {
        return valutes.size();
    }

    @Override
    public testValute getItem(int i) {
        return valutes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lv, viewGroup, false);
        }
        double cursBuyD= valutes.get(i).getValuteValue() + (valutes.get(i).getValuteValue()* 0.1);
        double cursSellD= valutes.get(i).getValuteValue() - (valutes.get(i).getValuteValue()* 0.1);
        TextView textView1 = (TextView) view.findViewById(R.id.tv1);
        TextView textView2 = (TextView) view.findViewById(R.id.tv2);
        TextView textView3 = (TextView) view.findViewById(R.id.buy);
        TextView textView4 = (TextView) view.findViewById(R.id.sell);
        TextView textView5 = (TextView) view.findViewById(R.id.str);
        TextView textView6 = (TextView) view.findViewById(R.id.str2);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv);
        textView1.setText(valutes.get(i).getValuteCharCode().toString());
        textView2.setText(valutes.get(i).getValuteName().toString());
        textView3.setText(String.format("%.2f",cursBuyD));
        textView4.setText(String.format("%.2f",cursSellD));

        String flagName="default";  // имя файла с изображением по умолчанию, которое выводится, если для данной валюты изображения с флагом страны нет

        for (Flag flags : flagList) {
            if (flags.getName().equals(valutes.get(i).getValuteCharCode().toString())) {
                flagName= flags.getCharac();
            }
        }

        int id1 = context.getResources().getIdentifier("com.example.ws:drawable/" + flagName, null, null);
        imageView.setImageResource(id1);



        if(i % 2 ==0) {
            textView5.setText("↓");
            textView5.setTextColor(ContextCompat.getColor(context, R.color.red));
            textView6.setText("↑");
            textView6.setTextColor(ContextCompat.getColor(context, R.color.green));
        } else {
            textView6.setText("↓");
            textView6.setTextColor(ContextCompat.getColor(context, R.color.red));
            textView5.setText("↑");
            textView5.setTextColor(ContextCompat.getColor(context, R.color.green));
        }
        return view;
    }
}
