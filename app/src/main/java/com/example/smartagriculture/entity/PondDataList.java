package com.example.smartagriculture.entity;

public class PondDataList {

    private String title;
    private Float value;
    private String unit;

    public PondDataList(String title, Float value, String unit) {
        this.title = title;
        this.value = value;
        this.unit = unit;
    }

    public PondDataList(String title, Float value) {
        this.title = title;
        this.value = value;
        this.unit = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
