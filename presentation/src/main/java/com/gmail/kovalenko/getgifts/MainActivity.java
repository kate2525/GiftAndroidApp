package com.gmail.kovalenko.getgifts;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;

import com.gmail.kovalenko.getgifts.base.BaseActivity;
import com.gmail.kovalenko.getgifts.databinding.ActivityMainBinding;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MainActivity extends BaseActivity {

    private Disposable searchDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MainViewModel viewModel = new MainViewModel();
        this.viewModel = viewModel;
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);

        binding.recyclerView.setAdapter(viewModel.adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.search, menu);
        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();

        searchDisposable = RxSearchView.queryTextChanges(searchView)
                .skip(1)
                .throttleLast(100, TimeUnit.MILLISECONDS)
                .debounce(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<CharSequence>() {
                    @Override
                    public void onNext(@NonNull CharSequence charSequence) {

                        Log.e("AAAAA", "search "+charSequence);

                        if(!TextUtils.isEmpty(charSequence)){
                            ((MainViewModel)viewModel).search(String.valueOf(charSequence));
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {}
                    @Override
                    public void onComplete() {}
                });

        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(searchDisposable !=null && !searchDisposable.isDisposed()){
            searchDisposable.dispose();
        }
    }
}

