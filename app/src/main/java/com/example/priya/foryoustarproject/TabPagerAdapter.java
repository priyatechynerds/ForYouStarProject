package com.example.priya.foryoustarproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by PRIYA on 3/15/2018.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    String [] tabArray=new String[]{"ABOUT COMPANY","SUPPORT","DOWNLOADS"};
    Integer tabno=3;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabArray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {


        }


        return null;
    }

    @Override
    public int getCount() {
        return tabno;
    }
}
