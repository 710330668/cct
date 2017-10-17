package com.example.a71033.nct_v1.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseViewHolder;
import com.example.a71033.nct_v1.module.model.ItemData;

/**
 * Author ： DasonYu
 * Date ： 2017/10/17
 * Email Address : 15764240573@163.com
 */

public class CategoryViewHolder extends BaseViewHolder<ItemData> {
    private TextView mCategoryName;

    /**
     * TODO
     * single view may be direct construction, eg: TextView view = new TextView(context);
     *
     * @param parent current no use, may be future use
     * @param view
     */
    public CategoryViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        mCategoryName = (TextView) itemView.findViewById(R.id.tv_category_name);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        mCategoryName.setText(data.itemDesc);
    }
}
