package com.rusi.lbsci720.Dagger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = {AppModule.class, PresenterModule.class})
public interface AppComponent {
}
