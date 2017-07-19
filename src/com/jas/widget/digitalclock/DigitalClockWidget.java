package com.jas.widget.digitalclock;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.provider.AlarmClock;
import android.util.Log;
import android.widget.RemoteViews;

public class DigitalClockWidget extends AppWidgetProvider {
	public static final String TAG = "DigitalClockWidget";
	
	private Context mContext;
	private AppWidgetManager mAppWigetManager;
	private DataTimeManager mdtm = null;
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i(TAG, "...onReceive");
		super.onReceive(context, intent);
		
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.i(TAG, "...onUpdate");
		Intent intent=new  Intent(context ,UpdateService.class );  
        context.startService(intent);    
        
    
		/*Intent startActivityIntent = new Intent(context, WidgetActivity.class);  
        PendingIntent Pintent = PendingIntent.getActivity(context,0,startActivityIntent,0); 
        
        RemoteViews views;
        String str = Locale.getDefault().getLanguage();
        if(str.equals("ar"))
        {
        	views = new RemoteViews(context.getPackageName(),R.layout.digital_clock);
        }
        else {
        	views = new RemoteViews(context.getPackageName(),R.layout.digital_clock);  
		}
        
        views = new RemoteViews(context.getPackageName(),R.layout.digital_clock);  
        views.setOnClickPendingIntent(R.id.ll,Pintent);  
        appWidgetManager.updateAppWidget(appWidgetIds,views);  */

	}

	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		Log.i(TAG, "...onDeleted");
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onEnabled(Context context) {
		Log.i(TAG, "...onEnabled");
		super.onEnabled(context);
	}

	@Override
	public void onDisabled(Context context) {
		Log.i(TAG, "...onDisabled");
		super.onDisabled(context);
		Intent intent=new  Intent(context ,UpdateService.class );  
		context.stopService(intent);
	}

}
