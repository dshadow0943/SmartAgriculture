package com.example.smartagriculture.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RadioButton;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.SensorPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;

import java.util.List;

public class DeviceAdapter extends CommonRecyclerAdapter<SensorPruneEntity> {


    public DeviceAdapter(Context context, List<SensorPruneEntity> dataList, int layoutId, AdapterListener<View> clickCommonListener) {
        super(context, dataList, layoutId, clickCommonListener);
    }

    @Override
    protected void bindData(CommonRecyclerHolder holder, SensorPruneEntity data) {
        holder.setText(R.id.device_name, data.getName());
        RadioButton radioButton = holder.getView(R.id.device_switch);
        radioButton.setOnClickListener(holder);
        radioButton.setChecked(true);

    }
}
