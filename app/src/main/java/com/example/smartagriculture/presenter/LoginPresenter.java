package com.example.smartagriculture.presenter;

import android.util.Log;

import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.api.source.http.HttpDataSource;
import com.example.smartagriculture.api.source.local.LocalDataSource;
import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.LoginContract;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.LoginModel;

public class LoginPresenter extends PresenterBase<LoginContract.View, LoginModel> implements LoginContract.Presenter {

    public LoginPresenter() {
        model = new LoginModel();
    }

    @Override
    public void userLogin(String phone, String pwd) {
        model.getToken(phone, pwd, new CallBack<String, String>() {
            @Override
            public void onSuccess(String data) {
                Log.e("TAG", "onSuccess: " + data);
                LocalDataSource localSource = LocalDataSource.getInstance();
                localSource.saveLogin(phone);
                localSource.savePassword(pwd);
                localSource.saveToken(data);
                SpareData.putStringData(SpareData.TOKEN, data);
                HttpDataSource.destroyInstance();
                mView.loginSuccess();
            }

            @Override
            public void onFail(String data) {
                mView.loginFailed(data);
            }
        });
    }
}
