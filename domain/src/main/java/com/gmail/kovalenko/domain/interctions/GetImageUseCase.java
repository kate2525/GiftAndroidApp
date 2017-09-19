package com.gmail.kovalenko.domain.interctions;

import android.util.Log;

import com.gmail.kovalenko.data.entity.Data;
import com.gmail.kovalenko.data.entity.Root;
import com.gmail.kovalenko.data.net.RestService;
import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.domain.interctions.base.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by kate on 16.09.2017.
 */

public class GetImageUseCase extends UseCase<Void, List<FixedHeight>>{
    @Override
    protected Observable<List<FixedHeight>> buildUseCase(Void aVoid) {

//        FixedHeight image = new FixedHeight();
//        image.setUrl("http://cs3.pikabu.ru/post_img/2014/04/03/10/1396542129_252938718.jpg");
//
//        FixedHeight image2 = new FixedHeight();
//        image2.setUrl("http://cs3.pikabu.ru/post_img/2014/04/03/10/1396542129_252938718.jpg");
//
//        FixedHeight image3 = new FixedHeight();
//        image3.setUrl("http://cs3.pikabu.ru/post_img/2014/04/03/10/1396542129_252938718.jpg");
//
//        FixedHeight image4 = new FixedHeight();
//        image4.setUrl("http://cdn.fishki.net/upload/post/201409/06/1301804/i2dpv50ftpg.jpg");
//
//        List<FixedHeight> listImage = new ArrayList<>();
//        listImage.add(image);
//        listImage.add(image2);
//        listImage.add(image3);
//        listImage.add(image4);
//        return Observable.just(listImage);
        return RestService.getInstance().getImages()
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
