package com.example.smartagriculture.view.fragment;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.UserContract;
import com.example.smartagriculture.presenter.UserPresenter;

public class UserFragment extends FragmentBase<UserPresenter> implements UserContract.View {

    @Override
    protected int getViewId() {
        return R.layout.fragment_user;
    }

    @Override
    protected UserPresenter createPresenter() {
        return new UserPresenter();
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