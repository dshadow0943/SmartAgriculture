package com.example.smartagriculture.model;

import android.util.Log;

import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.api.source.local.LocalDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginModel extends ModelBase {

    public void getToken(String phone, String pwd, CallBack<String, String> back){
        HttpDataSource.getInstance().getToken(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<String> request) {
                        Log.e("TAG-Login", "onNext: " + request.getData());
                        if (request.getCode() == 200){
                            SpareData.putStringData(SpareData.TOKEN, request.getData());
                            LocalDataSource.getInstance().saveToken(request.getData());
                            back.onSuccess(request.getData());
                        } else {
                            back.onFail(request.getMsg());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        back.onFail("连接出错");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
