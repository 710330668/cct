package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.common.BaseActivity;

import butterknife.Bind;


public class MainActivity extends BaseActivity {


    @Bind(R.id.tv_hello)
    TextView tvHello;

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
}
