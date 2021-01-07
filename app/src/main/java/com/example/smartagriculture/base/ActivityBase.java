package com.example.smartagriculture.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartagriculture.presenter.IPresenter;
import com.example.smartagriculture.interfaces.TokenCallback;
import com.example.smartagriculture.view.IView;

public abstract class ActivityBase<T extends IPresenter> extends AppCompatActivity implements IView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getViewId());
        statusBarSetting();
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
//
//    public void updateToken() {
//        if (!mPresenter.isUserData()) {
//            LoginDialog.login(this, LoginActivity.class);
//            return;
//        }
//
//        mPresenter.getToken(new TokenCallback() {
//            @Override
//            public void getTokenSuccess(String token) {
//                SpareData.putStringData(SpareData.TOKEN, token);
//                updateData();
//            }
//
//            @Override
//            public void getTokenFailed(int code, String msg) {
//                if (code == 0){
//                    Toast.makeText(getContext(), "网络连接错误", Toast.LENGTH_SHORT).show();
//                } else {
//                    LoginDialog.login(getContext(), LoginActivity.class);
//                }
//            }
//        });
//    }

    protected void updateData(){

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
