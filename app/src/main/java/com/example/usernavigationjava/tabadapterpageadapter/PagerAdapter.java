package com.example.usernavigationjava.tabadapterpageadapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.usernavigationjava.fragments.TabFragment1;
import com.example.usernavigationjava.fragments.TabFragment2;
import com.example.usernavigationjava.fragments.TabFragment3;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm, numOfTabs);
        this.mNumOfTabs = numOfTabs;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TabFragment1();
            case 1: return new TabFragment2();
            default:return null;
        }
    }
}
