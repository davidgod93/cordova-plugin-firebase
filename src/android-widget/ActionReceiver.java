package es.umivale.pya;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class ActionReceiver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        if(b != null) {
            try {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"));
                startActivity(i);
            } catch (Exception e) {
                Log.e("umivale", "Error realizando llamada desde widget.");
                e.printStackTrace();
            }
        }
        refreshWidget();
        finish();
    }

    private void refreshWidget() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        ComponentName thisAppWidgetComponentName = new ComponentName(getPackageName(), EmergencyWidget.class.getClass().getName());
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidgetComponentName);
        for (int id: appWidgetIds) EmergencyWidget.updateAppWidget(this, appWidgetManager, id);
    }
}
