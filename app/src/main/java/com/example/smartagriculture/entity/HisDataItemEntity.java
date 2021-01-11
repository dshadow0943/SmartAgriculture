package com.example.smartagriculture.entity;

import com.example.smartagriculture.utils.DataTypeEnum;

import java.util.List;

public class HisDataItemEntity {

    private List<HisDataEntity> hisData;

    private String title;

    private String type;

    private String unit;

    public HisDataItemEntity() {
    }

    public HisDataItemEntity(List<HisDataEntity> hisData, DataTypeEnum data) {
        this.hisData = hisData;
        setData(data);
    }

    public void setData(DataTypeEnum data){
        this.title = data.getTitle();
        this.type = data.getType();
        this.unit = data.getUnit();
    }

    public List<HisDataEntity> getHisData() {
        return hisData;
    }

    public void setHisData(List<HisDataEntity> hisData) {
        this.hisData = hisData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "HisDataItemEntity{" +
                "hisData=" + hisData.toString() +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }
}
