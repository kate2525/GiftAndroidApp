package com.gmail.kovalenko.getgifts;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gmail.kovalenko.domain.entity.FixedHeight;
import com.gmail.kovalenko.getgifts.base.BaseItemViewHolder;
import com.gmail.kovalenko.getgifts.databinding.ItemGiftBinding;


/**
 * Created by kate on 18.09.2017.
 */

public class GiftItemViewHolder extends BaseItemViewHolder<FixedHeight,
        GiftItemViewModel, ItemGiftBinding> {

    public GiftItemViewHolder(ItemGiftBinding binding, GiftItemViewModel viewModel) {
        super(binding, viewModel);
        binding.setViewModel(viewModel);
    }

    public static GiftItemViewHolder create(LayoutInflater inflater, ViewGroup parent,
                                            GiftItemViewModel viewModel) {
        ItemGiftBinding binding = ItemGiftBinding.inflate(inflater, parent, false);
        return new GiftItemViewHolder(binding, viewModel);
    }
}
