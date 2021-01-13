package com.example.smartagriculture.view.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.PondFieldAdapter;
import com.example.smartagriculture.adapter.PondSensorAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.PondNewsContract;
import com.example.smartagriculture.entity.MapEntity;
import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.presenter.PondNewsPresenter;
import com.example.smartagriculture.utils.EntityToMap;

import java.util.ArrayList;
import java.util.List;

public class PondNewsActivity extends ActivityBase<PondNewsPresenter> implements PondNewsContract.View, View.OnClickListener, AdapterListener<View> {

    private int pondId;
    private PondEntity pond;
    private List<MapEntity<String, String>> fields;
    private List<PondPruneEntity> sensors;

    private TextView tName;
    private TextView tTile;
    private RelativeLayout iField;
    private RelativeLayout iSensor;
    private RecyclerView rField;
    private RecyclerView rSensor;

    @Override
    protected int getViewId() {
        return R.layout.activity_pond_news;
    }

    @Override
    protected PondNewsPresenter createPresenter() {
        return new PondNewsPresenter();
    }

    @Override
    protected void bindLayout() {
        tName = findViewById(R.id.pond_name);
        tTile = findViewById(R.id.pond_title);
        iField = findViewById(R.id.pond_field);
        iSensor = findViewById(R.id.pond_sensor);
        rField = findViewById(R.id.pond_field_list);
        rSensor = findViewById(R.id.pond_sensor_list);

        iField.setOnClickListener(this);
        iSensor.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        pondId = getIntent().getIntExtra(SpareData.POND_ID, 0);
        if (pondId == 0){
            Toast.makeText(this, "未知错误", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        mPresenter.getPondEntity(pondId);
    }

    @Override
    protected void display() {
        tName.setText(pond.getName());
        tTile.setText("塘口—" + pond.getName());
        config();
    }

    private void config(){
        rField.setLayoutManager(new LinearLayoutManager(getContext()));
        PondFieldAdapter fieldAdapter = new PondFieldAdapter(this, fields, R.layout.recyler_pond_field, this);
        rField.setAdapter(fieldAdapter);

        rSensor.setLayoutManager(new LinearLayoutManager(getContext()));
        PondSensorAdapter sensorAdapter = new PondSensorAdapter(this, sensors, R.layout.recyler_pond_field, this);
        rSensor.setAdapter(sensorAdapter);
    }

    @Override
    public void getDataSuccess(PondEntity pond) {
        this.pond = pond;
        fields = EntityToMap.pondToMap(pond);
        sensors = pond.getSensors();
        if (sensors == null){
            sensors = new ArrayList<>();
        }
        display();
    }

    @Override
    public void onClickListener(View data, int position) {

    }

    @Override
    public void onLongClickListener(View data, int position) {

    }

    @Override
    public void onClick(View v) {

    }
}