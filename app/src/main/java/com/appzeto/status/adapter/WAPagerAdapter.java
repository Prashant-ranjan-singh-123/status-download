package com.appzeto.status.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.appzeto.status.fragment.WAGuideFragment;
import com.appzeto.status.fragment.WAStatusFragment;

public class WAPagerAdapter extends FragmentPagerAdapter {


    public WAPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new WAStatusFragment();
        }  else {
            return new WAGuideFragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

}
