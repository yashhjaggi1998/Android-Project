package com.example.yashhjaggi.helloworld;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentStatePagerAdapter
{

    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitles = new ArrayList<>();

    int mNoOftabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOftabs = NumberOfTabs;
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return lstTitles.get(position);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            case 1:
                Tab2 tab2 = new Tab2();
                return lstFragment.get(position);
            default:
                return null;
        }
    }

    @Override
    public int getCount()
     {
        return lstTitles.size();
    }

    public void AddFragment(Fragment fragment, String title)
    {
        lstFragment.add(fragment);
        lstTitles.add(title);
    }


}
