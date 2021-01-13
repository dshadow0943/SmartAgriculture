package com.example.smartagriculture.view.activity;

import android.os.Bundle;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.PondAddContract;
import com.example.smartagriculture.presenter.PondAddPresenter;

public class PondAddActivity extends ActivityBase<PondAddPresenter> implements PondAddContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pond_add);
    }

    @Override
    protected int getViewId() {
        return R.layout.activity_pond_add;
    }

    @Override
    protected PondAddPresenter createPresenter() {
        return new PondAddPresenter();
    }

    @Override
    protected void bindLayout() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void display() {

    }
}