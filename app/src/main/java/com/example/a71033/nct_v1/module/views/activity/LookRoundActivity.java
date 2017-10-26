package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.adapter.SettingDelegate;
import com.example.a71033.nct_v1.common.BaseActivity;
import com.example.a71033.nct_v1.common.BaseAdapter;
import com.example.a71033.nct_v1.common.BaseCallback;
import com.example.a71033.nct_v1.common.Const;
import com.example.a71033.nct_v1.module.contract.onItemClickListener;
import com.example.a71033.nct_v1.module.contract.retrofit.ApiService;
import com.example.a71033.nct_v1.module.model.AmoyRequest;
import com.example.a71033.nct_v1.module.model.AmoyResponse;
import com.example.a71033.nct_v1.module.model.ItemData;
import com.example.a71033.nct_v1.module.model.ProListRequest;
import com.example.a71033.nct_v1.module.model.ProListResponse;
import com.example.a71033.nct_v1.module.views.view.LoadingLayout;
import com.example.a71033.nct_v1.utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LookRoundActivity extends BaseActivity {
    @BindView(R.id.recycler_look_round)
    RecyclerView mRclCategory;

    private List<ItemData> mDatas;
    private BaseAdapter<ItemData> mAdapter;

    @Override
    protected void setListener() {

    }

    @Override
    public void initParams(Bundle params) {
        mDatas = new ArrayList<>();
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_look_round;
    }

    @Override
    public void doBusiness(Context mContext) {
        setToolTitle(getString(R.string.look_round_buy), View.VISIBLE);
        mRclCategory.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        mAdapter = new BaseAdapter<>(mDatas, new SettingDelegate(), new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
                String id = ((AmoyResponse.Amoy)data).getTypeId();
                String content = "";
//                ProListRequest request = new ProListRequest();
//                request.setContent(content);
//                request.setId(id);
//                RetrofitUtils.getInstance(LookRoundActivity.this).create(ApiService.class).
//                        getProductList(request).enqueue(new BaseCallback<ProListResponse>() {
//                    @Override
//                    protected void onSuccess(ProListResponse response) {
//                    }
//
//                    @Override
//                    protected void onFail(String msg) {
//
//                    }
//                });
            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        });
        mRclCategory.setAdapter(mAdapter);
        showLoading();
        loadData();
    }

    private void loadData() {
        AmoyRequest amoyRequest = new AmoyRequest();
        amoyRequest.setAmoyId(Const.lookRoundId);
        RetrofitUtils.getInstance(this).create(ApiService.class).getAmoyList(amoyRequest)
                .enqueue(new BaseCallback<AmoyResponse>() {
                    @Override
                    protected void onSuccess(AmoyResponse response) {
                        loadSuccess();
                        List<AmoyResponse.Amoy> amoyList = response.getAmoyList();
                        for (AmoyResponse.Amoy bean:amoyList) {
                            mDatas.add(new ItemData(0,SettingDelegate.CATEGORY_INFO,bean));
                            mAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    protected void onFail(String msg) {
                        loadFailure();
                    }
                });
    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void doRetry() {
        super.doRetry();
        loadData();
    }
}
