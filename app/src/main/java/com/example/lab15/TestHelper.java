package com.example.lab15;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class TestHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyNote";

    public static final class Tests{
        public static final String TABLE_NAME = "Notes";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TEXT = "text";
        public static final String COLUMN_TIME = "time";

        public static String getCreateStatement(){
            return String.format(
                    "CREATE TABLE %s(" + "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "%s TEXT," + "%s TEXT," + "%s INTEGER" + ")", TABLE_NAME, BaseColumns._ID, COLUMN_TITLE, COLUMN_TEXT, COLUMN_TIME
            );
        }

        public static String[] getTest(SQLiteDatabase db){
            Cursor cursor = db.query(TABLE_NAME,  null, null, null, null, null,null);
            if (cursor != null) {
                String[] str = new String[cursor.getCount()];
                if (cursor.moveToFirst()) {
                    int i = 0;
                    do {
                        int ID = cursor.getColumnIndex(BaseColumns._ID),
                                surnameID = cursor.getColumnIndex(COLUMN_SURNAME),
                                nameID = cursor.getColumnIndex(COLUMN_NAME),
                                ageID = cursor.getColumnIndex(COLUMN_AGE);
                        String id = cursor.getString(ID);
                        String testSurname = cursor.getString(surnameID);
                        String testName = cursor.getString(nameID);
                        String testAge = cursor.getString(ageID);
                        str[i] = id + " " + testSurname + " " + testName + " " + testAge;
                        i++;
                    } while (cursor.moveToNext());

                }
                cursor.close();
                return str;
            }
            return null;
        }

        public static long insertTest(SQLiteDatabase db, String testSurname, String testName, int testAge){
            ContentValues values = new ContentValues();
            values.put(COLUMN_SURNAME, testSurname);
            values.put(COLUMN_NAME, testName);
            values.put(COLUMN_AGE, testAge);
            return db.insert(TABLE_NAME, null, values);
        }

        public static long editTest(SQLiteDatabase db, String testSurname, String testName, int testAge, Integer id){
            ContentValues values = new ContentValues();
            values.put(COLUMN_SURNAME, testSurname);
            values.put(COLUMN_NAME, testName);
            values.put(COLUMN_AGE, testAge);
            return db.update(TABLE_NAME, values, BaseColumns._ID + " = " + id.toString(), null);
        }

        public static long delTest(SQLiteDatabase db, Integer id){
            return db.delete(TABLE_NAME,   BaseColumns._ID + " = " + id.toString(), null);
        }

        public static String[] searchTest(SQLiteDatabase db, Integer age){
            Cursor c = db.query(TABLE_NAME,  null, COLUMN_AGE + " > " + age.toString(), null, null, null,null);
            if (c != null) {
                String[] str = new String[c.getCount()];
                if (c.moveToFirst()) {
                    int i = 0;
                    do {
                        int ID = c.getColumnIndex(BaseColumns._ID),
                                surnameID = c.getColumnIndex(COLUMN_SURNAME),
                                nameID = c.getColumnIndex(COLUMN_NAME),
                                ageID = c.getColumnIndex(COLUMN_AGE);
                        String id = c.getString(ID);
                        String testSurname = c.getString(surnameID);
                        String testName = c.getString(nameID);
                        String testAge = c.getString(ageID);
                        str[i] = id + " " + testSurname + " " + testName + " " + testAge;
                        i++;
                    } while (c.moveToNext());
                }
                c.close();
                return str;
            }
            return null;
        }

    }
    public TestHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tests.getCreateStatement());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
