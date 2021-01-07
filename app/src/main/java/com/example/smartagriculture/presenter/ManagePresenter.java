package com.example.smartagriculture.presenter;

import com.example.smartagriculture.base.PresenterBase;
import com.example.smartagriculture.contract.ManageContract;
import com.example.smartagriculture.entity.PondPruneEntity;

import java.util.ArrayList;
import java.util.List;

public class ManagePresenter extends PresenterBase<ManageContract.View> implements ManageContract.Presenter {

    @Override
    public void getPondPrunes() {
        List<PondPruneEntity> ponds = new ArrayList<>();
        ponds.add(new PondPruneEntity(1, "a"));
        ponds.add(new PondPruneEntity(2, "b"));
        ponds.add(new PondPruneEntity(3, "c"));
        ponds.add(new PondPruneEntity(4, "d"));
        ponds.add(new PondPruneEntity(5, "e"));

        mView.getDataSuccess(ponds);
    }
}
