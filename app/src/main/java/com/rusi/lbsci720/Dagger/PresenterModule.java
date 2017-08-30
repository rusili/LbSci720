package com.rusi.lbsci720.Dagger;

import com.rusi.lbsci720.Activity.Main.MainInterface;
import com.rusi.lbsci720.Activity.Main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
	@Provides
	@Singleton
	MainInterface.Presenter providesMainPresenter(){
		return new MainPresenter();
	}
}
