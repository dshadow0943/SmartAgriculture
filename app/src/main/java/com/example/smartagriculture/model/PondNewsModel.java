package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PondNewsModel extends ModelBase {

    public void getPondNews(int pondId, CallBack<ResultEntity<PondEntity>, String> back){
        HttpDataSource.getInstance().getPondNews(pondId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<PondEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<PondEntity> result) {
                        if (result.getCode() == 200 || result.getCode() == 416){
                            back.onSuccess(result);
                        } else {
                            back.onFail(result.getMsg());
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        back.onFail("网络连接错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
