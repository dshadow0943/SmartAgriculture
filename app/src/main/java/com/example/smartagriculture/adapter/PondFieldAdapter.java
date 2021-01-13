package com.example.smartagriculture.adapter;

import android.content.Context;
import android.view.View;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.MapEntity;
import com.example.smartagriculture.interfaces.AdapterListener;

import java.util.List;

public class PondFieldAdapter extends CommonRecyclerAdapter<MapEntity<String, String>> {

    public PondFieldAdapter(Context context, List<MapEntity<String, String>> dataList, int layoutId, AdapterListener<View> clickCommonListener) {
        super(context, dataList, layoutId, clickCommonListener);
    }

    @Override
    protected void bindData(CommonRecyclerHolder holder, MapEntity<String, String> data) {
        holder.setText(R.id.field_key, data.getKey());
        holder.setText(R.id.field_value, data.getValue());
    }

}
