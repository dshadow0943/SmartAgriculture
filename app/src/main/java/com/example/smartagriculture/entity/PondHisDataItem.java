package com.example.smartagriculture.entity;

import com.example.smartagriculture.utils.DataTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class PondHisDataItem {

    private String type;

    private int table;

    private DataTypeEnum dataEnum;

    public PondHisDataItem(String type, int table, DataTypeEnum dataEnum) {
        this.type = type;
        this.table = table;
        this.dataEnum = dataEnum;
    }

    public PondHisDataItem(String type, DataTypeEnum dataEnum) {
        this.type = type;
        this.dataEnum = dataEnum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataTypeEnum getDataEnum() {
        return dataEnum;
    }

    public void setDataEnum(DataTypeEnum dataEnum) {
        this.dataEnum = dataEnum;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public static List<PondHisDataItem> getHisDataItem(){
        List<PondHisDataItem> list = new ArrayList<>();

        list.add(new PondHisDataItem("temp", 1, DataTypeEnum.WE_TEMP));
        list.add(new PondHisDataItem("humi", 1, DataTypeEnum.WE_HUMI));
        list.add(new PondHisDataItem("illu", 1, DataTypeEnum.WE_ILLU));
        list.add(new PondHisDataItem("wind_spd", 1, DataTypeEnum.WE_WIND_SPD));
        list.add(new PondHisDataItem("wind_drct", 1, DataTypeEnum.WE_WIND_DRCT));
        list.add(new PondHisDataItem("rain_hr", 1, DataTypeEnum.WE_RAIN_HR));
        list.add(new PondHisDataItem("temp", 2, DataTypeEnum.WA_TEMP));
        list.add(new PondHisDataItem("bat_volt", 2, DataTypeEnum.WA_BAT_VOLT));
        list.add(new PondHisDataItem("ec_do", 2, DataTypeEnum.WA_EC_DO));
        list.add(new PondHisDataItem("ec_ph", 2, DataTypeEnum.WA_PH));
        list.add(new PondHisDataItem("ec_orp", 2, DataTypeEnum.WA_EC_ORP));
        list.add(new PondHisDataItem("ec_us", 2, DataTypeEnum.WA_EC_US));
        list.add(new PondHisDataItem("tds", 2, DataTypeEnum.WA_TDS));
        list.add(new PondHisDataItem("salt", 2, DataTypeEnum.WA_SALT));
        list.add(new PondHisDataItem("tdov", 2, DataTypeEnum.DEFAULT));
        list.add(new PondHisDataItem("tdos", 2, DataTypeEnum.DEFAULT));
        list.add(new PondHisDataItem("tdo_zvdq", 2, DataTypeEnum.DEFAULT));
        list.add(new PondHisDataItem("ph_zvdq", 2, DataTypeEnum.DEFAULT));
        list.add(new PondHisDataItem("ph_pvdq", 2, DataTypeEnum.DEFAULT));
        list.add(new PondHisDataItem("ph_zvdq", 2, DataTypeEnum.DEFAULT));

        return list;
    }
}
