package com.example.a71033.nct_v1.module.contract.retrofit;


import com.example.a71033.nct_v1.module.model.AmoyRequest;
import com.example.a71033.nct_v1.module.model.AmoyResponse;
import com.example.a71033.nct_v1.module.model.ProListRequest;
import com.example.a71033.nct_v1.module.model.ProListResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    /**
     * 淘一淘
     *
     * @param
     * @return
     */
     @POST(ApiUrl.COMMON_API + "CCT/Home/Amoy")
         Call<AmoyResponse> getAmoyList(@Body AmoyRequest amoyRequest);

    /**
     * 淘一淘  -->产品列表
     *
     * @param
     * @return
     */
    @POST(ApiUrl.COMMON_API + "CCT/Home/getProductList")
    Call<ProListResponse> getProductList(@Body ProListRequest proListRequest);
}
