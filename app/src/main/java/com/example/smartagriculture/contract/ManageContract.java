package com.example.smartagriculture.contract;

import com.example.smartagriculture.entity.PondPruneEntity;
import com.example.smartagriculture.view.IView;

import java.util.List;

public interface ManageContract {

    interface View extends IView{
        public void getDataSuccess(List<PondPruneEntity> ponds);
    }

    interface Presenter{
        public void getPondPrunes();
    }

}
