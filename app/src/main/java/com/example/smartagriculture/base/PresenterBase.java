package com.example.smartagriculture.base;

import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.IModel;
import com.example.smartagriculture.presenter.IPresenter;
import com.example.smartagriculture.view.IView;

import okhttp3.internal.Internal;

public abstract class PresenterBase<T extends IView, K extends ModelBase> implements IPresenter<T> {

    public T mView;
    public K model;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public boolean isViewAttached() {
        return mView != null;
    }

    protected CallBack<String, Integer> callToken = new CallBack<String, Integer>() {
        @Override
        public void onSuccess(String data) {
            mView.onUpdateToken(0);
        }

        @Override
        public void onFail(Integer data) {
            mView.onUpdateToken(data);
        }
    };
}
