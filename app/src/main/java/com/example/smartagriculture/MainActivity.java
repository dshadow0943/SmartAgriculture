package com.example.smartagriculture;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.SensorDataEntity;
import com.example.smartagriculture.entity.WaterQualityEntity;
import com.example.smartagriculture.entity.WeatherStationEntity;
import com.example.smartagriculture.view.activity.HomeActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

//        List<Float> data = new ArrayList<>();
//        data.add(1f);
//        data.add(1f);
//        data.add(1f);
//        data.add(1f);
//        WaterQualityEntity waterQuality = new WaterQualityEntity("a", new Date());
//        WeatherStationEntity weatherStation = new WeatherStationEntity("a", new Date());
////        PondEntity pondEntity = new PondEntity(1, "d", 1, 1, 1, 1, "a", "a", 4, "b", new Date(), new ArrayList<>());
//        ResultEntity<List<Float>> resultEntity = new ResultEntity<>(200, "获取成功", data);
//
//        Log.e("TAG", "onCreate: " + new Gson().toJson(resultEntity));
        SpareData.init();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SpareData.destroy();
    }
}

