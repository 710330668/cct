package com.example.a71033.nct_v1.utils;

import android.content.Context;
import android.os.Environment;

import com.example.a71033.nct_v1.common.Const;
import com.example.a71033.nct_v1.module.contract.retrofit.ApiUrl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Joyson on 2016/10/17.
 */
public class RetrofitUtils {

    private static Context mContext;
    public static Retrofit retrofit = null;

    public static String timeStamp = "0000";

    public static Retrofit getInstance(Context context) {
        mContext = context;
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.addInterceptor(addHeaderAndLogInterceptor());

            //对默认所有证书进行放行，不校验证书
            onHttps(builder);
            //设置缓存 50m  getExternalCacheDir()：sdcard/Android/data/<pack name>/cache
            File cacheFile = new File(getCacheDir(mContext), "RetrofitCache");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
            builder.cache(cache).addInterceptor(addCacheInterceptor());

            //设置超时 30s
            builder.connectTimeout(8, TimeUnit.SECONDS);
            builder.readTimeout(8, TimeUnit.SECONDS);
            builder.writeTimeout(8, TimeUnit.SECONDS);
            //错误重连
            builder.retryOnConnectionFailure(true);

            OkHttpClient client = builder.build();
            retrofit = new Retrofit.Builder()
                    //如果apiService请求头后面url为完整url，此处baseUrl失效。因为baseurl端口不同，不能拼接，故此处无用，具体请参照ApiService
                    .baseUrl(ApiUrl.COMMON_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return retrofit;
    }

    /**
     * 设置缓存
     */
    private static Interceptor addCacheInterceptor() {
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!HttpHeaderUtils.isNetworkAvailable(mContext)) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();

                }
                Response response = chain.proceed(request);
                if (HttpHeaderUtils.isNetworkAvailable(mContext)) {
                    int maxAge = 60 * 60;
                    // 有网络时 设置缓存超时时间60分钟
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Retrofit")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    // 无网络时，设置超时为4天
                    int maxStale = 60 * 60 * 24 * 4;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("nyn")
                            .build();
                }
                return response;
            }
        };
        return cacheInterceptor;
    }


    /**
     * 添加header和log拦截信息
     *
     * @return
     */
    private static Interceptor addHeaderAndLogInterceptor() {
        Interceptor logInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder requestBuilder = request.newBuilder();
                Request signedRequest = requestBuilder
                        .header("Content-Type", "application/json;charset=UTF-8")
                        .header("Content-Encoding", "utf-8")
                        .header("appVersion", Const.appVersion)
                        .header("clientId", HttpHeaderUtils.getClientId(mContext))
                        .header("Connection", "close")
                        .header("timestamp",timeStamp)
                        .header("language", "zh-cn")
                        .header("timezone", "8")
                        .build();
                long t1 = System.nanoTime();
                Response response = chain.proceed(signedRequest);
                long t2 = System.nanoTime();
                MediaType contentType = null;
                String bodyString = null;
                if (response.body() != null) {
                    contentType = response.body().contentType();
                    bodyString = response.body().string();
                }
                // 请求响应时间
                double time = (t2 - t1) / 1e6d;
                switch (request.method()) {
                    case "GET":
                        break;
                    case "POST":
                        break;
                    case "PUT":
                        break;
                    case "DELETE":
                        break;
                    default:
                        break;
                }
                if (response.body() != null) {
                    ResponseBody body = ResponseBody.create(contentType, bodyString);
                    return response.newBuilder().body(body).build();
                } else {
                    return response;
                }
            }
        };
        return logInterceptor;
    }

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeStamp = String.valueOf(System.currentTimeMillis());
        return timeStamp;
    }


    public static SSLSocketFactory getSSLSocketFactory() throws Exception {
        //创建一个不验证证书链的证书信任管理器。
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain,
                    String authType) throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[0];
            }
        }};

        // Install the all-trusting trust manager
        final SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, trustAllCerts,
                new java.security.SecureRandom());
        // Create an ssl socket factory with our all-trusting manager
        return sslContext
                .getSocketFactory();
    }


    //使用自定义SSLSocketFactory
    private static void onHttps(OkHttpClient.Builder builder) {
        try {
            builder.sslSocketFactory(getSSLSocketFactory()).hostnameVerifier(
                    org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static File getCacheDir(Context context) {
        File file;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            file = context.getExternalCacheDir();
        } else {
            file = context.getCacheDir();
        }
        return file;
    }

}
