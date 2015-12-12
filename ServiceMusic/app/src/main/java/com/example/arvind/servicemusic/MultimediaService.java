package com.example.arvind.servicemusic;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;

public class MultimediaService extends Service {
    private MediaPlayer mediaPlayer = null;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.kolaveri);
        }
        if ("start".equals(intent.getStringExtra("action"))) {

            mediaPlayer.start();
            mediaPlayer.setLooping(true); // Set looping
            mediaPlayer.setVolume(100,100);
            /*
            PendingIntent pi = PendingIntent.getActivity(
                    getApplicationContext(), 0, new Intent(
                            getApplicationContext(), MainActivity.class),
                    PendingIntent.FLAG_UPDATE_CURRENT);
            Notification notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setTicker("audion being played")
                    .setContentTitle("Playing song")
                    .setContentText("Playing song").setContentIntent(pi)
                    .build();
            notification.flags |= Notification.FLAG_ONGOING_EVENT;
//			notification.setLatestEventInfo(getApplicationContext(),
//					"MusicPlayerSample", "Playing: mysong", pi);
            startForeground(1, notification); */
        } else {
            mediaPlayer.stop();
            stopSelf();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
