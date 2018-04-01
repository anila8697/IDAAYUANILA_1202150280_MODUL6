package com.example.android.idaayuanila_1202150280_modul6;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

    public class PageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;


    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TimelineFragment();

            case 1:
                return new ProfileFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}