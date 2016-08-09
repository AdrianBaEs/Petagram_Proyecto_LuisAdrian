package com.luisadrian.petagram;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by luisadrian on 8/8/16.
 */
public class ViewPagerAdaptador extends FragmentPagerAdapter {

    ArrayList<Fragment> fragmentsMainActivity;

    public ViewPagerAdaptador(FragmentManager fm, ArrayList<Fragment> fragmentsMainActivity) {
        super(fm);
        this.fragmentsMainActivity=fragmentsMainActivity;
    }
    @Override
    public Fragment getItem(int position) {
        return fragmentsMainActivity.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsMainActivity.size();
    }
}
