package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity {


    @BindView(R.id.cv_look_round)
    CardView cvLookRound;
    @BindView(R.id.cv_time_limit)
    CardView cvTimeLimit;
    @BindView(R.id.tv_want_to_buy)
    TextView mWantBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setListener() {
        cvLookRound.setOnClickListener(this);
        cvTimeLimit.setOnClickListener(this);
    }

    @Override
    public void initParams(Bundle params) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void doBusiness(Context mContext) {
        setToolTitle(getString(R.string.app_name_official), View.GONE);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.cv_look_round:
                startActivity(LookRoundActivity.class);
                break;
            case R.id.cv_time_limit:
                startActivity(TimeLimitActivity.class);
                break;
            case R.id.tv_want_to_buy:
                //我想要
                break;
            default:
        }
    }
}
