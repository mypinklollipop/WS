package com.example.ws;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Activity {
    MyAdapter adapter;
    private ListView listView;
    protected MyApp myApp;
    List<testValute> list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myApp = (MyApp) getApplicationContext();
        list = myApp.getValutes();
        listView = (ListView) findViewById(R.id.lv);
        adapter = new MyAdapter(myApp);
        listView.setAdapter(adapter);

        String tagName = "";
        int textNumCode = 0;
        String textCharCode = ""; String textName = ""; double textValue = 0;

        try {
            XmlPullParser xpp = prepareXpp();

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                switch (xpp.getEventType()) {
                    // начало тэга
                    case XmlPullParser.START_TAG:
                        tagName = xpp.getName();
                        break;
                        // конец тэга
                    case XmlPullParser.END_TAG:
                        tagName = xpp.getName();
                        if( tagName.equals("Valute") ){
                            testValute valute = new testValute(textNumCode, textCharCode, textName, textValue);
                            myApp.addValute(valute);
                        }
                        break;
                    // содержимое тэга
                    case XmlPullParser.TEXT:
                        if( tagName.equals("NumCode"))  textNumCode = Integer.parseInt(xpp.getText());
                        if (tagName.equals("CharCode")) textCharCode = xpp.getText();
                        if (tagName.equals("Name")) textName = xpp.getText();
                        if(tagName.equals("Value")) textValue = Double.valueOf(xpp.getText().replace(',','.'));
                        break;
                    default:
                        break;
                }
                // следующий элемент
                xpp.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    XmlPullParser prepareXpp() {
        return getResources().getXml(R.xml.data);
    }
}
