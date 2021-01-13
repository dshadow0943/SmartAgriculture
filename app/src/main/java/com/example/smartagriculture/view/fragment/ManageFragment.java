package com.example.smartagriculture.view.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.PondAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.ManageContract;
import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.presenter.ManagePresenter;
import com.example.smartagriculture.view.activity.DeviceActivity;
import com.example.smartagriculture.view.activity.InfoActivity;
import com.example.smartagriculture.view.activity.PondAddActivity;
import com.example.smartagriculture.view.activity.PondNewsActivity;

import java.util.List;

public class ManageFragment extends FragmentBase<ManagePresenter> implements ManageContract.View, View.OnClickListener, AdapterListener<View> {

    private List<PondPruneEntity> ponds;
    private RecyclerView rPond;
    private ImageView iAdd;

    @Override
    protected int getViewId() {
        return R.layout.fragment_manage;
    }

    @Override
    protected ManagePresenter createPresenter() {
        return new ManagePresenter();
    }

    @Override
    protected void bindLayout() {
        rPond = view.findViewById(R.id.manage_ponds);
        iAdd = view.findViewById(R.id.pond_add);
        iAdd.setOnClickListener(this);
    }

    @Override
    public void initData() {
        mPresenter.getPondPrunes();
    }

    @Override
    protected void display() {
        rPond.setLayoutManager(new LinearLayoutManager(getContext()));
        PondAdapter pondAdapter = new PondAdapter(getContext(), ponds, this);
        rPond.setAdapter(pondAdapter);
    }

    @Override
    public void getDataSuccess(List<PondPruneEntity> ponds) {
        this.ponds = ponds;
        display();
    }

    @Override
    public void onClickListener(View v, int position) {
        SpareData.putIntData(SpareData.POND_ID, ponds.get(position).getId());
        switch (v.getId()){
            case R.id.pond_name:
                break;
            case R.id.pond_new:
                Intent intentNew = new Intent(getContext(), InfoActivity.class);
                intentNew.putExtra(SpareData.INFO_TYPE, 0);
                intentNew.putExtra(SpareData.POND_ID, ponds.get(position).getId());
                SpareData.putIntData(SpareData.INFO_POND_ID, ponds.get(position).getId());
                startActivity(intentNew);
                break;
            case R.id.pond_his:
                Intent intentHis = new Intent(getContext(), InfoActivity.class);
                intentHis.putExtra(SpareData.INFO_TYPE, 1);
                intentHis.putExtra(SpareData.POND_ID, ponds.get(position).getId());
                SpareData.putIntData(SpareData.INFO_POND_ID, ponds.get(position).getId());
                startActivity(intentHis);
                break;
            case R.id.pond_control:
                break;
            case R.id.pond_full:
                Intent intentFull = new Intent(getContext(), PondNewsActivity.class);
                intentFull.putExtra(SpareData.POND_ID, ponds.get(position).getId());
                SpareData.putIntData(SpareData.INFO_POND_ID, ponds.get(position).getId());
                startActivity(intentFull);
                break;
            case R.id.pond_manage_device:
                Intent intentDevice = new Intent(getContext(), DeviceActivity.class);
                intentDevice.putExtra(SpareData.POND_ID, ponds.get(position).getId());
                startActivity(intentDevice);
                break;
            default:
                break;
        }
    }

    @Override
    public void onLongClickListener(View data, int position) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pond_add:
                startActivity(new Intent(getContext(), PondAddActivity.class));
                break;
        }
    }
}