package com.example.smartagriculture.entity;

import java.util.List;

public class HistoricalDataEntity {

    List<Float> data;

    public HistoricalDataEntity(List<Float> data) {
        this.data = data;
    }

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HistoricalDataEntity{" +
                "data=" + data +
                '}';
    }
}
