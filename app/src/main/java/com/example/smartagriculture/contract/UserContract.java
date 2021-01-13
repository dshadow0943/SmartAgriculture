package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.UserEntity;
import com.example.smartagriculture.view.IView;

public interface UserContract {

    interface View extends IView{
        public void getDataSuccess(UserEntity user);
    }

    interface Presenter{
        public void getUserNews();
    }

}
