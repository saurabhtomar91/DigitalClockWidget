package com.jas.widget.digitalclock;

import com.jas.widget.digitalclock.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class WidgetActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.e("WidgetActivity", "onCreate");
		Intent intent = new Intent();
		intent.setComponent(new ComponentName("com.android.deskclock",
				"com.android.deskclock.AlarmClock"));
		try {
			startActivity(intent);
		} catch (Exception e) {
			// TODO: handle exception
		}
        finish();
	}
}