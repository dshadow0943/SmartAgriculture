package com.example.smartagriculture.presenter;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.DeviceContract;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.DeviceModel;

import java.util.List;

public class DevicePresenter extends PresenterBase<DeviceContract.View, DeviceModel> implements DeviceContract.Presenter {

    public DevicePresenter() {
        model = new DeviceModel();
    }

    @Override
    public void getDevice(int pondId) {
        model.getDevice(pondId, new CallBack<ResultEntity<List<SensorPruneEntity>>, String>() {
            @Override
            public void onSuccess(ResultEntity<List<SensorPruneEntity>> data) {
                if (data.getCode() == 200){
                    mView.getDeviceSuccess(data.getData());
                }
            }

            @Override
            public void onFail(String data) {

            }
        });
    }

    @Override
    public void controlDevice(int deviceId) {
        model.controlDevice(new CallBack<ResultEntity<Integer>, String>() {
            @Override
            public void onSuccess(ResultEntity<Integer> data) {
                if (data.getCode() == 200){
                    mView.controlDeviceSuccess(data.getData());
                }
            }

            @Override
            public void onFail(String data) {

            }
        });
    }
}
