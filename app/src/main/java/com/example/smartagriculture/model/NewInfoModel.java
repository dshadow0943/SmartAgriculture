package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorDataEntity;
import com.example.smartagriculture.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewInfoModel extends ModelBase {

    public void getPondData(int pondId, CallBack< ResultEntity<SensorDataEntity>, String> back){
        HttpDataSource.getInstance().getPondData(pondId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<SensorDataEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<SensorDataEntity> result) {

                        if (result.getCode() == 200){
                            back.onSuccess(result);
                        } else if (result.getCode() == 416){
                            back.onSuccess(result);
                        } else {
                            back.onFail(result.getMsg());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        back.onFail(RESULT_FAILED);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
