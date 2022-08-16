package com.lesimoes.androidnotificationlistener;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class BootUpReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == Intent.ACTION_BOOT_COMPLETED){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    context.startForegroundService(new Intent(context, RNAndroidNotificationListener.class));
                } catch (Exception e) {
                    Log.e("RNAndroidNotificationListener", e.getMessage());
                }
                return;
            }
            context.startService(new Intent(context, RNAndroidNotificationListener.class));
        }

    }
}