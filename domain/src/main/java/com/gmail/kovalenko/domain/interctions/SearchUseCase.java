package com.gmail.kovalenko.domain.interctions;


import com.gmail.kovalenko.data.entity.Root;
import com.gmail.kovalenko.data.net.RestService;
import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.domain.interctions.base.UseCase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class SearchUseCase extends UseCase<String, List<FixedHeight>>{
    @Override
    protected Observable<List<FixedHeight>> buildUseCase(String search) {
        return RestService.getInstance().search(search)
                .map(new Function<Root, List<FixedHeight>>() {
                    @Override
                    public List<FixedHeight> apply(@NonNull Root root) throws Exception {

                        List<FixedHeight> listdomain = new ArrayList<>();

                        for (int i = 0; i < root.getData().size(); i++) {

                            FixedHeight FixedHeightDomai = new FixedHeight();
                            FixedHeightDomai.setUrl(root.getData().get(i).getImage().getFixedHeight().getUrl());
                            listdomain.add(FixedHeightDomai);
                        }
                        return listdomain;
                    }
                });
    }
    }
