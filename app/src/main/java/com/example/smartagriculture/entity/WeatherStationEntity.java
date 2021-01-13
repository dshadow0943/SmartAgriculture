package com.example.smartagriculture.entity;


import java.util.Date;

public class WeatherStationEntity {

    private int sId;
    private String sName;       //所属传感器名称
    private Date cTime;         //数据上报时间
    private float temp;         //温度
    private float humi;         //湿度
    private float illu;         //光照
    private float windSpd;      //风向
    private float windDrct;     //风速
    private float rainHr;       //24小时降雨量

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
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

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumi() {
        return humi;
    }

    public void setHumi(float humi) {
        this.humi = humi;
    }

    public float getIllu() {
        return illu;
    }

    public void setIllu(float illu) {
        this.illu = illu;
    }

    public float getWindSpd() {
        return windSpd;
    }

    public void setWindSpd(float windSpd) {
        this.windSpd = windSpd;
    }

    public float getWindDrct() {
        return windDrct;
    }

    public void setWindDrct(float windDrct) {
        this.windDrct = windDrct;
    }

    public float getRainHr() {
        return rainHr;
    }

    public void setRainHr(float rainHr) {
        this.rainHr = rainHr;
    }
}
