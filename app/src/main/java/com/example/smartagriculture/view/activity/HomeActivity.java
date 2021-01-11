package com.example.smartagriculture.view.activity;

import android.graphics.Color;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.smartagriculture.R;
import com.example.smartagriculture.api.SpareData;
import com.example.smartagriculture.base.ActivityBase;
import com.example.smartagriculture.contract.HomeContract;
import com.example.smartagriculture.presenter.HomePresenter;
import com.example.smartagriculture.view.fragment.AskExpertFragment;
import com.example.smartagriculture.view.fragment.FarmingLogFragment;
import com.example.smartagriculture.view.fragment.ManageFragment;
import com.example.smartagriculture.view.fragment.UserFragment;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends ActivityBase<HomePresenter> implements HomeContract.View {

    private EasyNavigationBar navigationBar;

    private String[] tabText = new String[]{"数据管理", "养殖日志", "专家问答", "个人中心"};
    //未选中icon
    private int[] normalIcon = {R.drawable.ic_home_data_un, R.drawable.ic_home_farming_un, R.drawable.ic_home_expert_un, R.drawable.ic_home_user_un};
    //选中时icon
    private int[] selectIcon = {R.drawable.ic_home_data, R.drawable.ic_home_farming, R.drawable.ic_home_expert, R.drawable.ic_home_user};

    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected int getViewId() {
        return R.layout.activity_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void bindLayout() {
        navigationBar = findViewById(R.id.navigationBar);
    }

    @Override
    protected void initData() {
        Log.e("TAG", "initData: ");
        configViews();
    }

    public void configViews() {
        fragments.add(new ManageFragment());
        fragments.add(new FarmingLogFragment());
        fragments.add(new AskExpertFragment());
        fragments.add(new UserFragment());
        navigationBar.titleItems(tabText) //必传  Tab文字集合
                .normalIconItems(normalIcon) //必传  Tab未选中图标集合
                .selectIconItems(selectIcon) //必传  Tab选中图标集合
                .normalTextColor(Color.parseColor("#8a8a8a"))   //Tab未选中时字体颜色
                .selectTextColor(Color.parseColor("#7C99FF"))   //Tab选中时字体颜色
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        if (position == 2) {

                        }
                        return false;
                    }
                })
                .fragmentList(fragments) //必传  fragment集合
                .fragmentManager(getSupportFragmentManager()) //必传
                .anim(Anim.ZoomInUp)
                .build();
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if ((System.currentTimeMillis() - exitTime) > 2000)
            {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                SpareData.destroy();
                System.exit(0);
            }

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void display() {

    }
}