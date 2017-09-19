package com.gmail.kovalenko.domain.interctions.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kate on 16.09.2017.
 */


public abstract class UseCase<InParam, OutParam> {

    private Disposable disposable;
    protected abstract Observable<OutParam> buildUseCase(InParam param);

    public void execute(InParam param, DisposableObserver<OutParam> disposableObserver){
        disposable = buildUseCase(param)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribeWith(disposableObserver);
    }

    public void dispose(){
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}