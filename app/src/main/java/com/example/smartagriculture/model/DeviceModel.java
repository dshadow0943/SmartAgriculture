package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.interfaces.CallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DeviceModel extends ModelBase {


    public void getDevice(int pondId, CallBack<ResultEntity<List<SensorPruneEntity>>, String> back) {
        HttpDataSource.getInstance().getDeviceList(pondId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<List<SensorPruneEntity>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<List<SensorPruneEntity>> result) {
                        if (result.getCode() == 200 || result.getCode() == 416){
                            back.onSuccess(result);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        back.onFail(RESULT_FAILED);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void controlDevice(CallBack<ResultEntity<String>, String> back) {
        HttpDataSource.getInstance().controlDevice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<String> result) {
                        if (result.getCode() == 200 || result.getCode() == 416){
                            back.onSuccess(result);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        back.onFail(RESULT_FAILED);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
