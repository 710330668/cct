package com.example.a71033.nct_v1.common;

import android.util.Log;

import com.google.gson.JsonSyntaxException;

import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Joyson on 2016/10/17.
 */
public abstract class BaseCallback<T extends BaseResponse> implements Callback<T> {
    @Override
    public void onResponse(Call call, Response response) {
        int code = response.raw().code();
        Log.e("request", "response:" + response);
        if (code == 200) {
            /**
             * 这里我只实现了成功和失败的回调，还可以根据接口返回的状态信息实现相应的回调
             * */
            T t = (T) response.body();

            if ("00000".equals(t.getRetCode())) {
                onSuccess(t);

            } else {
                onFail(parseErrorCode(code));
            }
            onAfter();
        }
    }

    /**
     * 失败回调
     * @param call
     * @param t
     */
    @Override
    public void onFailure(Call call, Throwable t) {
        onFail(parseException(t));
        onAfter();
    }

    /**
     * retcode="00000"之后，请求成功的回调
     */
    protected abstract void onSuccess(T response);

    /**
     * 请求失败的回调
     */
    protected abstract void onFail(String msg);

    /**
     * 请求完的回调，
     * 可以在里面停止刷新控件， 没有控件可以不实现
     */
    protected void onAfter() {
    }

    private String parseException(Throwable throwable){
        if (throwable!=null){
            if (throwable instanceof JsonSyntaxException) {
                if (Const.isdebug){
                    return "Json数据格式有误";
                }else{
                    return "网络异常，请检查网络";
                }
            } else if (throwable instanceof UnsupportedEncodingException) {
                if (Const.isdebug){
                    return "数据格式有误";
                }else{
                    return "网络异常，请检查网络";
                }
            } else if (throwable instanceof UnknownHostException) {
                if (Const.isdebug){
                    return "无法解析该域名";
                }else{
                    return "网络异常，请检查网络";
                }

            }else if(throwable instanceof SocketTimeoutException){
                if (Const.isdebug){
                    return "请求超时，请重试";
                }else{
                    return "网络异常，请检查网络";
                }

            }
            if (Const.isdebug){
                return "无法连接网路，请检查路由器";
            }else{
                return "网络异常，请检查网络";
            }

        }
        if (Const.isdebug){
            return "throwable null";
        }else{
            return "网络异常，请检查网络";
        }
    }

    private String parseErrorCode(int statusCode){
        if (statusCode >= 400 && statusCode < 500) {
            if (statusCode==403){
                if (Const.isdebug){
                    return "数字签名错误";
                }else{
                    return "服务异常，请稍后重试";
                }
            }else{
                if (Const.isdebug){
                    return "请求错误:"+statusCode;
                }else{
                    return "服务异常，请稍后重试";
                }

            }
        } else if (statusCode >= 500 && statusCode <= 600) {
            if (Const.isdebug){
                return "请求错误:"+statusCode;
            }else{
                return "网络异常，请检查网络";
            }
        }else{

            if (Const.isdebug){
                return "其他错误：statusCode=" + statusCode;
            }else{
                return "服务异常，请稍后重试";
            }
        }

    }
}
