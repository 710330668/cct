package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity {


    @BindView(R.id.cv_look_round)
    CardView cvLookRound;
    @BindView(R.id.cv_time_limit)
    CardView cvTimeLimit;

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
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void doBusiness(Context mContext) {
        setToolTitle(getString(R.string.app_name_official));
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.cv_look_round:
//              淘一淘  startActivity();
                startActivity(LookRoundActivity.class);
                break;
            case R.id.cv_time_limit:
                //限时淘
                startActivity(TimeLimitActivity.class);
                break;
            default:
        }
    }
}
