package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.view.IView;

import java.util.List;

public interface DeviceContract {

    interface View extends IView{
        void getDeviceSuccess(List<SensorPruneEntity> devices);

        void controlDeviceSuccess(int m);
    }

    interface Presenter{
        void getDevice(int pondId);

        void controlDevice(int deviceId);
    }

}
