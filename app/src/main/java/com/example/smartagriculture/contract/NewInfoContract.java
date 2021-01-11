package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.PondDataList;
import com.example.smartagriculture.view.IView;

import java.util.List;

public interface NewInfoContract {

    interface View extends IView{
        void getDataSuccess(List<PondDataList> pondDataList);
    }

    interface Presenter{
        void getPondData(int pondId);
    }

}
