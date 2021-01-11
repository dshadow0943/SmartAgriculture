package com.example.smartagriculture.view.fragment;

import com.example.smartagriculture.R;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.AskExpertComtract;
import com.example.smartagriculture.presenter.AskExpertPresenter;

public class AskExpertFragment extends FragmentBase<AskExpertPresenter> implements AskExpertComtract.View {

    @Override
    protected int getViewId() {
        return R.layout.fragment_ask_expert;
    }

    @Override
    protected AskExpertPresenter createPresenter() {
        return null;
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