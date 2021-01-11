package com.example.smartagriculture.entity;

import java.util.Date;

public class HisDataEntity {

    private float value;

    private Date cTime;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    @Override
    public String toString() {
        return "HisDataEntity{" +
                "value=" + value +
                ", cTime=" + cTime +
                '}';
    }
}
