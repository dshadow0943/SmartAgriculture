package com.example.smartagriculture.entity;

public class SensorDataEntity {

    private WaterQualityEntity waterQuality;            //水质终端
    private WeatherStationEntity weatherStation;        //气象站

    public WaterQualityEntity getWaterQuality() {
        return waterQuality;
    }

    public void setWaterQuality(WaterQualityEntity waterQuality) {
        this.waterQuality = waterQuality;
    }

    public WeatherStationEntity getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(WeatherStationEntity weatherStation) {
        this.weatherStation = weatherStation;
    }
}
