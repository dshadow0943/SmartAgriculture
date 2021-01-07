package com.example.smartagriculture.entity;

import java.lang.ref.SoftReference;
import java.util.Date;

public class SensorEntity {

    private int id;
    private String name;
    private String theme;
    private String host;
    private int port;
    private int tId;
    private Date cTime;
    private boolean tStatus;
    private int status;

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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public boolean istStatus() {
        return tStatus;
    }

    public void settStatus(boolean tStatus) {
        this.tStatus = tStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
