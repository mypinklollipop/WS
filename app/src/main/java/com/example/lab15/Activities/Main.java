package com.example.lab15.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.lab15.MyAdapter;
import com.example.lab15.MyApp;
import com.example.lab15.R;

public class Main extends Base implements AdapterView.OnItemClickListener{
    MyAdapter adapter;
    private ListView listView;
    protected MyApp myApp;
    //List<Note> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        myApp = (MyApp) getApplicationContext();
        //list = myApp.getNotes();
        listView = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter(myApp);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    public void toAdd(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //Note s = list.get(i);
        String s = null; // Значение.
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_ID, i);
        intent.putExtra(EXTRA_NOTE, s);
        startActivityForResult(intent, EDIT_ACTION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            //Note note = (Note) extras.getSerializable(EXTRA_NOTE);
            switch (requestCode){
                case CREATE_ACTION:
                    //myApp.addNote(note);
                    break;
                case EDIT_ACTION:
                    int i = extras.getInt(EXTRA_ID);
                    //myApp.setNote(note, i);
                    break;
            }
            listView.invalidateViews();
        }
    }
}
