package com.gmail.kovalenko.getgifts.di;

import com.gmail.kovalenko.getgifts.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kate on 16.09.2017.
 */

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {

    public void inject(MainViewModel viewModel);

}