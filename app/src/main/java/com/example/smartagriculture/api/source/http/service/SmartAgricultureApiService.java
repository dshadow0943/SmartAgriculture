package com.example.smartagriculture.api.source.http.service;


import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorDataEntity;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.entity.UserEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by goldze on 2017/6/15.
 */

public interface SmartAgricultureApiService {

    @GET("user/login")
    Observable<ResultEntity<String>> getToken(@Query("phone") String phone, @Query("pwd") String pwd);

    @GET("pond/seeks")
    Observable<ResultEntity<List<PondPruneEntity>>> getPondList();

    @GET("sensor/data/new")
    Observable<ResultEntity<SensorDataEntity>> getPondData(@Query("pond_id") int pondId);

    @GET("sensor/historical/{type}")
    Observable<ResultEntity<List<HisDataEntity>>> getHisData(@Path("type") String type, @Query("pond_id") int pondId, @Query("table") int table);

    @GET("pond/info")
    Observable<ResultEntity<PondEntity>> getPondNews(@Query("id") int pondId);

    @GET("user/news")
    Observable<ResultEntity<UserEntity>> getUserNews();

    @GET("mqtt/device")
    Observable<ResultEntity<Integer>> controlDevice();

    @GET("mqtt/seeks")
    Observable<ResultEntity<List<SensorPruneEntity>>> getDeviceList(@Query("pond_id") int pondId);

    @POST("user/register")
    Observable<ResultEntity<Integer>> register(@Query("name") String name, @Query("phone") String phone, @Query("pwd") String pwd);

}
