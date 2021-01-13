package com.example.smartagriculture.view.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.HisInfoAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.HisInfoContract;
import com.example.smartagriculture.entity.HisDataItemEntity;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.presenter.HisInfoPresenter;

import java.util.ArrayList;
import java.util.List;


public class HisInfoFragment extends FragmentBase<HisInfoPresenter> implements HisInfoContract.View, View.OnClickListener, AdapterListener<View> {

    private RecyclerView rList;
    private List<HisDataItemEntity> hisDataItems = null;
    HisInfoAdapter adapter;

    @Override
    protected int getViewId() {
        return R.layout.fragment_his_info;
    }

    @Override
    protected HisInfoPresenter createPresenter() {
        return new HisInfoPresenter();
    }

    @Override
    protected void bindLayout() {
        rList = view.findViewById(R.id.his_list);
    }

    @Override
    public void initData() {
        hisDataItems = null;
        mPresenter.getHisData(SpareData.getIntData(SpareData.INFO_POND_ID));
    }

    @Override
    protected void display() {
        rList.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HisInfoAdapter(getContext(), hisDataItems, this);
        rList.setAdapter(adapter);
    }

    @Override
    public void getDataSuccess(HisDataItemEntity hisDataItem) {
        if (hisDataItem == null){
            return;
        }
        Log.e("TAG", "His-getDataSuccess: " + hisDataItem.toString());
        if (hisDataItems == null){
            hisDataItems = new ArrayList<>();
            display();
        }
        for (int i = 0; i < hisDataItems.size(); i++) {
            if (hisDataItem.getTitle().equals(hisDataItems.get(i).getTitle())){
                adapter.removeData(i);
                adapter.addData(hisDataItem, i);
                return;
            }
        }
        adapter.addData(hisDataItem);
    }

    @Override
    public void onClick(View v) {
        switch (view.getId()) {

            default:
                break;
        }
    }

    @Override
    public void onClickListener(View data, int position) {
    }

    @Override
    public void onLongClickListener(View data, int position) {

    }

}