package com.example.michel.myalarm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.security.Provider;
import java.util.List;
import java.util.Map;

/**
 * Created by michel on 02/01/2018.
 */

public class RingtonPlayingService extends Service {

    MediaPlayer media_song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public int onStartCommand(Intent intent, int flags, int startId) {

        NotificationManager notify_manager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        Intent intent_main_activity = new Intent(this.getApplicationContext(), MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,
                intent_main_activity, 0);

        Notification notification_poupup = new Notification.Builder(this)
                .setContentTitle("le message est bien passé")
                .setContentText("ajout du text")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        notify_manager.notify(0,notification_poupup);

        media_song = MediaPlayer.create(this, R.raw.chariot_fire);
        media_song.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"On Destroy called", Toast.LENGTH_SHORT).show();
    }
}
