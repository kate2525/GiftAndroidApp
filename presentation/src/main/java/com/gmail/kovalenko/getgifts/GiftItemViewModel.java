package com.gmail.kovalenko.getgifts;

import android.databinding.ObservableField;

import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.getgifts.base.BaseItemViewModel;


/**
 * Created by kate on 18.09.2017.
 */

public class GiftItemViewModel extends BaseItemViewModel<FixedHeight> {

    public ObservableField<String> url = new ObservableField<>("");

    @Override
    public void setItem(FixedHeight item, int position) {
        url.set(item.getUrl());
    }
}
