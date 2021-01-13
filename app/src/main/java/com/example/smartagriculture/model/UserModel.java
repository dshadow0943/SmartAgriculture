package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.UserEntity;
import com.example.smartagriculture.interfaces.CallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserModel extends ModelBase {

    public void getUserNews(CallBack<ResultEntity<UserEntity>, String> back){
        HttpDataSource.getInstance().getUserNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<UserEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<UserEntity> result) {
                        if (result.getCode() == 200 || result.getCode() == 416){
                            back.onSuccess(result);
                        } else {
                            back.onFail(result.getMsg());
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
