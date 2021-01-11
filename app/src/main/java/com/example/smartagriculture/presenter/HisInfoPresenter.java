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
import com.example.smartagriculture.utils.DataTypeEnum;
import com.example.smartagriculture.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HisInfoPresenter extends PresenterBase<HisInfoContract.View, HisInfoModel> implements HisInfoContract.Presenter {

    public HisInfoPresenter() {
        model = new HisInfoModel();
    }

    @Override
    public void getHisData(int pondId) {
        List<PondHisDataItem> dataItems = getHisDataItem();
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

    private List<PondHisDataItem> getHisDataItem(){
        List<PondHisDataItem> list = new ArrayList<>();

        list.add(new PondHisDataItem("temp", 1, DataTypeEnum.WE_TEMP));
        list.add(new PondHisDataItem("humi", 1, DataTypeEnum.WE_HUMI));
        list.add(new PondHisDataItem("illu", 1, DataTypeEnum.WE_ILLU));
        list.add(new PondHisDataItem("wind_spd", 1, DataTypeEnum.WE_WIND_SPD));
        list.add(new PondHisDataItem("wind_drct", 1, DataTypeEnum.WE_WIND_DRCT));
        list.add(new PondHisDataItem("rain_hr", 1, DataTypeEnum.WE_RAIN_HR));
        list.add(new PondHisDataItem("temp", 2, DataTypeEnum.WA_TEMP));
        list.add(new PondHisDataItem("bat_voit", 2, DataTypeEnum.WA_BAT_VOLT));
        list.add(new PondHisDataItem("ec_do", 2, DataTypeEnum.WA_EC_DO));


        return list;
    }

}
