package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.PondEntity;
import com.example.smartagriculture.view.IView;

public interface PondNewsContract {

    interface View extends IView{
        void getDataSuccess(PondEntity pond);
    }

    interface Presenter{
        void getPondEntity(int pondId);
    }

}
