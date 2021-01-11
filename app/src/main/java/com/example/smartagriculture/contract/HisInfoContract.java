package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.HisDataItemEntity;
import com.example.smartagriculture.view.IView;

public interface HisInfoContract {

    interface View extends IView{
        void getDataSuccess(HisDataItemEntity hisDataItem);
    }

    interface Presenter{
        void getHisData(int pondId);
    }

}
