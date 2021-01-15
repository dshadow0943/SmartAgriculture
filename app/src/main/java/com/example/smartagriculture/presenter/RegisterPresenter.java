package com.example.smartagriculture.presenter;

import android.widget.Toast;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.RegisterContract;
import com.example.smartagriculture.interfaces.CallBack;
import com.example.smartagriculture.model.RegisterModel;
import com.example.smartagriculture.utils.Utils;

public class RegisterPresenter extends PresenterBase<RegisterContract.View, RegisterModel> implements RegisterContract.Presenter {

    public RegisterPresenter() {
        model = new RegisterModel();
    }

    @Override
    public void register(String name, String phone, String pwd) {
        model.register(name, phone, pwd, new CallBack<Integer, String>() {
            @Override
            public void onSuccess(Integer data) {
                mView.registerSuccess();
            }

            @Override
            public void onFail(String data) {
                Toast.makeText(Utils.getContext(), data, Toast.LENGTH_SHORT).show();
                mView.registerFailed();
            }
        });
    }
}
