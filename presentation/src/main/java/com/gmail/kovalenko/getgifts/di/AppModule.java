package com.gmail.kovalenko.getgifts.di;

import com.gmail.kovalenko.domain.interctions.GetImageUseCase;
import com.gmail.kovalenko.domain.interctions.SearchUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public GetImageUseCase getImageUseCase(){
        return new GetImageUseCase();
    }

    @Provides
    public SearchUseCase searchUseCase(){
        return new SearchUseCase();
    }

}