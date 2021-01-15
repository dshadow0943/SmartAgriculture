package com.example.smartagriculture.api.source.http;


import com.example.smartagriculture.api.source.http.service.SmartAgricultureApiService;
import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorDataEntity;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.entity.UserEntity;
import com.example.smartagriculture.utils.RetrofitUtil;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by goldze on 2019/3/26.
 */
public class HttpDataSource {

//    public static final String API = "http://192.168.1.116:8080/agriculture/";

    public static final String API = "http://192.168.2.204:8080/agriculture/";


    private SmartAgricultureApiService apiService;
    private SmartAgricultureApiService apiLogin;
    private volatile static HttpDataSource INSTANCE = null;

    public static HttpDataSource getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpDataSource();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public HttpDataSource(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(RetrofitUtil.getOkHttpClient())
                .build();
        apiService = retrofit.create(SmartAgricultureApiService.class);

        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(API)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiLogin = retrofit1.create(SmartAgricultureApiService.class);
    }

    public Observable<ResultEntity<String>> getToken(String phone, String pwd) {
        return apiLogin.getToken(phone, pwd);
    }

    public Observable<ResultEntity<List<PondPruneEntity>>> getPondList(){
        return apiService.getPondList();
    }

    public Observable<ResultEntity<SensorDataEntity>> getPondData(int pondId){
        return apiService.getPondData(pondId);
    }

    public Observable<ResultEntity<List<HisDataEntity>>> getHisData(String type, int pondId, int table){
        return apiService.getHisData(type, pondId, table);
    }

    public Observable<ResultEntity<PondEntity>> getPondNews(int pondId){
        return apiService.getPondNews(pondId);
    }

    public Observable<ResultEntity<UserEntity>> getUserNews(){
        return apiService.getUserNews();
    }

    public Observable<ResultEntity<Integer>> controlDevice(){
        return apiService.controlDevice();
    }

    public Observable<ResultEntity<List<SensorPruneEntity>>> getDeviceList(int pondId){
        return apiService.getDeviceList(pondId);
    }

    public Observable<ResultEntity<Integer>> register(String name, String phone, String pwd){
        return apiService.register(name, phone, pwd);
    }
}
