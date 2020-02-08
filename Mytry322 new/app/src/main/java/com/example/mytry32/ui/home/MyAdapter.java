package com.example.mytry32.ui.home;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class MyAdapter extends FragmentPagerAdapter {
    private List<String> title;
    private List<Fragment> views;

    public MyAdapter(FragmentManager fm, List<String> title, List<Fragment> views) {
        super(fm);
        this.title = title;
        this.views = views;
    }

    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getCount() {
        return views.size();
    }


    //配置标题的方法
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position % title.size());
    }
    @Override
    public void destroyItem(ViewGroup container ,int po,Object object){
        super.destroyItem(container,po,object);
    }
}
