package com.gmail.kovalenko.getgifts;

import android.databinding.ObservableField;
import android.util.Log;

import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.domain.interctions.GetImageUseCase;
import com.gmail.kovalenko.domain.interctions.SearchUseCase;
import com.gmail.kovalenko.getgifts.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class MainViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, DATA, EMPTY}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    @Inject
    public GetImageUseCase getUseCase;

    @Inject
    public SearchUseCase searchUseCase;

    public GiftsAdapter adapter = new GiftsAdapter();

    public MainViewModel() {
        App.appComponent.inject(this);
    }

    @Override
    public void init() {
    }

    @Override
    public void resume() {

        getUseCase.execute(null, new DisposableObserver<List<FixedHeight>>() {
            @Override
            public void onNext(@NonNull List<FixedHeight> fixedHeights) {
                adapter.setItems(fixedHeights);
                Log.d("AAAAA", "fixedHeights "+ fixedHeights.get(0).getUrl());
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                state.set(STATE.DATA);
                Log.d("AAAAA", "onError"+ e.toString());
            }

            public void onComplete() {

            }
        });
    }

    @Override
    public void release() {
        getUseCase.dispose();
    }

    @Override
    public void pause() {
    }

    public void search(String search){
        searchUseCase.execute(search, new DisposableObserver<List<FixedHeight>>() {
            @Override
            public void onNext(@NonNull List<FixedHeight> fixedHeights) {
                if(fixedHeights.size() == 0){
                    state.set(STATE.EMPTY);
                }else {
                    adapter.setItems(fixedHeights);
                    state.set(STATE.DATA);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
