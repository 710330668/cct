package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseActivity;

import butterknife.BindView;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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


    }

    @Override
    public void widgetClick(View v) {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.cv_look_round:
//              淘一淘  startActivity();
                break;
            case R.id.cv_time_limit:
//              限时淘  startActivity();
                break;
        }
    }
}
