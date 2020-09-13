package com.example.xm1.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ClassifyVpTabAdapter extends FragmentPagerAdapter {
    private String[] strings;
    private ArrayList<Fragment> fragments;

    public ClassifyVpTabAdapter(@NonNull FragmentManager fm, String[] strings, ArrayList<Fragment> fragments) {
        super(fm);
        this.strings = strings;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
