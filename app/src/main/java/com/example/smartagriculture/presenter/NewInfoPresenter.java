package com.example.smartagriculture.presenter;

import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.NewInfoContract;
import com.example.smartagriculture.entity.PondDataList;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorDataEntity;
import com.example.smartagriculture.entity.WaterQualityEntity;
import com.example.smartagriculture.entity.WeatherStationEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.NewInfoModel;
import com.example.smartagriculture.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class NewInfoPresenter extends PresenterBase<NewInfoContract.View, NewInfoModel> implements NewInfoContract.Presenter {

    private static final float LIMIT = -99999;

    public NewInfoPresenter() {
        model = new NewInfoModel();
    }

    @Override
    public void getPondData(int pondId) {

//        WeatherStationEntity weatherStationEntity = new WeatherStationEntity();
//        WaterQualityEntity waterQualityEntity = new WaterQualityEntity();
//        SensorDataEntity sensorDataEntity = new SensorDataEntity(waterQualityEntity, weatherStationEntity);
//        mView.getDataSuccess(dataToList(sensorDataEntity));

        model.getPondData(pondId, new CallBack<ResultEntity<SensorDataEntity>, String>() {
            @Override
            public void onSuccess(ResultEntity<SensorDataEntity> data) {
                if (data.getCode() == 200){
                    mView.getDataSuccess(dataToList(data.getData()));
                } else {
                    model.update(callToken);
                }
            }

            @Override
            public void onFail(String data) {
                Toast.makeText(Utils.getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<PondDataList> dataToList(SensorDataEntity sensorData){
        List<PondDataList> pondList = new ArrayList<>();

        if (sensorData.getWaterQuality() != null){
            WaterQualityEntity w = sensorData.getWaterQuality();
            if (w.getBatVolt() != LIMIT){
                pondList.add(new PondDataList("电池电压", w.getBatVolt()));
            }
            if (w.getEcDo() != LIMIT){
                pondList.add(new PondDataList("PH", w.getEcDo()));
            }
            if (w.getTemp() != LIMIT){
                pondList.add(new PondDataList("水温", w.getTemp(), "℃"));
            }
            if (w.getEcOrp() != LIMIT){
                pondList.add(new PondDataList("ORP", w.getEcOrp()));
            }
            if (w.getEcUs() != LIMIT){
                pondList.add(new PondDataList("电导率", w.getEcUs(), "%"));
            }
            if (w.getTds() != LIMIT){
                pondList.add(new PondDataList("溶解固体物", w.getTds()));
            }
            if (w.getSalt() != LIMIT){
                pondList.add(new PondDataList("盐度", w.getSalt(), "%"));
            }
            if (w.gettDov() != LIMIT){
                pondList.add(new PondDataList("溶解氧电压", w.gettDov()));
            }
            if (w.gettDos() != LIMIT){
                pondList.add(new PondDataList("溶解氧饱和度", w.gettDos(), "%"));
            }
            if (w.getTdoZvdq() != LIMIT){
                pondList.add(new PondDataList("溶解氧电压数字量(珠海英沃)", w.getTdoZvdq()));
            }
            if (w.getPhZvdq() != LIMIT){
                pondList.add(new PondDataList("PH电压数字量(珠海英沃)", w.getPhZvdq()));
            }
            if (w.getPhPvdq() != LIMIT){
                pondList.add(new PondDataList("PH电压数字量(盛世融合)", w.getPhPvdq()));
            }
        }

        if (sensorData.getWeatherStation() != null){
            WeatherStationEntity w = sensorData.getWeatherStation();

            if (w.getTemp() != LIMIT){
                pondList.add(new PondDataList("气温", w.getTemp(), "℃"));
            }
            if (w.getHumi() != LIMIT){
                pondList.add(new PondDataList("湿度", w.getHumi(), "%"));
            }
            if (w.getIllu() != LIMIT){
                pondList.add(new PondDataList("光照", w.getIllu()));
            }
            if (w.getWindSpd() != LIMIT){
                pondList.add(new PondDataList("风向", w.getWindSpd(), "°"));
            }
            if (w.getWindDrct() != LIMIT){
                pondList.add(new PondDataList("风速", w.getWindDrct()));
            }
            if (w.getRainHr() != LIMIT){
                pondList.add(new PondDataList("24小时降雨量", w.getRainHr()));
            }
        }
        return pondList;
    }

}
