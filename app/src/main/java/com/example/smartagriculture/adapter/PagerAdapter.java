package com.example.smartagriculture.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

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

    public static class NoScrollViewPager extends androidx.viewpager.widget.ViewPager {
        public NoScrollViewPager(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public NoScrollViewPager(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent arg0) {
            return false;
        }

        @Override
        public boolean onInterceptTouchEvent(MotionEvent arg0) {
            return false;
        }
    }

}
