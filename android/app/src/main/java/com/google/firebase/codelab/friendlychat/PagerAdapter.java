package com.google.firebase.codelab.friendlychat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ShaharAlush on 12/12/2016.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    private static int num_item;

    public PagerAdapter(FragmentManager fragmentManager, int num) {
        super(fragmentManager);
        this.num_item = num;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return num_item;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return My_Fragment.newInstance(position, "Page # "+position);
    }
}