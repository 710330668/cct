package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.adapter.SettingDelegate;
import com.example.a71033.nct_v1.common.BaseActivity;
import com.example.a71033.nct_v1.common.BaseAdapter;
import com.example.a71033.nct_v1.module.contract.onItemClickListener;
import com.example.a71033.nct_v1.module.model.ItemData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LookRoundActivity extends BaseActivity {
    @BindView(R.id.recycler_look_round)
    RecyclerView mRclCategory;

    private List<ItemData> mDatas;

    @Override
    protected void setListener() {

    }

    @Override
    public void initParms(Bundle parms) {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mDatas.add(new ItemData(0, SettingDelegate.CATEGORY_INFO, "衣服" + i));
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_look_round;
    }

    @Override
    public void doBusiness(Context mContext) {
        setToolTitle(getString(R.string.look_round_buy));
        mRclCategory.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        mRclCategory.setAdapter(new BaseAdapter<>(mDatas, new SettingDelegate(), new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {

            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        }));
    }

    @Override
    public void widgetClick(View v) {

    }
}
