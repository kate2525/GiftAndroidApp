package com.gmail.kovalenko.getgifts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.getgifts.base.BaseAdapter;


/**
 * Created by kate on 18.09.2017.
 */

public class GiftsAdapter extends BaseAdapter<FixedHeight, GiftItemViewModel> {

    @Override
    public GiftItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GiftItemViewModel itemViewModel = new GiftItemViewModel();
        return GiftItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }
}