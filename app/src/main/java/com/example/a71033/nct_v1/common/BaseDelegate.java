package com.example.a71033.nct_v1.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 71033 on 2017/10/17.
 */

public abstract class BaseDelegate<T> {

    /**
     * @param parent
     * @param viewType
     * @return
     */
    public abstract BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * @param data
     * @return
     */
    public abstract int getItemViewType(T data);

    /**
     * @param viewType
     * @return
     */
    public abstract int getLayoutId(int viewType);

    /**
     * @param parent
     * @param viewType
     * @return
     */
    public View getItemView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
    }
}