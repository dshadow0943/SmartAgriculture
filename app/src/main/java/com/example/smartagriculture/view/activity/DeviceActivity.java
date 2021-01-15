package com.example.smartagriculture.view.activity;

import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.DeviceAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.DeviceContract;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.presenter.DevicePresenter;

import java.util.List;

public class DeviceActivity extends ActivityBase<DevicePresenter> implements DeviceContract.View, View.OnClickListener, AdapterListener<View> {

    private RecyclerView rDevice;
    private List<SensorPruneEntity> devices;

    @Override
    protected int getViewId() {
        return R.layout.activity_device;
    }

    @Override
    protected DevicePresenter createPresenter() {
        return new DevicePresenter();
    }

    @Override
    protected void bindLayout() {
        rDevice = findViewById(R.id.device_list);
    }

    @Override
    protected void initData() {
        int pondId = getIntent().getIntExtra(SpareData.POND_ID, 0);
        mPresenter.getDevice(pondId);
    }

    @Override
    protected void display() {
        rDevice.setLayoutManager(new LinearLayoutManager(this));
        DeviceAdapter adapter = new DeviceAdapter(this, devices, R.layout.recyler_device, this);
        rDevice.setAdapter(adapter);
    }

    @Override
    public void getDeviceSuccess(List<SensorPruneEntity> devices) {
        this.devices = devices;
        display();
    }

    @Override
    public void controlDeviceSuccess(int m) {
        Toast.makeText(this, "设备控制返回值为: " + m, Toast.LENGTH_SHORT).show();
        switch (m){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onClickListener(View data, int position) {
        switch (data.getId()){
            case R.id.device_switch:
                mPresenter.controlDevice(devices.get(position).getId());
        }
    }

    @Override
    public void onLongClickListener(View data, int position) {

    }
}