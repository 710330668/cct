package com.example.a71033.nct_v1.adapter;

import android.view.ViewGroup;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.adapter.viewholder.CategoryViewHolder;
import com.example.a71033.nct_v1.adapter.viewholder.SelfInfoViewHolder;
import com.example.a71033.nct_v1.common.BaseDelegate;
import com.example.a71033.nct_v1.common.BaseViewHolder;
import com.example.a71033.nct_v1.module.model.ItemData;

/**
 * Created by 71033 on 2017/10/17.
 */

public class SettingDelegate extends BaseDelegate<ItemData> {

    public static final int SELF_INFO = 0;
    public static final int CATEGORY_INFO = 1;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case SELF_INFO:
                return new SelfInfoViewHolder(parent, getItemView(parent, viewType));
            case CATEGORY_INFO:
                return new CategoryViewHolder(parent, getItemView(parent, viewType));
            default:

        }
        return null;
    }

    @Override
    public int getItemViewType(ItemData data) {
        return data.holderType;
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case SELF_INFO:
                return R.layout.view_holder_setting_self_info;
            case CATEGORY_INFO:
                return R.layout.view_holder_commodity_category;
            default:
        }
        return 0;
    }
}