package com.dummyapp.dependencyinjection;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by cl-macmini-86 on 7/7/17.
 */
@Module
public abstract class MyApplicationModule {
    @ContributesAndroidInjector
    abstract DependencyInjectionActivity contributeAcitivityInjector();
}
