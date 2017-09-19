package com.gmail.kovalenko.getgifts;


import android.app.Application;

import com.gmail.kovalenko.getgifts.di.AppComponent;
import com.gmail.kovalenko.getgifts.di.AppModule;
import com.gmail.kovalenko.getgifts.di.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;


/**
 * Created by kate on 16.09.2017.
 */

public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

    }
}
