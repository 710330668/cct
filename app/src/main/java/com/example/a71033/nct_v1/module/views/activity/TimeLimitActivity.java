package com.example.a71033.nct_v1.module.views.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.a71033.nct_v1.R;
import com.example.a71033.nct_v1.adapter.SettingDelegate;
import com.example.a71033.nct_v1.common.BaseActivity;
import com.example.a71033.nct_v1.common.BaseAdapter;
import com.example.a71033.nct_v1.module.contract.onItemClickListener;
import com.example.a71033.nct_v1.module.model.ItemData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 71033 on 2017/10/16.
 */

public class TimeLimitActivity extends BaseActivity {

    @BindView(R.id.btn_clock_eight)
    Button btnClockEight;
    @BindView(R.id.btn_clock_ten)
    Button btnClockTen;
    @BindView(R.id.btn_clock_twelve)
    Button btnClockTwelve;
    @BindView(R.id.btn_clock_fourteen)
    Button btnClockFourteen;
    @BindView(R.id.btn_clock_sixteen)
    Button btnClockSixteen;
    @BindView(R.id.btn_clock_eighteen)
    Button btnClockEighteen;
    @BindView(R.id.btn_clock_twenty)
    Button btnClockTwenty;
    @BindView(R.id.lly_time_limit)
    LinearLayout llyTimeLimit;
    @BindView(R.id.rlv_merchandise)
    RecyclerView rlvMerchandise;

    private List<ItemData> itemDatas;

    @Override
    protected void setListener() {
        btnClockEight.setOnClickListener(this);
        btnClockTen.setOnClickListener(this);
        btnClockTwelve.setOnClickListener(this);
        btnClockFourteen.setOnClickListener(this);
        btnClockSixteen.setOnClickListener(this);
        btnClockEighteen.setOnClickListener(this);
        btnClockTwenty.setOnClickListener(this);
        llyTimeLimit.setOnClickListener(this);
        btnClockEight.setOnClickListener(this);
    }

    @Override
    public void initParams(Bundle params) {
        itemDatas = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            itemDatas.add(new ItemData(0, SettingDelegate.SELF_INFO, "Oppo R9"));
        }
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_time_limit;
    }

    @Override
    public void doBusiness(Context mContext) {
        setToolTitle(getString(R.string.time_limit_buy), View.VISIBLE);
        rlvMerchandise.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.VERTICAL,false));
        rlvMerchandise.setAdapter(new BaseAdapter<>(itemDatas, new SettingDelegate(), new onItemClickListener() {
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
        switch (v.getId()) {
            case R.id.btn_clock_eight:
                break;
            case R.id.btn_clock_ten:
                break;
            case R.id.btn_clock_twelve:
                break;
            case R.id.btn_clock_fourteen:
                break;
            case R.id.btn_clock_sixteen:
                break;
            case R.id.btn_clock_eighteen:
                break;
            case R.id.btn_clock_twenty:
                break;
            case R.id.lly_time_limit:
                break;
            default:
                break;
        }
    }
}
