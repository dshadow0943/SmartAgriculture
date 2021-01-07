package com.example.smartagriculture.entity;

public class SensorDataEntity {

    private WaterQualityEntity waterQuality;
    private WeatherStationEntity weatherStation;

    public SensorDataEntity(WaterQualityEntity waterQuality, WeatherStationEntity weatherStation) {
        this.waterQuality = waterQuality;
        this.weatherStation = weatherStation;
    }

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
