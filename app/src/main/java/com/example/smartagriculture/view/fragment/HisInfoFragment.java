package com.example.smartagriculture.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.HisInfoContract;
import com.example.smartagriculture.presenter.HisInfoPresenter;

public class HisInfoFragment extends FragmentBase<HisInfoPresenter> implements HisInfoContract.View {

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

    }

    @Override
    public void initData() {

    }

    @Override
    protected void display() {

    }
}