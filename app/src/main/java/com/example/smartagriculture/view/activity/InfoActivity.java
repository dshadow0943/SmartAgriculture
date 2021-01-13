package com.example.smartagriculture.view.activity;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.example.smartagriculture.R;
import com.example.smartagriculture.adapter.PagerAdapter;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.base.FragmentBase;
import com.example.smartagriculture.contract.InfoContract;
import com.example.smartagriculture.presenter.InfoPresenter;
import com.example.smartagriculture.view.fragment.HisInfoFragment;
import com.example.smartagriculture.view.fragment.NewInfoFragment;
import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends ActivityBase<InfoPresenter> implements InfoContract.View, View.OnClickListener {

    private String[] tabText = new String[]{"实时数据", "历史数据"};
    private List<FragmentBase> fragments;
    private SegmentTabLayout mTab;
    private ViewPager mVp;
    private ImageView back;
    private int type;
    private int pondId;

    @Override
    protected int getViewId() {
        return R.layout.activity_info;
    }

    @Override
    protected InfoPresenter createPresenter() {
        return new InfoPresenter();
    }

    @Override
    protected void bindLayout() {
        mTab = findViewById(R.id.info_tab);
        mVp = findViewById(R.id.info_vp);
        back = findViewById(R.id.info_back);
        back.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        type = getIntent().getIntExtra(SpareData.INFO_TYPE, 0);
        Log.e("TAG", "initData: " + type);
        pondId = getIntent().getIntExtra(SpareData.POND_ID, 0);
        configViews();
    }

    public void configViews() {
        fragments = new ArrayList<>();
        fragments.add(new NewInfoFragment());
        fragments.add(new HisInfoFragment());
        mTab.setTabData(tabText);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        mVp.setAdapter(pagerAdapter);

        //滑动、点击切换页面
        mTab.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mVp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });


//        mVp.setScrollable(false);

        //滑动、点击切换页面
        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mTab.setCurrentTab(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        if (fragments.size() <= type){
            type = fragments.size()-1;
        }
        mTab.setCurrentTab(type);
        mVp.setCurrentItem(type);
    }

    @Override
    protected void display() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.info_back:
                finish();
                break;
            default:
        }
    }
}