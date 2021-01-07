package com.example.smartagriculture.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.RegisterContract;
import com.example.smartagriculture.presenter.RegisterPresenter;

public class RegisterActivity extends ActivityBase<RegisterPresenter> implements RegisterContract.View {

    @Override
    protected int getViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter();
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