package com.example.smartagriculture.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.smartagriculture.base.FragmentBase;

import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {

    private List<FragmentBase> listFragment;

    public PagerAdapter(FragmentManager fm, List<FragmentBase> listFragment) {
        super(fm);
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int i) {
        return listFragment.get(i);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

}
