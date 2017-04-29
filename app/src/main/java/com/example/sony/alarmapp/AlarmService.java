package com.example.sony.alarmapp;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class AlarmService extends IntentService{

    NotificationManager nm;

    public AlarmService() {
        super("AlarmService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
sendNotification("WakeUp");
    }

    private void sendNotification(String msg) {
        nm=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent pi = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder alamNotificationBuilder = new NotificationCompat.Builder(
                this).setContentTitle("Alarm").setSmallIcon(R.drawable.alrm)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setContentText(msg);

        alamNotificationBuilder.setContentIntent(pi);
        nm.notify(1, alamNotificationBuilder.build());

    }


}
