package com.rusi.lbsci720.Utility;

import android.app.Application;

import com.rusi.lbsci720.Dagger.AppComponent;
import com.rusi.lbsci720.Dagger.AppModule;
import com.rusi.lbsci720.Dagger.DaggerAppComponent;

public class LbSci720 extends Application{
	private AppComponent appComponent;

	@Override
	public void onCreate () {
		super.onCreate();
		appComponent = DaggerAppComponent.builder()
			  .appModule(new AppModule(this))
			  .build();
	}

	public AppComponent getAppComponent(){
		return appComponent;
	}
}
