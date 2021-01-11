package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HisInfoModel extends ModelBase {

    public void getHisData(String type, int pondId, int table, CallBack<ResultEntity<List<HisDataEntity>>, String> back){
        HttpDataSource.getInstance().getHisData(type, pondId, table)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ResultEntity<List<HisDataEntity>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<List<HisDataEntity>> result) {
                        if (result.getCode() == 200 || result.getCode() == 416){
                            back.onSuccess(result);
                        } else {
                            back.onFail(result.getMsg());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                        back.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
