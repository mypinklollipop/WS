package com.example.lab15;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.example.lab15.Activities.Main;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


public class MyApp extends Application {
    //private final List<Note> notes = new ArrayList<>();
    ToastHelper toastHelper = new ToastHelper(this);;
    private static final int id1 = 460;
    private static final int id2 = 644;
    public MyApp() {
        super();
        Time time = new Time(System.currentTimeMillis());
        //Note note = new Note("Yesterday", "Go shopping.", time);
        //notes.add(note);
    }

    //public List<Note> getNotes() {
    //    return notes;
    //}

    public void addNote(Note s){
        //notes.add(s);
        toastHelper.Show(getString(R.string.add));
        String not = getString(R.string.add) + ": " + s.getText();
        showNotification(id1, not);
    }

    public void setNote(Note c, int i){
        //notes.set(i, c);
        toastHelper.Show(getString(R.string.set));
        String not = getString(R.string.set) + ": " + c.getText();
        showNotification(id2, not);
    }

    private void showNotification(int id, String text){
        Intent intent = new Intent(this, Main.class);
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        RemoteViews view = new RemoteViews(getPackageName(), R.layout.notifiaction);
        view.setImageViewResource(R.id.image, R.mipmap.ic_launcher);
        view.setTextViewText(R.id.title, getString(R.string.app_name));
        view.setTextViewText(R.id.description, text);
        String id_m = "my_channel";
        int importance = NotificationManager.IMPORTANCE_LOW;
        NotificationChannel channel = new NotificationChannel(id_m, "my_notification", importance);
        channel.enableLights(true);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setChannelId(id_m);
        builder
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setTicker("New message")
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setContent(view);
        Notification notification = builder.build();
        notification.flags = Notification.FLAG_NO_CLEAR;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        manager.notify(id, notification);
    }

}
