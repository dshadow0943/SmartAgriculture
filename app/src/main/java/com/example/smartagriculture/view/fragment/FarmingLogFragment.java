package com.example.smartagriculture.view.fragment;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.FarmingLogContract;
import com.example.smartagriculture.presenter.FarmingLogPresenter;

public class FarmingLogFragment extends FragmentBase<FarmingLogPresenter> implements FarmingLogContract.View {
    
    @Override
    protected int getViewId() {
        return R.layout.fragment_farming_log;
    }

    @Override
    protected FarmingLogPresenter createPresenter() {
        return new FarmingLogPresenter();
    }

    @Override
    protected void bindLayout() {

    }

    @Override
    public void initData() {

    }

    @Override
    protected void display() {

    }

}