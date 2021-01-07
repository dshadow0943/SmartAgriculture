package com.example.smartagriculture.entity;

public class PondPruneEntity {

    private int id;             //塘口id
    private String name;        //塘口名

    public PondPruneEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
