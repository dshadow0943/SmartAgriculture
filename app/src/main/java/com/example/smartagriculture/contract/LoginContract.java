package com.example.smartagriculture.contract;

import com.example.smartagriculture.view.IView;

public interface LoginContract {

    interface View extends IView{
        void loginSuccess();
        void loginFailed(String msg);
    }

    interface Presenter{
        void userLogin(String phone, String pwd);
    }
}
