package com.example.lab15.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.lab15.R;

import java.sql.Time;

public class Second extends Base implements TextWatcher {
    private EditText editText1, editText2;
    private Button button1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        editText1 = (EditText) findViewById(R.id.title);
        editText2 = (EditText) findViewById(R.id.et);
        button1 = (Button) findViewById(R.id.btn2);
        button1.setEnabled(false);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            Note note = (Note) extras.getSerializable(EXTRA_NOTE);
            String title = note.getTitle().toString();
            String txt = note.getText().toString();
            if (txt!=null && title!=null) { editText1.setText(title); editText2.setText(txt); button1.setEnabled(true);}
        }
        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String s1 = editText1.getText().toString().trim().toString();
        String s2 = editText2.getText().toString().trim().toString();
        Integer l1 = s1.length();
        Integer l2 = s2.length();
        if (l1 == 0 || l2 == 0) {
            button1.setEnabled(false);
        }
        else {button1.setEnabled(true);};
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void ready(View view) {
        Time time = new Time(System.currentTimeMillis());
        Note note = new Note(editText1.getText().toString(), editText2.getText().toString(), time);

        Intent intent = getIntent();

        intent.putExtra(EXTRA_NOTE, note);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onCancel(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
