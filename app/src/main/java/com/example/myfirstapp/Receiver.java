package com.example.myfirstapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author vladimir.lichonos
 */
public class Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // see ReceiverActivity.onCreate()
        Intent activity = new Intent(context, ScreenSlidePagerActivity.class);
        activity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.putExtras(intent);
        context.startActivity(activity);
    }
}
