package com.example.smartagriculture.entity;

import java.util.Date;

public class WaterQualityEntity {

    private String sName;       //所属传感器名称
    private Date cTime;         //数据上传时间
    private float batVolt;      //电池电压
    private float ecDo;         //DO
    private float ecPh;         //PH
    private float temp;         //温度
    private float ecOrp;        //orp
    private float ecUs;         //电导率
    private float tds;          //溶解固体物
    private float salt;         //盐度
    private float tDov;         //溶解氧电压
    private float tDos;         //溶解氧饱和度
    private float tdoZvdq;      //溶解氧电压数字量(珠海英沃)
    private float phZvdq;       //PH电压数字量(珠海英沃)
    private float phPvdq;       //PH电压数字量(盛世融合)
    private int status;         //继电器状态

    public WaterQualityEntity(String sName, Date cTime) {
        this.sName = sName;
        this.cTime = cTime;
    }

    public WaterQualityEntity() {
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public float getBatVolt() {
        return batVolt;
    }

    public void setBatVolt(float batVolt) {
        this.batVolt = batVolt;
    }

    public float getEcDo() {
        return ecDo;
    }

    public void setEcDo(float ecDo) {
        this.ecDo = ecDo;
    }

    public float getEcPh() {
        return ecPh;
    }

    public void setEcPh(float ecPh) {
        this.ecPh = ecPh;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getEcOrp() {
        return ecOrp;
    }

    public void setEcOrp(float ecOrp) {
        this.ecOrp = ecOrp;
    }

    public float getEcUs() {
        return ecUs;
    }

    public void setEcUs(float ecUs) {
        this.ecUs = ecUs;
    }

    public float getTds() {
        return tds;
    }

    public void setTds(float tds) {
        this.tds = tds;
    }

    public float getSalt() {
        return salt;
    }

    public void setSalt(float salt) {
        this.salt = salt;
    }

    public float gettDov() {
        return tDov;
    }

    public void settDov(float tDov) {
        this.tDov = tDov;
    }

    public float gettDos() {
        return tDos;
    }

    public void settDos(float tDos) {
        this.tDos = tDos;
    }

    public float getTdoZvdq() {
        return tdoZvdq;
    }

    public void setTdoZvdq(float tdoZvdq) {
        this.tdoZvdq = tdoZvdq;
    }

    public float getPhZvdq() {
        return phZvdq;
    }

    public void setPhZvdq(float phZvdq) {
        this.phZvdq = phZvdq;
    }

    public float getPhPvdq() {
        return phPvdq;
    }

    public void setPhPvdq(float phPvdq) {
        this.phPvdq = phPvdq;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
