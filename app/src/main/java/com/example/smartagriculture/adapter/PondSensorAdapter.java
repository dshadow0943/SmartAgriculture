package com.example.smartagriculture.adapter;

import android.content.Context;
import android.view.View;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;

import java.util.List;

public class PondSensorAdapter extends CommonRecyclerAdapter<PondPruneEntity> {

    public PondSensorAdapter(Context context, List<PondPruneEntity> dataList, int layoutId, AdapterListener<View> clickCommonListener) {
        super(context, dataList, layoutId, clickCommonListener);
    }

    @Override
    protected void bindData(CommonRecyclerHolder holder, PondPruneEntity data) {
        holder.setText(R.id.field_key, data.getName());
        holder.setViewVisibility(R.id.pond_field_img, View.VISIBLE);
    }

}
