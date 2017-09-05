package com.rusi.lbsci720.Utility;

import android.app.Application;

public class AppContext extends Application{
	private static Application appContext;

	private AppContext(){}

	public static Application getAppContext(){
		if (appContext == null){
			appContext = new AppContext();
		}
		return appContext;
	}
}
