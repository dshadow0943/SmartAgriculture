package com.example.smartagriculture.api.source.http;


import com.example.smartagriculture.api.source.HttpDataSource;
import com.example.smartagriculture.api.source.http.service.JitClassApiService;
import com.example.smartagriculture.utils.RetrofitUtil;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by goldze on 2019/3/26.
 */
public class HttpDataSourceImpl implements HttpDataSource {
    private JitClassApiService apiService;
    private volatile static HttpDataSourceImpl INSTANCE = null;

    public static HttpDataSourceImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDataSourceImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSourceImpl();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public HttpDataSourceImpl(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://jitclass.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(RetrofitUtil.getOkHttpClient())
                .build();
        apiService = retrofit.create(JitClassApiService.class);
    }

}
