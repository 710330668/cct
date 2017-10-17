package com.example.a71033.nct_v1.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseViewHolder;
import com.example.a71033.nct_v1.module.model.ItemData;

/**
 * Created by 71033 on 2017/10/17.
 */
public class SelfInfoViewHolder extends BaseViewHolder<ItemData> {

    private TextView tvCommodityName;

    private TextView tvCommodityPrice;

    /**
     * @param parent
     * @param view
     */
    public SelfInfoViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        tvCommodityName = (TextView) itemView.findViewById(R.id.tv_commodity_name);
        tvCommodityPrice = (TextView) itemView.findViewById(R.id.tv_commodity_price);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        tvCommodityName.setText(data.itemDesc);
    }

    @Override
    public boolean enable() {
        return false;
    }
}