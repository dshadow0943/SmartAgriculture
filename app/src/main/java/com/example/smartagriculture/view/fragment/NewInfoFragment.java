package com.example.smartagriculture.view.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.NewInfoAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.NewInfoContract;
import com.example.smartagriculture.entity.PondDataList;
import com.example.smartagriculture.interfaces.AdapterListener;
import com.example.smartagriculture.presenter.NewInfoPresenter;

import java.util.List;

public class NewInfoFragment extends FragmentBase<NewInfoPresenter> implements NewInfoContract.View, AdapterListener<View> {

    private RecyclerView rData;
    private List<PondDataList> pondDataLists;

    @Override
    protected int getViewId() {
        return R.layout.fragment_new_info;
    }

    @Override
    protected NewInfoPresenter createPresenter() {
        return new NewInfoPresenter();
    }

    @Override
    protected void bindLayout() {
        rData = view.findViewById(R.id.new_list);
    }

    @Override
    public void initData() {
        mPresenter.getPondData(SpareData.getIntData(SpareData.INFO_POND_ID));
    }

    @Override
    protected void display() {
        rData.setLayoutManager(new LinearLayoutManager(getContext()));
        NewInfoAdapter adapter = new NewInfoAdapter(getContext(), pondDataLists, R.layout.recycler_new_info, this);
        rData.setAdapter(adapter);
    }

    @Override
    public void getDataSuccess(List<PondDataList> pondDataList) {
        Log.e("TAG", "new-getDataSuccess: " + pondDataList);
        this.pondDataLists = pondDataList;
        display();
    }


    @Override
    public void onClickListener(View data, int position) {

    }

    @Override
    public void onLongClickListener(View data, int position) {

    }
}