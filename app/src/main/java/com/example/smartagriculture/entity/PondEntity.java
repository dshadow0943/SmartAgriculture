package com.example.smartagriculture.entity;

import java.util.Date;
import java.util.List;

public class PondEntity {

    private int id;             //塘口id
    private String name;        //塘口名
    private float length;       //塘口长度
    private float width;        //宽度
    private float longitude;    //经度
    private float latitude;     //纬度
    private String pType;       //产品类型
    private String pName;       //产品名称
    private int cId;            //创建者id
    private String cName;       //创建者昵称
    private Date cTime;         //创建时间
    private List<PondPruneEntity> sensors;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getpType() {
        return pType;
    }

    public void setpType(String pType) {
        this.pType = pType;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public List<PondPruneEntity> getSensors() {
        return sensors;
    }

    public void setSensors(List<PondPruneEntity> sensors) {
        this.sensors = sensors;
    }
}
