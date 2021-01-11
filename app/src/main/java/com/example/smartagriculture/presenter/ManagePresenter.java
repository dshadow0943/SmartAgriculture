package com.example.smartagriculture.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.ManageContract;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.ManageModel;
import com.example.smartagriculture.utils.SPUtils;
import com.example.smartagriculture.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ManagePresenter extends PresenterBase<ManageContract.View, ManageModel> implements ManageContract.Presenter {

    public ManagePresenter() {
        model = new ManageModel();
    }

    @Override
    public void getPondPrunes() {

        model.getPondList(new CallBack<List<PondPruneEntity>, ResultEntity<List<PondPruneEntity>>>() {
            @Override
            public void onSuccess(List<PondPruneEntity> data) {
                mView.getDataSuccess(data);
            }

            @Override
            public void onFail(ResultEntity<List<PondPruneEntity>> data) {
                if (data == null){
                    Toast.makeText(Utils.getContext(), "连接错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (data.getCode() == 416){
                    Log.e("TAG", "onFail: " + data.getMsg());
                    model.update(callToken);
                } else {
                    Toast.makeText(Utils.getContext(), data.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }
        });

//        List<PondPruneEntity> ponds = new ArrayList<>();
//        ponds.add(new PondPruneEntity(1, "a"));
//        ponds.add(new PondPruneEntity(2, "b"));
//        ponds.add(new PondPruneEntity(3, "c"));
//        ponds.add(new PondPruneEntity(4, "d"));
//        ponds.add(new PondPruneEntity(5, "e"));
//
//        mView.getDataSuccess(ponds);
    }
}
