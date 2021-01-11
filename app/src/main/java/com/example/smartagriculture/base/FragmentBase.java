package com.example.smartagriculture.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartagriculture.presenter.IPresenter;
import com.example.smartagriculture.interfaces.TokenCallback;
import com.example.smartagriculture.view.IView;
import com.example.smartagriculture.view.activity.LoginActivity;
import com.example.smartagriculture.view.dialog.LoginDialog;

public abstract class FragmentBase<T extends IPresenter> extends Fragment implements IView {

    protected static final String ARG_PARAM = "param";

    protected String mParam;
    protected T mPresenter;
    protected View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getViewId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        bindLayout();
        initPresenter();
        initData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getString(ARG_PARAM);
        }
    }

    //获取ViewId
    protected abstract int getViewId();

    //创建一个Presenter
    protected abstract T createPresenter();

    //绑定布局控件
    protected abstract void bindLayout();

    //初始化数据
    public abstract void initData();

    //布局数据显示
    protected abstract void display();

    private void initPresenter() {
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
        LoginDialog.login(getContext(), LoginActivity.class);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

}
