package com.example.michel.myalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by michel on 02/01/2018.
 */

public class Alarm_Receiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Intent service_intent = new Intent(context, RingtonPlayingService.class);
        context.startService(service_intent);
    }
}
