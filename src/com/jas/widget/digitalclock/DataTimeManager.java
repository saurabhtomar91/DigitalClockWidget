package com.jas.widget.digitalclock;

import java.util.Calendar;
import java.util.Locale;

import com.jas.widget.digitalclock.R;

import android.content.Context;

public class DataTimeManager
{

	private Context mContext;
	private Calendar c = null;

	public DataTimeManager(Context context)
	{
		mContext = context;

		initCalendar();
	}

	private void initCalendar()
	{

		c = Calendar.getInstance();
	}

	public String GetTime()
	{

		initCalendar();

		String string = "";

		String hour = "", minute = "";

		if (c != null)
		{
			int Hour = c.get(Calendar.HOUR_OF_DAY);// 获取当前的小时数

			if (Hour < 10)
			{
				hour = "0" + String.valueOf(Hour);
			}
			else
			{
				hour = String.valueOf(Hour);
			}

			int Minute = c.get(Calendar.MINUTE);// 获取当前的分钟数

			if (Minute < 10)
			{
				minute = "0" + String.valueOf(Minute);
			}
			else
			{
				minute = String.valueOf(Minute);
			}

			// int Second = c.get(Calendar.SECOND);// 获取当前的分钟数

			// Log.i(TAG, String.valueOf(Minute));

			string = hour + ":" + minute;
			// + ":"+ String.valueOf(Second);
		}

		return string;
	}

	public String GetMonth()
	{
		String Month = "";
		int mou = c.get(Calendar.MONTH);
		switch (mou) {
			case 0:
				Month = mContext.getResources().getString(R.string.one);
				// Month = "01";
				break;
			case 1:
				Month = mContext.getResources().getString(R.string.two);
				// Month = "02";
				break;
			case 2:
				Month = mContext.getResources().getString(R.string.three);
				// Month = "03";
				break;
			case 3:
				Month = mContext.getResources().getString(R.string.four);
				// Month = "04";
				break;
			case 4:
				Month = mContext.getResources().getString(R.string.five);
				// Month = "05";
				break;
			case 5:
				Month = mContext.getResources().getString(R.string.six);
				// Month = "06";
				break;
			case 6:
				Month = mContext.getResources().getString(R.string.seven);
				// Month = "07";
				break;
			case 7:
				Month = mContext.getResources().getString(R.string.eight);
				// Month = "08";
				break;
			case 8:
				Month = mContext.getResources().getString(R.string.nine);
				// Month = "09";
				break;
			case 9:
				Month = mContext.getResources().getString(R.string.ten);
				// Month = "10";
				break;
			case 10:
				Month = mContext.getResources().getString(R.string.eleven);
				// Month = "11";
				break;
			case 11:
				Month = mContext.getResources().getString(R.string.tewelve);
				// Month = "12";
				break;
			default:
				break;
		}
		return Month;
	}

	public String GetDay()
	{
		String Day = "";
		int nday = c.get(Calendar.DAY_OF_MONTH);
		/*
		 * if (nday <= 9) { Day = "0" + String.valueOf(nday); } else { Day =
		 * String.valueOf(nday); }
		 */
		switch (nday) {
			case 0:
				Day = mContext.getResources().getString(R.string.one);
				break;
			case 1:
				Day = mContext.getResources().getString(R.string.two);
				break;
			case 2:
				Day = mContext.getResources().getString(R.string.three);
				break;
			case 3:
				Day = mContext.getResources().getString(R.string.four);
				break;
			case 4:
				Day = mContext.getResources().getString(R.string.five);
				break;
			case 5:
				Day = mContext.getResources().getString(R.string.six);
				break;
			case 6:
				Day = mContext.getResources().getString(R.string.seven);
				break;
			case 7:
				Day = mContext.getResources().getString(R.string.eight);
				break;
			case 8:
				Day = mContext.getResources().getString(R.string.nine);
				break;
			case 9:
				Day = mContext.getResources().getString(R.string.ten);
				break;
			case 10:
				Day = mContext.getResources().getString(R.string.eleven);
				break;
			case 11:
				Day = mContext.getResources().getString(R.string.tewelve);
				break;
			case 12:
				Day = mContext.getResources().getString(R.string.thirteen);
				break;
			case 13:
				Day = mContext.getResources().getString(R.string.fourteen);
				break;
			case 14:
				Day = mContext.getResources().getString(R.string.fifteen);
				break;
			case 15:
				Day = mContext.getResources().getString(R.string.sixteen);
				break;
			case 16:
				Day = mContext.getResources().getString(R.string.seventeen);
				break;
			case 17:
				Day = mContext.getResources().getString(R.string.eighteen);
				break;
			case 18:
				Day = mContext.getResources().getString(R.string.ninteen);
				break;
			case 19:
				Day = mContext.getResources().getString(R.string.twenty);
				break;
			case 20:
				Day = mContext.getResources().getString(R.string.twentyone);
				break;
			case 21:
				Day = mContext.getResources().getString(R.string.twentytwo);
				break;
			case 22:
				Day = mContext.getResources().getString(R.string.twentythree);
				break;
			case 23:
				Day = mContext.getResources().getString(R.string.twentyfour);
				break;
			case 24:
				Day = mContext.getResources().getString(R.string.twentyfive);
				break;
			case 25:
				Day = mContext.getResources().getString(R.string.twentysix);
				break;
			case 26:
				Day = mContext.getResources().getString(R.string.twentyseven);
				break;
			case 27:
				Day = mContext.getResources().getString(R.string.twentyeight);
				break;
			case 28:
				Day = mContext.getResources().getString(R.string.twentynine);
				break;
			case 29:
				Day = mContext.getResources().getString(R.string.therty);
				break;
			case 30:
				Day = mContext.getResources().getString(R.string.thertyone);
				break;
			default:
				break;

		}

		return Day;
	}

	public String GetWeek()
	{

		String week = "";
		int m = c.get(Calendar.DAY_OF_WEEK);

		switch (m) {
			case 1:
				week = mContext.getResources().getString(R.string.sun);
				break;
			case 2:
				week = mContext.getResources().getString(R.string.mon);
				break;
			case 3:
				week = mContext.getResources().getString(R.string.tues);
				break;
			case 4:
				week = mContext.getResources().getString(R.string.wed);
				break;
			case 5:
				week = mContext.getResources().getString(R.string.thurs);
				break;
			case 6:
				week = mContext.getResources().getString(R.string.fri);
				break;
			case 7:
				week = mContext.getResources().getString(R.string.sat);
				break;

			default:
				break;
		}

		return week;
	}

	public String GetAMPM()
	{
		String string = "";
		int m = c.get(Calendar.AM_PM);// 0 1
		switch (m) {
			case 0:
				string = mContext.getResources().getString(R.string.am);
				break;
			case 1:
				string = mContext.getResources().getString(R.string.pm);
				break;
			default:
				break;
		}
		return string;
	}
}