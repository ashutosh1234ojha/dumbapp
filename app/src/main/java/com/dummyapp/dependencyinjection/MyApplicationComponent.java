package com.dummyapp.dependencyinjection;

import com.dummyapp.MyApplication;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by cl-macmini-86 on 7/7/17.
 */
@Component(modules = { AndroidInjectionModule.class, MyApplicationModule.class})
public interface MyApplicationComponent  extends AndroidInjector<MyApplication> {
}
