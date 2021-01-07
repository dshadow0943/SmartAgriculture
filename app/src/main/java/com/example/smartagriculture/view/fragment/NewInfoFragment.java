package com.example.smartagriculture.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.NewInfoContract;
import com.example.smartagriculture.presenter.NewInfoPresenter;

public class NewInfoFragment extends FragmentBase<NewInfoPresenter> implements NewInfoContract.View {

    @Override
    protected int getViewId() {
        return R.layout.fragment_new_info;
    }

    @Override
    protected NewInfoPresenter createPresenter() {
        return new NewInfoPresenter();
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