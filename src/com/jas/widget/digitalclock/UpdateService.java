package com.jas.widget.digitalclock;

import java.lang.ref.Reference;
import java.util.Locale;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import java.util.Calendar;

import com.jas.widget.digitalclock.R;
public class UpdateService extends Service{
	public static final String TAG = "UpdateService";
	private DataTimeManager mdtm;
	private UpdateReceiver ur;
	RemoteViews remoteViews=null;
	
	RemoteViews remoteViews_ar=null;
	RemoteViews remoteViews_other=null;

	IntentFilter screenfilter;
	IntentFilter intentFilter;

	ComponentName componentName ;
	AppWidgetManager mAppWigetManager;

	//-------------zhumeiyan added --------------
	 // 数字图片的ID   
	   
    private int[] numberIcon = new int[] { R.drawable.digital_clock_time_0,  
            R.drawable.digital_clock_time_1, R.drawable.digital_clock_time_2,  
            R.drawable.digital_clock_time_3, R.drawable.digital_clock_time_4,  
            R.drawable.digital_clock_time_5, R.drawable.digital_clock_time_6,  
            R.drawable.digital_clock_time_7, R.drawable.digital_clock_time_8,  
            R.drawable.digital_clock_time_9 ,R.drawable.digital_clock_time_dot }; 
    // 用于显示数字的ImageView的ID   
    private int[] numberView = new int[] { R.id.hour01, R.id.hour02, R.id.double_dot, 
            R.id.minute01, R.id.minute02 };  
    //-------------zhumeiyan added end--------------
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.e("UpdateService", "onCreate");
	    mdtm = new DataTimeManager(this);
	    
	    ur = new UpdateReceiver();
	    intentFilter = new IntentFilter();
	    intentFilter.addAction(Intent.ACTION_TIME_CHANGED);
	    intentFilter.addAction(Intent.ACTION_TIME_TICK);
	    intentFilter.addAction(Intent.ACTION_DATE_CHANGED);
	    intentFilter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
	    intentFilter.addAction(Intent.ACTION_CONFIGURATION_CHANGED);
	    registerReceiver(ur, intentFilter);

		screenfilter = new IntentFilter();   
        screenfilter.addAction(Intent.ACTION_SCREEN_OFF);   
        screenfilter.addAction(Intent.ACTION_SCREEN_ON);   
        registerReceiver(receiver, screenfilter);   
	    
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		
		initUI();
		
		refurbishUI();
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		
		initUI();
		 
		refurbishUI();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("UpdateService", "onDestroy");
		unregisterReceiver(receiver);
		unregisterReceiver(ur);
	}
	
	private void initUI()
	{
		String str = Locale.getDefault().getLanguage();
		Log.e("UpdateService", "initUI");
        if(str.equals("ar"))
        {
        	if(remoteViews_ar == null)
        	{
        		remoteViews_ar = new RemoteViews(this.getPackageName(), R.layout.digital_clock_ar);
        		
        		Intent startActivityIntent = new Intent(this, WidgetActivity.class);  
                PendingIntent Pintent = PendingIntent.getActivity(this,0,startActivityIntent,0); 
                remoteViews_ar.setOnClickPendingIntent(R.id.ll,Pintent);
        	}
        	
        	remoteViews = remoteViews_ar;
        	
        }
        else {
        	if(remoteViews_other==null)
        	{
        		remoteViews_other = new RemoteViews(this.getPackageName(), R.layout.digital_clock);
        		
        		Intent startActivityIntent = new Intent(this, WidgetActivity.class);  
                PendingIntent Pintent = PendingIntent.getActivity(this,0,startActivityIntent,0); 
        		remoteViews_other.setOnClickPendingIntent(R.id.ll,Pintent);
        	}
        	
        	remoteViews = remoteViews_other;
		}

        if(componentName == null)
        {	
		 componentName = new ComponentName(this, DigitalClockWidget.class);
        }
		if(mAppWigetManager == null)
		{
         mAppWigetManager = AppWidgetManager.getInstance(this );
		}
		  
	}

	private void refurbishUI()
	{
		/*String timeString =mdtm.GetTime();  
        int num;  
        for (int i = 0; i < numberView.length; i++) {  
            num = timeString.charAt(i) - 48;  
            remoteViews.setImageViewResource(numberView[i], numberIcon[num]);  
        }*/
	    Calendar c = Calendar.getInstance();
		 int Hour = c.get(Calendar.HOUR_OF_DAY);
		 int Minute = c.get(Calendar.MINUTE);
		 Log.e("UpdateService", "refurbishUI");
		   remoteViews.setImageViewResource(numberView[0], numberIcon[Hour/10]);  //numberIcon[Hour/10]
			remoteViews.setImageViewResource(numberView[1], numberIcon[Hour%10]); //numberIcon[Hour%10]
			remoteViews.setImageViewResource(numberView[2], numberIcon[10]); 
			remoteViews.setImageViewResource(numberView[3],numberIcon[Minute/10]);  //numberIcon[Minute/10
			remoteViews.setImageViewResource(numberView[4], numberIcon[Minute%10]); //numberIcon[Minute%10]
			Log.e(TAG, "numberView[0]");
		//remoteViews.setTextViewText(R.id.time, mdtm.GetTime());
		remoteViews.setTextViewText(R.id.timeformat, mdtm.GetAMPM());
		remoteViews.setTextViewText(R.id.data, mdtm.GetDay()+"/"+mdtm.GetMonth());
		remoteViews.setTextViewText(R.id.week, mdtm.GetWeek());
		
		
		mAppWigetManager.updateAppWidget(componentName, remoteViews);
	}
	
	public class UpdateReceiver extends BroadcastReceiver
	{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals(Intent.ACTION_TIME_CHANGED)
					||intent.getAction().equals(Intent.ACTION_TIME_TICK) 
					|| intent.getAction().equals(Intent.ACTION_DATE_CHANGED)
					||intent.getAction().equals(Intent.ACTION_TIMEZONE_CHANGED)
					||intent.getAction().equals(Intent.ACTION_CONFIGURATION_CHANGED)) 
			{
				
				Log.e("UpdateService", intent.getAction());
				refurbishUI();
			}
		}
		
	}

	private final BroadcastReceiver receiver = new BroadcastReceiver(){    
    
    @Override    
    public void onReceive(final Context context, final Intent intent) {    
        // Do your action here    
        if(intent.getAction().equals(Intent.ACTION_SCREEN_ON))
		{
		 registerReceiver(ur, intentFilter);

		 refurbishUI();
		}
		else if(intent.getAction().equals(Intent.ACTION_SCREEN_OFF))
		{
         unregisterReceiver(ur);
		}
    
     }    
    
    };   
 
}
