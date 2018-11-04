package com.alisakralarabygmail.cairotourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ali on 8/21/2017.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {

        super(fm);
        this.context = context;
    }



    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new HistoricalPlacesFragment();
        }else if (position == 1){
            return new EntertainmentPlacesFragment();
        }else if (position == 2){
            return new FoodNDrinksFragment();
        }else if (position == 3){
            return new ShoppingPlacesFragment();
        }else {
            return new ParksNGardensFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String tabNames[] = context.getResources().getStringArray(R.array.tab_names);
        return tabNames[position];
    }
}
