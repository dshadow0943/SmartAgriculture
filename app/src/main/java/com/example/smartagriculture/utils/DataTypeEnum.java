package com.example.smartagriculture.utils;

public enum DataTypeEnum {

    WE_HUMI("湿度变化表", "湿度", "℃"),
    WE_ILLU("光照变化表", "光照", ""),
    WE_TEMP("气温变化表", "气温", "℃"),
    WE_WIND_SPD("风向变化表", "风向", ""),
    WE_WIND_DRCT("风速变化表", "风速", ""),
    WE_RAIN_HR("降雨量变化表", "24小时降雨量", ""),
    WA_PH("PH变化表", "PH", ""),
    WA_TEMP("水温变化表", "水温", "℃"),
    WA_BAT_VOLT("电池电压变化表", "电压", "V"),
    WA_EC_DO("DO变化表", "DO", ""),
    WA_EC_ORP("ORP变化表", "orp", ""),
    WA_EC_US("电导率变化表", "电导率", ""),
    WA_TDS("溶解固体物变化表", "固体物", ""),
    WA_SALT("盐度变化表", "盐度", "%"),
    DEFAULT("数据变化表", "", "");

    private String title;

    private String type;

    private String unit;

    DataTypeEnum(String title, String type, String unit) {
        this.title = title;
        this.type = type;
        this.unit = unit;
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
}
