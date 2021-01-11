package com.example.smartagriculture.model;

import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.ModelBase;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ManageModel extends ModelBase {

    public void getPondList(CallBack<List<PondPruneEntity>, ResultEntity<List<PondPruneEntity>>> back){
        HttpDataSource.getInstance().getPondList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultEntity<List<PondPruneEntity>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResultEntity<List<PondPruneEntity>> result) {
                        if (result.getCode() == 200){
                            back.onSuccess(result.getData());
                        } else {
                            back.onFail(result);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        back.onFail(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
