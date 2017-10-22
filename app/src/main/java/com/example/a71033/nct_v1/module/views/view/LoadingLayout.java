package com.example.a71033.nct_v1.module.views.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.a71033.nct_v1.R;

/**
 * Author ： DasonYu
 * Date ： 2017/10/22
 * Email Address : 15764240573@163.com
 */

public class LoadingLayout extends FrameLayout {
    private static final String TAG = "LoadingLayout";
    private LinearLayout mLoadingLinear;
    private LinearLayout mFailedLinear;
    private ImageView mLoadingImage;
    private doWhenRetryListener doWhenRetryListener;

    public LoadingLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LoadingLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadingLayout(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.loading_layout, this);
        mFailedLinear = (LinearLayout) findViewById(R.id.linear_load_fail);
        mLoadingLinear = (LinearLayout)findViewById(R.id.linear_laoding);
        mLoadingImage = (ImageView) findViewById(R.id.image_loading);
        AnimationDrawable animation = (AnimationDrawable) mLoadingImage.getDrawable();
        animation.start();
        mLoadingLinear.setVisibility(VISIBLE);
        mFailedLinear.setVisibility(GONE);

        mFailedLinear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                doWhenRetryListener.doRetry();
            }
        });

    }

    public void loadSuccess(){
        this.setVisibility(GONE);
    }
    public void loadFail(){
        this.setVisibility(VISIBLE);
        mLoadingLinear.setVisibility(GONE);
        mFailedLinear.setVisibility(VISIBLE);
    }

    public void setRetryListener(doWhenRetryListener  doWhenRetryListener){
        this.doWhenRetryListener = doWhenRetryListener;
    }

    public void showLoading() {
        this.setVisibility(VISIBLE);
        mFailedLinear.setVisibility(GONE);
        mLoadingLinear.setVisibility(VISIBLE);
    }
//    private void loadRetry(){
//
//    }

    public interface doWhenRetryListener{
        void doRetry();
    }

}
