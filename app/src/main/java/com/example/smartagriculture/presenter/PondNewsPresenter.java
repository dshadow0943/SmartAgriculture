package com.example.smartagriculture.presenter;

import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.PondNewsContract;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.PondNewsModel;
import com.example.smartagriculture.utils.Utils;

public class PondNewsPresenter extends PresenterBase<PondNewsContract.View, PondNewsModel> implements PondNewsContract.Presenter {

    public PondNewsPresenter() {
        model = new PondNewsModel();
    }

    @Override
    public void getPondEntity(int pondId) {
        model.getPondNews(pondId, new CallBack<ResultEntity<PondEntity>, String>() {
            @Override
            public void onSuccess(ResultEntity<PondEntity> data) {
                if (data.getCode() == 200){
                    mView.getDataSuccess(data.getData());
                } else if (data.getCode() == 416){
                    model.update(callToken);
                }
            }

            @Override
            public void onFail(String data) {
                Toast.makeText(Utils.getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
