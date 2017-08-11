package com.mobilendo.cordova.umivale;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by davidzamora on 26/7/17.
 */

public class InstallationDetector extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent arg1) {
        Log.println(Log.ASSERT, "UMIVALE-LOG", "Broadcast recibido");
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName thisAppWidgetComponentName = new ComponentName(context.getPackageName(), EmergencyWidget.class.getClass().getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidgetComponentName);
        for (int id: appWidgetIds) EmergencyWidget.updateAppWidget(context, appWidgetManager, id);
    }
}
