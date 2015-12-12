package com.example.arvind.serviceexample;




import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String LOG_CATEGORY = "MyService";
    

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(LOG_CATEGORY, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_CATEGORY, "onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        printNumbers();

        Log.d(LOG_CATEGORY, "stopping service");
        stopSelf();

        return START_NOT_STICKY;
    }

    private void printNumbers() {
        for (int i=0;i<25;i++) {
            Log.d(LOG_CATEGORY, "Elapsed " + i + "seconds");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
