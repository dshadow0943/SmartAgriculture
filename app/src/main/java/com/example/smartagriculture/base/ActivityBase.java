package com.example.smartagriculture.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartagriculture.presenter.IPresenter;
import com.example.smartagriculture.utils.Utils;
import com.example.smartagriculture.view.IView;
import com.example.smartagriculture.view.activity.LoginActivity;
import com.example.smartagriculture.view.dialog.LoginDialog;

public abstract class ActivityBase<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        statusBarSetting();
        Utils.init(this);
        bindLayout();
        initPresenter();
        initData();
    }

    //获取ViewId
    protected abstract int getViewId();

    //创建一个Presenter
    protected abstract T createPresenter();

    //绑定布局控件
    protected abstract void bindLayout();

    protected abstract void initData();

    protected abstract void display();

    public Context getContext(){
        return this;
    }

    //状态栏导航栏设置
    protected void statusBarSetting(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    protected void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    protected void startOnClick(View.OnClickListener obj, View... views){
        for (View view:views){
            view.setOnClickListener(obj);
        }
    }

    @Override
    public void onUpdateToken(int status) {
        Log.e("TAG", "onUpdateToken: " + status);
        switch (status){
            case 0: initData();
            break;
            case 1: jump();
                break;
        }
    }

    private void jump(){
        LoginDialog.login(this, LoginActivity.class);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
