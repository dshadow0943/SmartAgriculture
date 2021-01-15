package com.example.smartagriculture.view.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.smartagriculture.R;
import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.UserContract;
import com.example.smartagriculture.entity.UserEntity;
import com.example.smartagriculture.presenter.UserPresenter;
import com.example.smartagriculture.view.activity.LoginActivity;
import com.example.smartagriculture.view.dialog.LoginDialog;

public class UserFragment extends FragmentBase<UserPresenter> implements UserContract.View, View.OnClickListener {

    private ImageView iAvatar;
    private TextView tName;
    private LinearLayout lAlterPwd;
    private LinearLayout lAlterData;
    private LinearLayout lOut;

    UserEntity userEntity;

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
        iAvatar = view.findViewById(R.id.user_avatar);
        tName = view.findViewById(R.id.user_name);
        lAlterData = view.findViewById(R.id.user_alter_data);
        lAlterPwd = view.findViewById(R.id.user_alter_pwd);
        lOut = view.findViewById(R.id.user_out);

        lAlterPwd.setOnClickListener(this);
        lAlterData.setOnClickListener(this);
        lOut.setOnClickListener(this);
        view.findViewById(R.id.user_empty).setOnClickListener(this);

    }

    @Override
    public void initData() {
        mPresenter.getUserNews();
    }

    @Override
    protected void display() {
        tName.setText(userEntity.getName());
        Glide.with(this)
                .load(HttpDataSource.API+ userEntity.getAvatar())
                .error(R.mipmap.ic_user_avatar_default)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(iAvatar);
    }

    @Override
    public void getDataSuccess(UserEntity user) {
        if (user == null){
            return;
        }
        this.userEntity = user;
        display();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_out:
                LoginDialog.loginOut(getContext(), LoginActivity.class);
                break;
            case R.id.user_empty:
                LoginDialog.DataEmpty(this);
//                initData();
                break;
        }
    }
}