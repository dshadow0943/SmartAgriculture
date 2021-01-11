package com.example.smartagriculture.adapter;

import android.content.Context;
import android.view.View;

import com.example.smartagriculture.R;
import com.example.smartagriculture.entity.PondDataList;
import com.example.smartagriculture.interfaces.AdapterListener;

import java.util.List;

public class NewInfoAdapter extends CommonRecyclerAdapter<PondDataList> {


    public NewInfoAdapter(Context context, List<PondDataList> dataList, int layoutId, AdapterListener<View> clickCommonListener) {
        super(context, dataList, layoutId, clickCommonListener);
    }

    @Override
    protected void bindData(CommonRecyclerHolder holder, PondDataList data) {
        holder.getView(R.id.info_query).setOnClickListener(holder);
        holder.setText(R.id.info_title, data.getTitle());
        holder.setText(R.id.info_value, data.getValue() + data.getUnit());
    }
}
