package com.example.smartagriculture.contract;

import com.example.smartagriculture.view.IView;

public interface RegisterContract {

    interface View extends IView{
        void registerSuccess();
        void registerFailed();

    }

    interface Presenter{
        void register(String name, String phone, String pwd);
    }

}
