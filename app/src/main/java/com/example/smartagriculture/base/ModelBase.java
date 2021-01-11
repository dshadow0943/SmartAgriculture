package com.example.smartagriculture.base;

import android.util.Log;

import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.api.source.local.LocalDataSource;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.IModel;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ModelBase implements IModel {

    public static final String RESULT_FAILED = "连接错误";

    private static int status = 0;
    private static final int VACANCY = 0;       //空闲
    private static final int BUSTLE = 1;        //忙碌
    private static final int UPDATED = 2;       //更新完成
    private static final int FAILED = 3;        //更新失败

    /**
     * 更新token
     * @param back
     */
    public void update(CallBack<String, Integer> back){

        Log.e("TAG", "1: " + status);
        //检测当前是否有线程在更新token
//        while (status == BUSTLE) {}
        Log.e("TAG", "2: " + status);
        if (status == UPDATED){
            back.onFail(0);
        }
        Log.e("TAG", "3: " + status);
        String phone = LocalDataSource.getInstance().getLogin();
        String pwd = LocalDataSource.getInstance().getPassword();
        HttpDataSource.destroyInstance();
        //检测本地是否有用户账号信息
        if (phone == null || phone.equals("") || pwd == null || pwd.equals("")){
            back.onFail(1);
            return;
        }

        //更新状态
        status = BUSTLE;
//        updateStatus(BUSTLE);
        Log.e("TAG", "4: " + status);
        HttpDataSource.getInstance().getToken(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e("TAG", "onSubscribe: " );
                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<String> request) {
                        Log.e("TAG-Login", "onNext: " + request.getData());
                        if (request.getCode() == 200){
                            SpareData.putStringData(SpareData.TOKEN, request.getData());
                            LocalDataSource.getInstance().saveToken(request.getData());
                            HttpDataSource.destroyInstance();
//                            updateStatus(UPDATED);
                            back.onSuccess(request.getData());
                        } else {
                            back.onFail(1);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "onError: ");
                        back.onFail(2);
                    }

                    @Override
                    public void onComplete() {
                        Log.e("TAG", "onComplete: ");
                    }
                });
    }

    private void updateStatus(int s){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "run 1: " + status);
                status = s;
                Log.e("TAG", "run 2: " + status);
                try {
                    Thread.sleep(1000*5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (status == s){
                    status = VACANCY;
                }
                Log.e("TAG", "run 3: " + status);
            }
        }).start();
    }

}
