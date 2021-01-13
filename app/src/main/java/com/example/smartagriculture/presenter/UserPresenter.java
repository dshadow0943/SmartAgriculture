package com.example.smartagriculture.presenter;

import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.UserContract;
import com.example.smartagriculture.entity.ResultEntity;
import com.example.smartagriculture.entity.UserEntity;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.UserModel;
import com.example.smartagriculture.utils.Utils;

public class UserPresenter extends PresenterBase<UserContract.View, UserModel> implements UserContract.Presenter {

    public UserPresenter() {
        model = new UserModel();
    }

    @Override
    public void getUserNews() {
        model.getUserNews(new CallBack<ResultEntity<UserEntity>, String>() {
            @Override
            public void onSuccess(ResultEntity<UserEntity> data) {
                if (data.getCode() == 200){
                    mView.getDataSuccess(data.getData());
                } else if (data.getCode() == 416){
                    model.update(callToken);
                }
            }

            @Override
            public void onFail(String data) {
                Toast.makeText(Utils.getContext(), data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
