package com.example.lab15;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;
import java.util.Random;

public class MyAdapter extends BaseAdapter {
    Context context;
    protected MyApp myApp;
    //List<Note> notes;
    private final Random random;

    public MyAdapter(Context context){
        this.context = context.getApplicationContext();
        myApp = (MyApp) context.getApplicationContext();
        //notes = myApp.getNotes();
        random = new Random();
    }

    public int randomColor(){
        int n = 256;
        int r = random.nextInt(n);
        int b = random.nextInt(n);
        int g = random.nextInt(n);
        return Color.rgb(r, g , b);
    }
    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int i) {
        return notes.get(i);
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
        TextView textView1 = (TextView) view.findViewById(R.id.tv1);
        TextView textView2 = (TextView) view.findViewById(R.id.tv2);
        TextView textView3 = (TextView) view.findViewById(R.id.time);
        textView1.setText(notes.get(i).getTitle().toString());
        textView2.setText(notes.get(i).getText().toString());
        textView3.setText(notes.get(i).getTime().toString());
        ColoredView coloredView = (ColoredView) view.findViewById(R.id.cv);
        coloredView.setColor(randomColor());

        return view;
    }
}
