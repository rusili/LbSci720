package com.rusi.lbsci720.Dagger;

import com.rusi.lbsci720.Activity.Main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class, PresenterModule.class})
public interface AppComponent {
	void inject(MainActivity target);
}
