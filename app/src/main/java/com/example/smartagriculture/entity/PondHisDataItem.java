package com.example.smartagriculture.entity;

import com.example.smartagriculture.utils.DataTypeEnum;

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
}
