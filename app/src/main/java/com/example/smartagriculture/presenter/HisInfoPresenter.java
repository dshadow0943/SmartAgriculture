package com.example.smartagriculture.presenter;

import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.HisInfoContract;
import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.HisDataItemEntity;
import com.example.smartagriculture.entity.PondHisDataItem;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.HisInfoModel;
import com.example.smartagriculture.utils.Utils;

import java.util.List;

public class HisInfoPresenter extends PresenterBase<HisInfoContract.View, HisInfoModel> implements HisInfoContract.Presenter {

    public HisInfoPresenter() {
        model = new HisInfoModel();
    }

    @Override
    public void getHisData(int pondId) {
        List<PondHisDataItem> dataItems = PondHisDataItem.getHisDataItem();
        for (PondHisDataItem dataItem: dataItems) {
            model.getHisData(dataItem.getType(), pondId, dataItem.getTable(), new CallBack<ResultEntity<List<HisDataEntity>>, String>() {
                @Override
                public void onSuccess(ResultEntity<List<HisDataEntity>> data) {
                    if (data.getCode() == 200){
                        if (data.getData().size() == 0){
                            return;
                        }
                        mView.getDataSuccess(new HisDataItemEntity(data.getData(), dataItem.getDataEnum()));
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

}
