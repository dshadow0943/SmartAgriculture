package com.example.smartagriculture.utils;

import com.example.smartagriculture.entity.HisDataEntity;
import com.example.smartagriculture.entity.MapEntity;
import com.example.smartagriculture.entity.PondEntity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntityToMap {

    public static List<MapEntity<String, String>> pondToMap(PondEntity pond){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        List<MapEntity<String, String>> list = new ArrayList<>();

        if (pond != null){
            list.add(new MapEntity<>("名称", pond.getName()));
            list.add(new MapEntity<>("长", pond.getLength()+""));
            list.add(new MapEntity<>("宽", pond.getWidth()+""));
            list.add(new MapEntity<>("经度", pond.getLongitude()+""));
            list.add(new MapEntity<>("纬度", pond.getLatitude()+""));
            list.add(new MapEntity<>("产品类型", pond.getpType()));
            list.add(new MapEntity<>("产品名称", pond.getpName()));
            list.add(new MapEntity<>("创建者", pond.getcName()));
            list.add(new MapEntity<>("创建时间", sdf.format(pond.getcTime())));
        }
        return list;
    }

    public static List<MapEntity<Float, String>> hisDataToMap(List<HisDataEntity> hisDatas, int startTime){
        List<MapEntity<Float, String>> list = new ArrayList<>();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        for (HisDataEntity hisData: hisDatas){
            if (new Date().getTime() - hisData.getcTime().getTime() > startTime*60*60*1000){
                break;
            }
            list.add(0, new MapEntity<>(hisData.getValue(), simpleDateFormat.format(hisData.getcTime())));
        }
        return list;
    }

}
