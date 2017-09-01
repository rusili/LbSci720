package com.rusi.lbsci720.Dagger;

import android.app.Application;

public class DaggerApplication extends Application{
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
