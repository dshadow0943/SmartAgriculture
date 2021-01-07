package com.example.smartagriculture.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.LoginContract;
import com.example.smartagriculture.presenter.LoginPresenter;

public class LoginActivity extends ActivityBase<LoginPresenter> implements LoginContract.View {

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void bindLayout() {

    }

    @Override
    protected int getViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void display() {

    }
}