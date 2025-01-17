package com.lesimoes.androidnotificationlistener;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import javax.annotation.Nullable;
import android.util.Log;

public class RNAndroidNotificationListenerHeadlessJsTaskService extends HeadlessJsTaskService {
    @Override
    protected @Nullable HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                return new HeadlessJsTaskConfig(
                        "RNAndroidNotificationListenerHeadlessJs",
                        Arguments.fromBundle(extras),
                        15000, // timeout for the task
                        true // optional: defines whether or not  the task is allowed in foreground. Default is false
                );
            } catch (Exception e) {
                Log.e("RNAndroidNotificationListener", e.getMessage());
            }
        }
        return null;
    }
}